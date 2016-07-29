package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.helper.AthleteRegisterHelper;
import scoutapp.com.br.scoutapp.model.Athlete;

public class AthleteRegisterActivity extends AppCompatActivity {
    private AthleteRegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        helper = new AthleteRegisterHelper(this);

        Intent intent = getIntent();
        Athlete athleteUser = (Athlete) intent.getSerializableExtra("user");
        if(athleteUser != null){
            helper.fillRegister(athleteUser);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_athlete_register, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Athlete athleteUser = helper.getAthlete();
        AthleteController athleteController = new AthleteController(this);

        switch (item.getItemId()) {
            case R.id.menu_save_user:
                athleteController.insertOrReplaceAthlete(athleteUser);
                Intent intentScout = new Intent(AthleteRegisterActivity.this, HomeActivity.class);
                intentScout.putExtra("user", athleteUser);
                startActivity(intentScout);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
