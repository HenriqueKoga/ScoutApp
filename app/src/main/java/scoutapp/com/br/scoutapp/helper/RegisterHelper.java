package scoutapp.com.br.scoutapp.helper;

import android.text.InputFilter;
import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.RegisterActivity;
import scoutapp.com.br.scoutapp.model.Athlete;

/**
 * Created by HenriqueKoga on 22/04/16.
 */
public class RegisterHelper {
    private final EditText fieldName;
    private final EditText fieldAge;
    private final EditText fieldCategory;
    private final EditText fieldClub;
    private final Spinner fieldHand;
    private final Spinner fieldStyle;
    private final EditText fieldObs;
    private Athlete mAthlete;


    public RegisterHelper(RegisterActivity activity) {
        InputFilter[] filterArray = new InputFilter[1];
        filterArray[0] = new InputFilter.LengthFilter(15);
        fieldName = (EditText) activity.findViewById(R.id.name);
        fieldName.setFilters(filterArray);
        fieldAge = (EditText) activity.findViewById(R.id.age);
        fieldCategory = (EditText) activity.findViewById(R.id.category);
        fieldClub = (EditText) activity.findViewById(R.id.club);
        fieldHand = (Spinner) activity.findViewById(R.id.spinner_right_left_hand);
        fieldStyle = (Spinner) activity.findViewById(R.id.spinner_style);
        fieldObs = (EditText) activity.findViewById(R.id.obs);
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
        mAthlete.setObs(fieldObs.getText().toString());

        return mAthlete;
    }

    public void fillRegister(Athlete athlete)  {
        fieldName.setText(athlete.getName());
        fieldAge.setText(String.valueOf(athlete.getAge()));
        fieldCategory.setText(athlete.getCategory());
        fieldClub.setText(athlete.getClub());
        fieldHand.setSelection(athlete.getHand());
        fieldStyle.setSelection(athlete.getStyle());
        fieldObs.setText(athlete.getObs());
        this.mAthlete = athlete;
    }
}
