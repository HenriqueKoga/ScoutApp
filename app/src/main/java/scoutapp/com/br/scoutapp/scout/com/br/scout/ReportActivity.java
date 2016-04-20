package scoutapp.com.br.scoutapp.scout.com.br.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.scout.com.br.scout.modelo.Adversary;

public class ReportActivity extends AppCompatActivity {

    private ReportHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        helper = new ReportHelper(this);

        Intent intent = getIntent();
        Adversary adversary = (Adversary) intent.getSerializableExtra("adversary");

        if (adversary != null) {
            helper.fillReport(adversary);
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.menu_formulario, menu);
//
//        return super.onCreateOptionsMenu(menu);
//    }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.menu_formulario_ok:
//                Aluno aluno = helper.pegaAluno();
//                AlunoDao dao = new AlunoDao(this);
//
//                if (aluno.getId() != null) {
//                    dao.altera(aluno);
//                } else {
//                    dao.insere(aluno);
//                }
//                dao.close();
//
//                Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " Salvo", Toast.LENGTH_LONG).show();
//
//                finish();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
}
