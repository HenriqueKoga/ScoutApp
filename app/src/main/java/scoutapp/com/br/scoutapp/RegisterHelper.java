package scoutapp.com.br.scoutapp;

import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.model.Athlete;

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
    private Athlete mAthlete;


    public RegisterHelper(RegisterActivity activity) {
        campoNome = (EditText) activity.findViewById(R.id.nome);
        campoIdade = (EditText) activity.findViewById(R.id.idade);
        campoCategoria = (EditText) activity.findViewById(R.id.categoria);
        campoClube = (EditText) activity.findViewById(R.id.clube);
        campoMao = (Spinner) activity.findViewById(R.id.spinner_dest_canh);
        campoEstilo = (Spinner) activity.findViewById(R.id.spinner_estilo);
        campoObs = (EditText) activity.findViewById(R.id.obs);
        mAthlete = new Athlete();
    }

    public Athlete getAthlete(){
        mAthlete.setName(campoNome.getText().toString());
        mAthlete.setAge(Integer.parseInt(campoIdade.getText().toString()));
        mAthlete.setCategory(campoCategoria.getText().toString());
        mAthlete.setClub(campoClube.getText().toString());
        mAthlete.setHand(campoMao.getSelectedItemPosition());
        mAthlete.setStyle(campoEstilo.getSelectedItemPosition());
        mAthlete.setObs(campoObs.getText().toString());

        return mAthlete;
    }

    public void preencheCadastro(Athlete athlete)  {
        campoNome.setText(athlete.getName());
        campoIdade.setText(String.valueOf(athlete.getAge()));
        campoCategoria.setText(athlete.getCategory());
        campoClube.setText(athlete.getClub());
        campoMao.setSelection(athlete.getHand());
        campoEstilo.setSelection(athlete.getStyle());
        campoObs.setText(athlete.getObs());
        this.mAthlete = athlete;
    }
}
