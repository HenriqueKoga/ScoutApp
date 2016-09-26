package scoutapp.com.br.scoutapp.helper;

import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import scoutapp.com.br.scoutapp.ChampRegisterActivity;
import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;

/**
 * Created by HenriqueKoga on 01/06/16.
 */
public class ChampRegisterHelper  {
    private final EditText fieldChampName;
    private final EditText fieldDate;
    private final EditText fieldState;
    private final EditText fieldCity;
    private Championship championship;

    public ChampRegisterHelper(ChampRegisterActivity activity) {
        fieldChampName = (EditText) activity.findViewById(R.id.champ);
        fieldDate = (EditText) activity.findViewById(R.id.date);
        fieldState = (EditText) activity.findViewById(R.id.state);
        fieldCity = (EditText) activity.findViewById(R.id.city);
        championship = new Championship();
    }

    public Championship getChampionship() throws ParseException {
        championship.setChampName(fieldChampName.getText().toString());
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        if (!fieldDate.getText().toString().equals("  /  /    ")){
            Date date = formatter.parse(fieldDate.getText().toString());
            championship.setDate(date);
        } else {
            Date date = new java.util.Date();
            championship.setDate(date);
        }
        championship.setState(fieldState.getText().toString());
        championship.setCity(fieldCity.getText().toString());

        return championship;
    }

    public void fillChampionshipRegister(Championship championship) throws ParseException {
        fieldChampName.setText(championship.getChampName());
        android.text.format.DateFormat df = new android.text.format.DateFormat();
        fieldDate.setText(df.format("dd/MM/yyyy", championship.getDate()));
        fieldState.setText(championship.getState());
        fieldCity.setText(championship.getCity());

        this.championship = championship;
    }
}
