package scoutapp.com.br.scoutapp;

/**
 * Created by HenriqueKoga on 07/07/16.
 */
import android.graphics.Typeface;
import android.os.Bundle;
import android.renderscript.Type;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


/**
 * Baseclass of all Activities of the Demo Application.
 *
 * @author Philipp Jahoda
 */
public abstract class ChartBase extends AppCompatActivity {

    protected String[] mTechniques = new String[] {
            "Service", "Receiving", "Forehand", "Backhand", "Smash", "Slice", "Block", "Flick", "Lob"
    };

    protected  String[] mTechniquesSpec = new String[]{
            "Left Long Crossed", "Left Long Parallel",
            "Left Short Crossed", "Left Short Parallel",
            "Middle Long Crossed", "Middle Long Parallel",
            "Middle Short Crossed", "Middle Short Parallel",
            "Right Long Crossed", "Right Long Parallel",
            "Right Short Crossed", "Right Short Parallel"
    };

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}