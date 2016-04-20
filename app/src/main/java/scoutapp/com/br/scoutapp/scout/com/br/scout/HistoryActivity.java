package scoutapp.com.br.scoutapp.scout.com.br.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.scout.com.br.scout.dao.AdversaryDao;
import scoutapp.com.br.scoutapp.scout.com.br.scout.modelo.Adversary;

public class HistoryActivity extends AppCompatActivity {

    private ListView ScoutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ScoutList = (ListView) findViewById(R.id.scout_list);
        loadList();
        ScoutList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> lista, View item, int position, long id) {
                Adversary adversary = (Adversary) ScoutList.getItemAtPosition(position);
                Intent intentFormulario = new Intent(HistoryActivity.this, ReportActivity.class);
                intentFormulario.putExtra("adversary", adversary);
                startActivity(intentFormulario);
            }
        });

        //menu de contexto - click longo
        registerForContextMenu(ScoutList);
    }

    private void loadList() {
        AdversaryDao dao = new AdversaryDao(this);
        List<Adversary> adversaries = dao.buscarAlunos();
        dao.close();

        ArrayAdapter<Adversary> adapter = new ArrayAdapter<Adversary>(this, android.R.layout.simple_expandable_list_item_1, adversaries);
        ScoutList.setAdapter(adapter);
    }

}
