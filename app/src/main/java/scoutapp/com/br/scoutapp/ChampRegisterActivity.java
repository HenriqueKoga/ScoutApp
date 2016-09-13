package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

import scoutapp.com.br.scoutapp.controller.ChampionshipController;
import scoutapp.com.br.scoutapp.helper.ChampRegisterHelper;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;

public class ChampRegisterActivity extends AppCompatActivity {

    private ChampRegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champ_registrer);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        Intent intentChamp = getIntent();
        Championship championship = (Championship) intentChamp.getSerializableExtra("championship");

        Intent intentAthlete = getIntent();
        Athlete athleteOpponent = (Athlete) intentAthlete.getSerializableExtra("athlete_opponent");

        helper = new ChampRegisterHelper(this, athleteOpponent);

        if (championship != null) {
            championship.setAthleteId(athleteOpponent.getId());
            helper.fillChampionshipRegister(championship);
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
        Championship championship = helper.getChampionship();
        Intent intent = getIntent();
        Athlete athleteUser = (Athlete) intent.getSerializableExtra("user");
        Athlete athleteOpponent = (Athlete) intent.getSerializableExtra("athlete_opponent");
        ChampionshipController championshipController = new ChampionshipController(this);

        switch (item.getItemId()) {
            case R.id.menu_save_champ:
                championship.setAthleteId(athleteOpponent.getId());
//                championshipController.insertOrReplaceChamp(championship);

                Intent intentScout = new Intent(ChampRegisterActivity.this, ScoutActivity.class);
                intentScout.putExtra("championship", championship);
                intentScout.putExtra("user", athleteUser);
                intentScout.putExtra("athlete_opponent", athleteOpponent);
                Toast.makeText(ChampRegisterActivity.this, "Championship " + championship.getChampName(), Toast.LENGTH_SHORT).show();
                startActivity(intentScout);
                finish();
                break;

            case android.R.id.home:
                championship.setAthleteId(athleteOpponent.getId());
//                championshipController.insertOrReplaceChamp(championship);

                Intent intentRegister = new Intent(ChampRegisterActivity.this, RegisterActivity.class);
                intentRegister.putExtra("championship", championship);
                intentRegister.putExtra("athlete_opponent", athleteOpponent);
                intentRegister.putExtra("user", athleteUser);
                startActivity(intentRegister);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
