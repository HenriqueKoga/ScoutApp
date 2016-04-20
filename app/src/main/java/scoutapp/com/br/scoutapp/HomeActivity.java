package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import scoutapp.com.br.scoutapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton addScout = (FloatingActionButton) findViewById(R.id.novo_atleta);
        addScout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadastro = new Intent(HomeActivity.this, CadastroActivity.class);
                startActivity(intentCadastro);
            }
        });

        String[] atletas = {"Henrique", "Gustavo", "Ma Long", "José", "Gustavo", "Ma Long", "José", "Gustavo", "Ma Long", "José", "Gustavo", "Ma Long", "José", "Gustavo", "Ma Long", "José", "Gustavo", "Ma Long", "José"};

        ListView ListaAlunos = (ListView)findViewById(R.id.scout_list);

        ArrayAdapter <String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, atletas);
        ListaAlunos.setAdapter(adapter);


    }
}
