package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.baoyz.actionsheet.ActionSheet;

import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;

public class ScoutActivity extends AppCompatActivity implements
        ActionSheet.ActionSheetListener{

    int forehand = 0;
    int backhand = 0;
    int smash = 0;
    int slice = 0;
    int block = 0;
    int flick = 0;

    int total = 0;

    TextView fieldScore;
    TextView fieldForehand;
    TextView fieldBackhand;
    TextView fieldSmash;
    TextView fieldSlice;
    TextView fieldBlock;
    TextView fieldflick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        fieldScore = (TextView) this.findViewById(R.id.score);
        fieldForehand = (TextView) this.findViewById(R.id.forehand);
        fieldBackhand = (TextView) this.findViewById(R.id.backhand);
        fieldSmash = (TextView) this.findViewById(R.id.smash);
        fieldSlice = (TextView) this.findViewById(R.id.slice);
        fieldBlock = (TextView) this.findViewById(R.id.block);
        fieldflick = (TextView) this.findViewById(R.id.flick);

        fieldScore.setText("Acertos: " + total);
        fieldForehand.setText("Forehand: " + forehand);
        fieldBackhand.setText("Backhand: " + backhand);
        fieldSmash.setText("Smash: " + smash);
        fieldSlice.setText("Slice: " + slice);
        fieldBlock.setText("Block: " + block);
        fieldflick.setText("Flick: " + flick);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_long:
                setTheme(R.style.ActionSheetStyleiOS7);
                break;
            case R.id.left_short:
                setTheme(R.style.ActionSheetStyleiOS7);
                break;
        }
        showActionSheet();
    }

    public void showActionSheet() {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("Forehand", "Backhand", "Smash", "Slice", "Block", "Flick")
                .setCancelableOnTouchOutside(true).setListener(this).show();
    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        switch (index) {
            case 0:
                forehand = forehand + 1;
                fieldForehand.setText("Forehand: " + forehand);
                Toast.makeText(getApplicationContext(), "Forehand = " + forehand, Toast.LENGTH_SHORT).show();
                break;
            case 1:
                backhand = backhand + 1;
                fieldBackhand.setText("Backhand: " + backhand);
                Toast.makeText(getApplicationContext(), "Backhand = " + backhand, Toast.LENGTH_SHORT).show();
                break;
            case 2:
                smash = smash + 1;
                fieldSmash.setText("Smash: " + smash);
                Toast.makeText(getApplicationContext(), "Smash = " + smash, Toast.LENGTH_SHORT).show();
                break;
            case 3:
                slice = slice + 1;
                fieldSlice.setText("Slice: " + slice);
                Toast.makeText(getApplicationContext(), "Slice = " + slice, Toast.LENGTH_SHORT).show();
                break;
            case 4:
                block = block + 1;
                fieldBlock.setText("Block: " + block);
                Toast.makeText(getApplicationContext(), "Block = " + block, Toast.LENGTH_SHORT).show();
                break;
            case 5:
                flick = flick + 1;
                fieldflick.setText("Flick: " + flick);
                Toast.makeText(getApplicationContext(), "Flick = " + flick, Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancle) {
        total = forehand + backhand + smash + slice + block + flick;
        fieldScore.setText("Acertos: " + total);
        if(total > 0) {
            Toast.makeText(getApplicationContext(), "Total de acertos = " + total, Toast.LENGTH_SHORT).show();
        }
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = getIntent();
                Athlete athlete = (Athlete) intent.getSerializableExtra("athlete");
                Championship championship = (Championship) intent.getSerializableExtra("championship");

                Intent intentRegister = new Intent(ScoutActivity.this, ChampRegisterActivity.class);
                intentRegister.putExtra("athlete", athlete);
                intentRegister.putExtra("championship", championship);
                startActivity(intentRegister);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
