package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import scoutapp.com.br.scoutapp.DAO.AtletaDAO;
import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.modelo.Atleta;

public class HomeActivity extends AppCompatActivity {

    private ListView listaAtletas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listaAtletas = (ListView)findViewById(R.id.scout_list);

        FloatingActionButton addScout = (FloatingActionButton) findViewById(R.id.novo_atleta);
        addScout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCadastro = new Intent(HomeActivity.this, CadastroActivity.class);
                startActivity(intentCadastro);
            }
        });

        registerForContextMenu(listaAtletas);
    }

    private void carregaLista(){
        AtletaDAO dao = new AtletaDAO(this);
        List<Atleta> atletas = dao.buscaAtletas();
        dao.close();

        ArrayAdapter <Atleta> adapter = new ArrayAdapter<Atleta>(this, android.R.layout.simple_list_item_activated_1, atletas);
        listaAtletas.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("Deletar");

        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Atleta atleta = (Atleta) listaAtletas.getItemAtPosition(info.position);

                AtletaDAO dao = new AtletaDAO(HomeActivity.this);
                dao.deleta(atleta);
                dao.close();

                carregaLista();

                Toast.makeText(HomeActivity.this, "Deletar o atleta " + atleta.getNome(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
