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

import scoutapp.com.br.scoutapp.DAO.ScoutDAO;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.modelo.Campeonato;

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
        Campeonato campeonato = (Campeonato) intentChamp.getSerializableExtra("campeonato");

        Intent intentAtleta = getIntent();
        Athlete athlete = (Athlete) intentAtleta.getSerializableExtra("atleta");

        helper = new ChampRegisterHelper(this, athlete);

        if (campeonato != null) {
            campeonato.setIdAtleta(athlete.getId().toString());
            helper.preencheCadastro(campeonato);
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
        Campeonato campeonato = helper.getCampeonato();
        ScoutDAO dao = new ScoutDAO(this);
        Intent intent = getIntent();
        Athlete atleta = (Athlete) intent.getSerializableExtra("atleta");

        switch (item.getItemId()) {
            case R.id.menu_scout:
                campeonato.setIdAtleta(atleta.getId().toString());
                insertOrUpdate(campeonato,dao);
                Intent intentScout = new Intent(ChampRegisterActivity.this, ScoutActivity.class);
                intentScout.putExtra("campeonato", campeonato);
                intentScout.putExtra("atleta", atleta);
                startActivity(intentScout);
                Toast.makeText(ChampRegisterActivity.this, "campeonato " + campeonato.getName(), Toast.LENGTH_SHORT).show();
                Toast.makeText(ChampRegisterActivity.this, "ID " + campeonato.getIdAtleta(), Toast.LENGTH_SHORT).show();
                finish();
                break;

            case android.R.id.home:
                insertOrUpdate(campeonato,dao);
                Intent intentRegister = new Intent(ChampRegisterActivity.this, RegisterActivity.class);
                intentRegister.putExtra("campeonato", campeonato);
                intentRegister.putExtra("atleta", atleta);
                startActivity(intentRegister);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void insertOrUpdate(Campeonato campeonato, ScoutDAO dao){
        if(campeonato.getId() != null){
            Toast.makeText(ChampRegisterActivity.this, "Update " + campeonato.getName(), Toast.LENGTH_SHORT).show();
            dao.updateChamp(campeonato);
        } else{
            Toast.makeText(ChampRegisterActivity.this, "Insert " + campeonato.getName(), Toast.LENGTH_SHORT).show();
            dao.insertChamp(campeonato);
        }
        dao.close();

    }

}
