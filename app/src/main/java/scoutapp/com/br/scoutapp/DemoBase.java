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
public abstract class DemoBase extends AppCompatActivity {

    protected String[] mTechniques = new String[] {
            "Service", "Receiving", "Forehand", "Backhand", "Smash", "Slice", "Block", "Flick", "Lob"
    };

    protected Typeface mTfRegular;
    protected Typeface mTfLight;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    protected float getRandom(float range, float startsfrom) {
        return (float) (Math.random() * range) + startsfrom;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
    }
}