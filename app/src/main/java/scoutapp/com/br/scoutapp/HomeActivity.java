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
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import scoutapp.com.br.scoutapp.adapter.HomeListAdapter;
import scoutapp.com.br.scoutapp.controller.AthleteController;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;

public class HomeActivity extends AppCompatActivity {

    private ListView athletesList;
    private DrawerLayout mDrawerLayout;
    private Athlete athleteUser;

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
        athleteUser = (Athlete) intent.getSerializableExtra("user");
        Championship championship = (Championship) intent.getSerializableExtra("championship");

        athletesList = (ListView)findViewById(R.id.scout_list);

        athletesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Athlete athleteOpponent = (Athlete) athletesList.getItemAtPosition(position);
                Intent intentRegister = new Intent(HomeActivity.this, RegisterActivity.class);
                intentRegister.putExtra("athlete_opponent", athleteOpponent);
                intentRegister.putExtra("user", athleteUser);
                startActivity(intentRegister);
            }
        });

        FloatingActionButton addScout = (FloatingActionButton) findViewById(R.id.new_athlete);
        addScout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentRegister = new Intent(HomeActivity.this, RegisterActivity.class);
                intentRegister.putExtra("user", athleteUser);
                startActivity(intentRegister);
            }
        });
        registerForContextMenu(athletesList);
    }

    private void showList(){
        AthleteController athleteController = new AthleteController(this);
        List<Athlete> athletes = athleteController.getAllAthletes(athleteUser);

        HomeListAdapter adapter = new HomeListAdapter(this, athletes);
        athletesList.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        showList();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem delete = menu.add("Delete");

        delete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Athlete athleteOpponent = (Athlete) athletesList.getItemAtPosition(info.position);

                AthleteController athleteController = new AthleteController(HomeActivity.this);
                athleteController.removeAthlete(athleteOpponent);
                showList();

                Toast.makeText(HomeActivity.this, "Deleted " + athleteOpponent.getName(), Toast.LENGTH_SHORT).show();
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
