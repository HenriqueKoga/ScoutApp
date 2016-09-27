package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.controller.ChampionshipController;
import scoutapp.com.br.scoutapp.controller.GameOpponentController;
import scoutapp.com.br.scoutapp.controller.GameUserController;
import scoutapp.com.br.scoutapp.helper.ChampRegisterHelper;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.GameOpponent;
import scoutapp.com.br.scoutapp.model.GameUser;
import scoutapp.com.br.scoutapp.model.User;

public class ChampRegisterActivity extends AppCompatActivity {

    private ChampRegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champ_registrer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        Intent intentAthlete = getIntent();
        Athlete athleteOpponent = (Athlete) intentAthlete.getSerializableExtra("athlete_opponent");
        Championship championship = (Championship) intentAthlete.getSerializableExtra("championship");

        helper = new ChampRegisterHelper(this);

        if (championship != null) {
            try {
                helper.fillChampionshipRegister(championship);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_champ, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Championship championship = null;
        try {
            championship = helper.getChampionship();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Intent intent = getIntent();
        User athleteUser = (User) intent.getSerializableExtra("user");
        Athlete athleteOpponent = (Athlete) intent.getSerializableExtra("athlete_opponent");
        GameOpponent gameOpponent = (GameOpponent) intent.getSerializableExtra("game_opponent");
        GameUser gameUser = (GameUser) intent.getSerializableExtra("game_user");
        ChampionshipController championshipController = new ChampionshipController(this);

        switch (item.getItemId()) {
            case R.id.menu_save_champ:
                championship.setGameOpponentId(athleteOpponent.getId());
                championship.setGameUserId(athleteOpponent.getId());
                championship.setAthleteId(athleteOpponent.getId());
                championshipController.insertOrReplaceChamp(championship);

                Intent intentScout = new Intent(ChampRegisterActivity.this, ScoutActivity.class);
                intentScout.putExtra("championship", championship);
                intentScout.putExtra("game_opponent", gameOpponent);
                intentScout.putExtra("game_user", gameUser);
                intentScout.putExtra("user", athleteUser);
                intentScout.putExtra("athlete_opponent", athleteOpponent);
                Toast.makeText(ChampRegisterActivity.this,championship.getChampName() + " Championship", Toast.LENGTH_SHORT).show();
                startActivity(intentScout);
                finish();
                break;

            case android.R.id.home:
                championship.setAthleteId(athleteOpponent.getId());
                championshipController.insertOrReplaceChamp(championship);

                Intent intentRegister = new Intent(ChampRegisterActivity.this, RegisterActivity.class);
                intentRegister.putExtra("championship", championship);
                intentRegister.putExtra("game_opponent", gameOpponent);
                intentRegister.putExtra("game_user", gameUser);
                intentRegister.putExtra("athlete_opponent", athleteOpponent);
                intentRegister.putExtra("user", athleteUser);
                startActivity(intentRegister);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
