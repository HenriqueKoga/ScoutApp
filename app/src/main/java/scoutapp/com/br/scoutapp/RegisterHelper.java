package scoutapp.com.br.scoutapp;

import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.modelo.Atleta;

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class RegisterHelper {
    private final EditText campoNome;
    private final EditText campoIdade;
    private final EditText campoCategoria;
    private final EditText campoClube;
    private final Spinner  campoMao;
    private final Spinner campoEstilo;
    private final EditText campoObs;
    private Atleta atleta;


    public RegisterHelper(RegisterActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.nome);
        campoIdade = (EditText) activity.findViewById(R.id.idade);
        campoCategoria = (EditText) activity.findViewById(R.id.categoria);
        campoClube = (EditText) activity.findViewById(R.id.clube);
        campoMao = (Spinner) activity.findViewById(R.id.spinner_dest_canh);
        campoEstilo = (Spinner) activity.findViewById(R.id.spinner_estilo);
        campoObs = (EditText) activity.findViewById(R.id.obs);
        atleta = new Atleta();
    }

    public Atleta getAtleta(){
        atleta.setNome(campoNome.getText().toString());
        atleta.setIdade(campoIdade.getText().toString());
        atleta.setCategoria(campoCategoria.getText().toString());
        atleta.setClube(campoClube.getText().toString());
        atleta.setMao(campoMao.getSelectedItemPosition());
        atleta.setEstilo(campoEstilo.getSelectedItemPosition());
        atleta.setObs(campoObs.getText().toString());

        return atleta;
    }

    public void preencheCadastro(Atleta atleta)  {
        campoNome.setText(atleta.getNome());
        campoIdade.setText(atleta.getIdade());
        campoCategoria.setText(atleta.getCategoria());
        campoClube.setText(atleta.getClube());
        campoMao.setSelection(atleta.getMao());
        campoEstilo.setSelection(atleta.getEstilo());
        campoObs.setText(atleta.getObs());
        this.atleta = atleta;
    }
}
