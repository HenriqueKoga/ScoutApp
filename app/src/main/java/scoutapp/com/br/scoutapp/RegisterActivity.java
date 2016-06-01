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

import scoutapp.com.br.scoutapp.DAO.ScoutDAO;
import scoutapp.com.br.scoutapp.modelo.Atleta;
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
        Atleta atleta = (Atleta) intent.getSerializableExtra("atleta");
        if(atleta != null){
            helper.preencheCadastro(atleta);
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
        Atleta atleta = helper.getAtleta();
        ScoutDAO dao = new ScoutDAO(this);
        Intent intent = getIntent();
        Campeonato campeonato = (Campeonato)intent.getSerializableExtra("campeonato");

        switch (item.getItemId()) {
            case R.id.save:
                insertOrUpdate(atleta,dao);
                Intent intentScout = new Intent(RegisterActivity.this, ChampRegisterActivity.class);
                intentScout.putExtra("atleta", atleta);
                intentScout.putExtra("campeonato", campeonato);
                startActivity(intentScout);
                finish();
                break;

            case android.R.id.home:
                insertOrUpdate(atleta,dao);
                Intent intentHome = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intentHome);
                Toast.makeText(RegisterActivity.this, "Atleta " + atleta.getNome() + " salvo!", Toast.LENGTH_SHORT).show();
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void insertOrUpdate(Atleta atleta, ScoutDAO dao){
        if(atleta.getId() != null){
            dao.updateAthlete(atleta);
        } else{
            dao.insertAthlete(atleta);
        }
        dao.close();

    }

}
