package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;

import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.helper.RegisterHelper;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.GameOpponent;
import scoutapp.com.br.scoutapp.model.GameUser;
import scoutapp.com.br.scoutapp.model.User;

public class RegisterActivity extends AppCompatActivity {

    private RegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        helper = new RegisterHelper(this);

        Intent intent = getIntent();
        Athlete athleteOpponent = (Athlete) intent.getSerializableExtra("athlete_opponent");
        if(athleteOpponent != null){
            helper.fillRegister(athleteOpponent);
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
        inflater.inflate(R.menu.menu_register, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem item= menu.findItem(R.id.close);
        item.setVisible(true);
        super.onPrepareOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Athlete athlete = helper.getAthlete();
        Intent intent = getIntent();
        User athleteUser = (User) intent.getSerializableExtra("user");
        Championship championship = (Championship) intent.getSerializableExtra("championship");
        GameOpponent gameOpponent = (GameOpponent) intent.getSerializableExtra("game_opponent");
        GameUser gameUser = (GameUser) intent.getSerializableExtra("game_user");

        AthleteController athleteController = new AthleteController(this);

        switch (item.getItemId()) {
            case R.id.menu_save_athlete:
                athleteController.insertOrReplaceAthlete(athlete);

                Intent intentScout = new Intent(RegisterActivity.this, ChampRegisterActivity.class);
                intentScout.putExtra("athlete_opponent", athlete);
                intentScout.putExtra("championship", championship);
                intentScout.putExtra("game_opponent", gameOpponent);
                intentScout.putExtra("game_user", gameUser);
                intentScout.putExtra("user", athleteUser);
                startActivity(intentScout);
                finish();
                break;

            case android.R.id.home:
                athleteController.insertOrReplaceAthlete(athlete);

                Intent intentHome = new Intent(RegisterActivity.this, HomeActivity.class);
                intentHome.putExtra("athlete_opponent", athlete);
                intentHome.putExtra("championship", championship);
                intentHome.putExtra("game_opponent", gameOpponent);
                intentHome.putExtra("game_user", gameUser);
                intentHome.putExtra("user", athleteUser);
                if(championship != null) {
                    startActivity(intentHome);
                    Toast.makeText(RegisterActivity.this, athlete.getName() + " saved!", Toast.LENGTH_SHORT).show();
                    finish();
                }else{
                    Snackbar snackbar;
                    snackbar = Snackbar.make(getCurrentFocus(), "Register the championship in the next page", Snackbar.LENGTH_INDEFINITE);
                    snackbar.show();
                }
                break;

            case R.id.close:
                Intent intentClose = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intentClose);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
