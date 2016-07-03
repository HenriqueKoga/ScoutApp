package scoutapp.com.br.scoutapp;

import android.widget.EditText;
import android.widget.TextView;

import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.modelo.Campeonato;

/**
 * Created by HenriqueKoga on 01/06/16.
 */
public class ChampRegisterHelper  {
    private final EditText fieldName;
//    private final DatePicker fieldDate;
    private final EditText fieldState;
    private final EditText fieldCity;
    private final TextView fieldIdAtleta;
    private Campeonato campeonato;
    private Athlete mAthlete;

    public ChampRegisterHelper(ChampRegisterActivity activity, Athlete athlete) {
        fieldName = (EditText) activity.findViewById(R.id.champ);
//        fieldDate = (DatePicker) activity.findViewById(R.id.dlgDate);
        fieldState = (EditText) activity.findViewById(R.id.state);
        fieldCity = (EditText) activity.findViewById(R.id.city);
        fieldIdAtleta = (TextView) activity.findViewById(R.id.id_atleta);
        campeonato = new Campeonato();
        mAthlete = athlete;
    }

    public Campeonato getCampeonato(){
        campeonato.setName(fieldName.getText().toString());
//        campeonato.setDate(fieldDate.toString());
        campeonato.setState(fieldState.getText().toString());
        campeonato.setCity(fieldCity.getText().toString());
        campeonato.setIdAtleta(fieldIdAtleta.getText().toString());
        return campeonato;
    }

    public void preencheCadastro(Campeonato campeonato)  {
        fieldName.setText(campeonato.getName());
//        fieldDate.setText(campeonato.getDate());
        fieldState.setText(campeonato.getState());
        fieldCity.setText(campeonato.getCity());
        this.campeonato = campeonato;
    }
}
