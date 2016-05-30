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

import scoutapp.com.br.scoutapp.DAO.AtletaDAO;
import scoutapp.com.br.scoutapp.modelo.Atleta;


public class RegisterActivity extends AppCompatActivity {

    private RegisterHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
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
        inflater.inflate(R.menu.menu_cadastro, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_formulario_ok:
                Atleta atleta = helper.getAtleta();

                AtletaDAO dao = new AtletaDAO(this);

                if(atleta.getId() != null){
                    dao.altera(atleta);
                } else{
                    dao.insere(atleta);
                }
                dao.close();

                Toast.makeText(RegisterActivity.this, "Atleta " + atleta.getNome() + " salvo!", Toast.LENGTH_SHORT).show();

                finish();
                break;
            case android.R.id.home:
                Intent intentHome = new Intent(RegisterActivity.this, HomeActivity.class);
                startActivity(intentHome);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}
