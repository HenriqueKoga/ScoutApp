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
import android.widget.Toast;

import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.modelo.Campeonato;


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
        Athlete athlete = (Athlete) intent.getSerializableExtra("atleta");
        if(athlete != null){
            helper.preencheCadastro(athlete);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        Athlete athlete = helper.getAthlete();
        //ScoutDAO dao = new ScoutDAO(this);
        Intent intent = getIntent();
        Campeonato campeonato = (Campeonato)intent.getSerializableExtra("campeonato");
        AthleteController athleteController = new AthleteController(this);

        switch (item.getItemId()) {
            case R.id.save:
                athleteController.insertOrReplaceAthlete(athlete);

                Intent intentScout = new Intent(RegisterActivity.this, ChampRegisterActivity.class);
                intentScout.putExtra("atleta", athlete);
                intentScout.putExtra("campeonato", campeonato);
                startActivity(intentScout);
                finish();
                break;

            case android.R.id.home:
                athleteController.insertOrReplaceAthlete(athlete);

                Intent intentHome = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intentHome);
                Toast.makeText(RegisterActivity.this, "Atleta " + athlete.getName() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
