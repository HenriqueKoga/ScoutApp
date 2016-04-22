package scoutapp.com.br.scoutapp;

import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.modelo.Atleta;

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class CadastroHelper {
    private final EditText campoNome;
    private final EditText campoIdade;
    private final EditText campoCategoria;
    private final EditText campoClube;
    private final Spinner  campoMao;
    private final Spinner campoEstilo;
    private final EditText campoObs;


    public CadastroHelper(CadastroActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.nome);
        String nome = campoNome.getText().toString();

        campoIdade = (EditText) activity.findViewById(R.id.idade);
        String idade = campoIdade.getText().toString();

        campoCategoria = (EditText) activity.findViewById(R.id.categoria);
        String categoria = campoCategoria.getText().toString();

        campoClube = (EditText) activity.findViewById(R.id.clube);
        String clube = campoClube.getText().toString();

        campoMao = (Spinner) activity.findViewById(R.id.spinner_dest_canh);
        String mao = campoMao.getSelectedItem().toString();

        campoEstilo = (Spinner) activity.findViewById(R.id.spinner_estilo);
        String estilo = campoEstilo.getSelectedItem().toString();

        campoObs = (EditText) activity.findViewById(R.id.obs);
        String obs = campoObs.getText().toString();
    }

    public Atleta getAtleta(){
        Atleta atleta = new Atleta();
        atleta.setNome(campoNome.getText().toString());
        atleta.setIdade(campoIdade.getText().toString());
        atleta.setCategoria(campoCategoria.getText().toString());
        atleta.setClube(campoClube.getText().toString());
        atleta.setMao(campoMao.getSelectedItem().toString());
        atleta.setEstilo(campoEstilo.getSelectedItem().toString());
        atleta.setObs(campoObs.getText().toString());

        return atleta;
    }
}
