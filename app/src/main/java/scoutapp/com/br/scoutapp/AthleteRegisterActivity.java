package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.WindowManager;

import java.util.ArrayList;
import java.util.List;

import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.controller.ChampionshipController;
import scoutapp.com.br.scoutapp.controller.UserController;
import scoutapp.com.br.scoutapp.helper.AthleteRegisterHelper;
import scoutapp.com.br.scoutapp.model.User;

public class AthleteRegisterActivity extends AppCompatActivity {
    private AthleteRegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_athlete_register);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        AthleteController athleteController = new AthleteController(this);
        athleteController.cleanDB();

        ChampionshipController championshipController = new ChampionshipController(this);
        championshipController.cleanDB();

        UserController userController = new UserController(this);
        userController.cleanDB();

//        UserController userController = new UserController(this);
//        List<User> users =  userController.getAllUser();

        helper = new AthleteRegisterHelper(this);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("user");
        if(user != null){
            helper.fillRegister(user);
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
        User user = helper.getAthlete();
        UserController userController = new UserController(this);

        switch (item.getItemId()) {
            case R.id.menu_save_user:
                userController.insertOrReplaceAthlete(user);
                Intent intentScout = new Intent(AthleteRegisterActivity.this, HomeActivity.class);
                intentScout.putExtra("user", user);
                startActivity(intentScout);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
