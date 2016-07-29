package scoutapp.com.br.scoutapp.helper;

import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.AthleteRegisterActivity;
import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.RegisterActivity;
import scoutapp.com.br.scoutapp.model.Athlete;

/**
 * Created by HenriqueKoga on 25/07/16.
 */
public class AthleteRegisterHelper {
    private final EditText fieldName;
    private final EditText fieldAge;
    private final EditText fieldCategory;
    private final EditText fieldClub;
    private final Spinner fieldHand;
    private final Spinner fieldStyle;
    private Athlete mAthlete;


    public AthleteRegisterHelper(AthleteRegisterActivity activity) {
        fieldName = (EditText) activity.findViewById(R.id.athlete_name);
        fieldAge = (EditText) activity.findViewById(R.id.athlete_age);
        fieldCategory = (EditText) activity.findViewById(R.id.athlete_category);
        fieldClub = (EditText) activity.findViewById(R.id.athlete_club);
        fieldHand = (Spinner) activity.findViewById(R.id.athlete_spinner_right_left_hand);
        fieldStyle = (Spinner) activity.findViewById(R.id.athlete_spinner_style);
        mAthlete = new Athlete();
    }

    public Athlete getAthlete(){
        mAthlete.setName(fieldName.getText().toString());
        if(fieldAge.getText().toString().isEmpty()) {
            mAthlete.setAge(0);
        } else{
            mAthlete.setAge(Integer.parseInt(fieldAge.getText().toString()));
        }
        mAthlete.setCategory(fieldCategory.getText().toString());
        mAthlete.setClub(fieldClub.getText().toString());
        mAthlete.setHand(fieldHand.getSelectedItemPosition());
        mAthlete.setStyle(fieldStyle.getSelectedItemPosition());

        return mAthlete;
    }

    public void fillRegister(Athlete athlete)  {
        fieldName.setText(athlete.getName());
        fieldAge.setText(String.valueOf(athlete.getAge()));
        fieldCategory.setText(athlete.getCategory());
        fieldClub.setText(athlete.getClub());
        fieldHand.setSelection(athlete.getHand());
        fieldStyle.setSelection(athlete.getStyle());
        this.mAthlete = athlete;
    }
}
