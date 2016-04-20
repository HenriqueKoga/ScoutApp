package scoutapp.com.br.scoutapp.scout.com.br.scout;

import android.widget.EditText;
import android.widget.RatingBar;

import scoutapp.com.br.scoutapp.R;
import scoutapp.com.br.scoutapp.scout.com.br.scout.modelo.Adversary;

/**
 * Created by HenriqueKoga on 19/04/16.
 */
public class ReportHelper {
    private final EditText fieldName;
    private final EditText fieldCategory;
    private final EditText fieldGenre;
    private final EditText fieldClub;

    private Adversary adversary;

    public ReportHelper(ReportActivity activity){
        fieldName = (EditText) activity.findViewById(R.id.report_name);
        fieldCategory = (EditText) activity.findViewById(R.id.report_category);
        fieldGenre = (EditText) activity.findViewById(R.id.report_genre);
        fieldClub = (EditText) activity.findViewById(R.id.report_club);
        adversary = new Adversary();

    }

    public Adversary catchAdversary() {
        adversary.setName(fieldName.getText().toString());
        adversary.setCategory(fieldCategory.getText().toString());
        adversary.setGenre(fieldGenre.getText().toString());
        adversary.setClub(fieldClub.getText().toString());

        return adversary;
    }

    public void fillReport(Adversary adversary) {
        fieldName.setText(adversary.getName());
        fieldCategory.setText(adversary.getCategory());
        fieldGenre.setText(adversary.getGenre());
        fieldClub.setText(adversary.getClub());
        this.adversary = adversary;
    }
}
