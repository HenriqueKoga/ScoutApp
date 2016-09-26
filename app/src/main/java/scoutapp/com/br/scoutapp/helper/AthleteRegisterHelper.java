package scoutapp.com.br.scoutapp.helper;

import android.widget.EditText;
import android.widget.Spinner;

import scoutapp.com.br.scoutapp.AthleteRegisterActivity;
import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.User;

/**
 * Created by HenriqueKoga on 25/07/16.
 */
public class AthleteRegisterHelper {
    private final EditText fieldName;
    private final EditText fieldAge;
    private final EditText fieldUser;
    private final EditText fieldPassword;
    private User mAthlete;


    public AthleteRegisterHelper(AthleteRegisterActivity activity) {
        fieldName = (EditText) activity.findViewById(R.id.athlete_name);
        fieldAge = (EditText) activity.findViewById(R.id.athlete_age);
        fieldUser = (EditText) activity.findViewById(R.id.athlete_user);
        fieldPassword = (EditText) activity.findViewById(R.id.athlete_password);
        mAthlete = new User();
    }

    public User getAthlete(){
        mAthlete.setName(fieldName.getText().toString());
        if(fieldAge.getText().toString().isEmpty()) {
            mAthlete.setAge(0);
        } else{
            mAthlete.setAge(Integer.parseInt(fieldAge.getText().toString()));
        }
        mAthlete.setUser(fieldUser.getText().toString());
        mAthlete.setPassword(fieldPassword.getText().toString());

        return mAthlete;
    }

    public void fillRegister(User user)  {
        fieldName.setText(user.getName());
        fieldAge.setText(String.valueOf(user.getAge()));
        fieldUser.setText(user.getUser());
        fieldPassword.setText(user.getPassword());

        this.mAthlete = user;
    }
}
