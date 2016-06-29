package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import scoutapp.com.br.scoutapp.modelo.Atleta;
import scoutapp.com.br.scoutapp.modelo.Campeonato;

public class ScoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = getIntent();
                Atleta atleta = (Atleta) intent.getSerializableExtra("atleta");
                Campeonato campeonato = (Campeonato) intent.getSerializableExtra("campeonato");

                Intent intentRegister = new Intent(ScoutActivity.this, ChampRegisterActivity.class);
                intentRegister.putExtra("atleta", atleta);
                intentRegister.putExtra("campeonato", campeonato);
                startActivity(intentRegister);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
