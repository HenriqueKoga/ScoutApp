package scoutapp.com.br.scoutapp.helper;

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
    private Athlete mAthlete;

    public ChampRegisterHelper(ChampRegisterActivity activity, Athlete athlete) {
        fieldChampName = (EditText) activity.findViewById(R.id.champ);
        fieldDate = (EditText) activity.findViewById(R.id.date);
        fieldState = (EditText) activity.findViewById(R.id.state);
        fieldCity = (EditText) activity.findViewById(R.id.city);
        championship = new Championship();
        mAthlete = athlete;
    }

    public Championship getChampionship() {
        championship.setChampName(fieldChampName.getText().toString());
        try {
            if(fieldDate.getText().toString().isEmpty()) {
                Calendar today = Calendar.getInstance();
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(today.getTime().toString());
                championship.setDate(date);
            } else {
                DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
                Date date = format.parse(fieldDate.getText().toString());
                championship.setDate(date);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        championship.setState(fieldState.getText().toString());
        championship.setCity(fieldCity.getText().toString());

        return championship;
    }

    public void fillChampionshipRegister(Championship championship)  {
        fieldChampName.setText(championship.getChampName());
        fieldDate.setText(championship.getDate().toString());
        fieldState.setText(championship.getState());
        fieldCity.setText(championship.getCity());

        this.championship = championship;
    }
}
