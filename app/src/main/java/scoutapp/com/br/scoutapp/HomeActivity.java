package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;

import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import scoutapp.com.br.scoutapp.DAO.ScoutDAO;
import scoutapp.com.br.scoutapp.adapter.ScoutAdapter;
import scoutapp.com.br.scoutapp.modelo.Atleta;
import scoutapp.com.br.scoutapp.modelo.Campeonato;

public class HomeActivity extends AppCompatActivity {

    private ListView listaAtletas;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled(true);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                menuItem.setChecked(true);
                mDrawerLayout.closeDrawers();
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.nav_perfil:
                        return true;
                    case R.id.nav_settings:
                        Toast.makeText(HomeActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        Intent intentSettings = new Intent(HomeActivity.this, SettingsActivity.class);
                        startActivity(intentSettings);
                        return true;
                    case R.id.nav_logout:
                        Toast.makeText(HomeActivity.this, menuItem.getTitle(), Toast.LENGTH_LONG).show();
                        Intent intentLogin = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intentLogin);
                        return true;
                    default:
                        return true;
                }
            }
        });

        Intent intent = getIntent();
        Campeonato campeonato = (Campeonato)intent.getSerializableExtra("campeonato");

        listaAtletas = (ListView)findViewById(R.id.scout_list);

        listaAtletas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Atleta atleta = (Atleta) listaAtletas.getItemAtPosition(position);
                Intent intentRegister = new Intent(HomeActivity.this, RegisterActivity.class);
                intentRegister.putExtra("atleta", atleta);
                startActivity(intentRegister);
            }
        });

        FloatingActionButton addScout = (FloatingActionButton) findViewById(R.id.novo_atleta);
        addScout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(HomeActivity.this, RegisterActivity.class);
                startActivity(intentRegister);
            }
        });
        registerForContextMenu(listaAtletas);
    }

    private void carregaLista(){
        ScoutDAO dao = new ScoutDAO(this);
        List<Atleta> atletas = dao.searchAthlete();
        dao.close();

//        ArrayAdapter<Atleta> adapter = new ArrayAdapter<Atleta>(this, android.R.layout.simple_list_item_1, atletas);
        ScoutAdapter adapter = new ScoutAdapter(this, atletas);
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

                ScoutDAO dao = new ScoutDAO(HomeActivity.this);
                dao.deleteAthlete(atleta);
                dao.close();

                carregaLista();

                Toast.makeText(HomeActivity.this, "Deletado o atleta " + atleta.getNome(), Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
