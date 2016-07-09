package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.baoyz.actionsheet.ActionSheet;

import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.Game;

public class ScoutActivity extends AppCompatActivity implements
        ActionSheet.ActionSheetListener{

    private TextView fieldName;
    private TextView fieldScore;
    private TextView fieldForehand;
    private TextView fieldBackhand;
    private TextView fieldSmash;
    private TextView fieldSlice;
    private TextView fieldBlock;
    private TextView fieldFlick;
    private TextView fieldService;
    private TextView fieldReceiving;
    private TextView fieldLob;
    private TextView fieldNameHit;
    private ToggleButton tgbutton;
    private boolean athletePoint = false;
    private boolean opponentPoint = false;

    private boolean buttonLeftLong = false;
    private boolean buttonLeftShort = false;
    private Athlete athlete;
    private Game gameAthlete;
    private Game gameOponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        gameAthlete = new Game();

        fieldName = (TextView) this.findViewById(R.id.opponent_name);
        fieldScore = (TextView) this.findViewById(R.id.score);
        fieldService = (TextView) this.findViewById(R.id.service);
        fieldReceiving = (TextView) this.findViewById(R.id.receiving);
        fieldForehand = (TextView) this.findViewById(R.id.forehand);
        fieldBackhand = (TextView) this.findViewById(R.id.backhand);
        fieldSmash = (TextView) this.findViewById(R.id.smash);
        fieldSlice = (TextView) this.findViewById(R.id.slice);
        fieldBlock = (TextView) this.findViewById(R.id.block);
        fieldFlick = (TextView) this.findViewById(R.id.flick);
        fieldLob = (TextView) this.findViewById(R.id.lob);
        fieldNameHit = (TextView) this.findViewById(R.id.name_hit);

        fieldScore.setText("Total Points: " + gameAthlete.getTotal());
        fieldService.setText("Service: " + gameAthlete.getService());
        fieldReceiving.setText("Receiving: " + gameAthlete.getReceiving());
        fieldForehand.setText("Forehand: " + gameAthlete.getForehand());
        fieldBackhand.setText("Backhand: " + gameAthlete.getBackhand());
        fieldSmash.setText("Smash: " + gameAthlete.getSmash());
        fieldSlice.setText("Slice: " + gameAthlete.getSlice());
        fieldBlock.setText("Block: " + gameAthlete.getBlock());
        fieldFlick.setText("Flick: " + gameAthlete.getFlick());
        fieldLob.setText("Lob: " + gameAthlete.getLob());

        Intent intent = getIntent();
        athlete = (Athlete) intent.getSerializableExtra("athlete");

        if(athlete != null){
            fieldName.setText("ATHLETE_NAME X " + athlete.getName().toUpperCase());
        }

        tgbutton = (ToggleButton) findViewById(R.id.toggleButton);
        tgbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Intent intent = getIntent();
                athlete = (Athlete) intent.getSerializableExtra("athlete");
                if (isChecked) {
                    opponentPoint = false;
                    athletePoint = true;
                    fieldNameHit.setText("ATHLETE NAME");
                    Log.i("info", "Athlete Point!");

                } else {
                    athletePoint = false;
                    opponentPoint = true;
                    fieldNameHit.setText(athlete.getName().toUpperCase());
                    Log.i("info", "Opponent Point!");
                }
            }
        });
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_long:
                setTheme(R.style.ActionSheetStyleiOS7);
                buttonLeftLong = true;
                break;
            case R.id.left_short:
                setTheme(R.style.ActionSheetStyleiOS7);
                buttonLeftShort = true;
                break;
        }
        showActionSheet();
    }

    public void showActionSheet() {
        ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("Service", "Receiving", "Forehand",
                                        "Backhand", "Smash", "Slice", "Block", "Flick", "Lob")
                .setCancelableOnTouchOutside(true).setListener(this).show();
    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        switch (index) {
            case 0:
                servicePoint();
                break;
            case 1:
                receivingPoint();
                break;
            case 2:
                forehandPoint();
                break;
            case 3:
                backhandPoint();
                break;
            case 4:
                smashPoint();
                break;
            case 5:
                slicePoint();
                break;
            case 6:
                blockPoint();
                break;
            case 7:
                flickPoint();
                break;
            case 8:
                lobPoint();
                break;
        }
    }

    private void servicePoint() {
        if (athletePoint) {
            gameAthlete.setService(gameAthlete.getService() + 1);
            fieldService.setText("Service: " + gameAthlete.getService());
        }
    }

    private void receivingPoint() {
        if (athletePoint) {
            gameAthlete.setReceiving(gameAthlete.getReceiving() + 1);
            fieldReceiving.setText("Receiving: " + gameAthlete.getReceiving());
        }
    }

    private void forehandPoint() {
        if (athletePoint) {
            if (buttonLeftLong) {
                gameAthlete.setForehandLeftLong(gameAthlete.getForehandLeftLong() + 1);
                buttonLeftLong = false;
            }
            if (buttonLeftShort) {
                gameAthlete.setForehandLeftShort(gameAthlete.getForehandLeftShort() + 1);
                buttonLeftShort = false;
            }
            gameAthlete.setForehand(gameAthlete.getForehand() + 1);
            fieldForehand.setText("Forehand: " + gameAthlete.getForehand());
            Log.d("Forehand Long", "forehand left long: " + gameAthlete.getForehandLeftLong());
            Log.d("Forehand Short", "forehand left short: " + gameAthlete.getForehandLeftShort());
            Log.d("Forehand Total", "forehand total: " + gameAthlete.getForehand());
        }
    }

    private void backhandPoint() {
        if (athletePoint) {
            gameAthlete.setBackhand(gameAthlete.getBackhand() + 1);
            fieldBackhand.setText("Backhand: " + gameAthlete.getBackhand());
        }
    }

    private void smashPoint() {
        if (athletePoint) {
            gameAthlete.setSmash(gameAthlete.getSmash() + 1);
            fieldSmash.setText("Smash: " + gameAthlete.getSmash());
        }
    }

    private void slicePoint() {
        if (athletePoint) {
            gameAthlete.setSlice(gameAthlete.getSlice() + 1);
            fieldSlice.setText("Slice: " + gameAthlete.getSlice());
        }
    }

    private void blockPoint() {
        if (athletePoint) {
            gameAthlete.setBlock(gameAthlete.getBlock() + 1);
            fieldBlock.setText("Block: " + gameAthlete.getBlock());
        }
    }

    private void flickPoint() {
        if (athletePoint) {
            gameAthlete.setFlick(gameAthlete.getFlick() + 1);
            fieldFlick.setText("Flick: " + gameAthlete.getFlick());
        }
    }

    private void lobPoint() {
        if (athletePoint) {
            gameAthlete.setLob(gameAthlete.getLob() + 1);
            fieldLob.setText("Lob: " + gameAthlete.getLob());
        }
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
        if (!isCancel) {
            if (athletePoint) {
                gameAthlete.setTotal(gameAthlete.getTotal() + 1);
                fieldScore.setText("Total Points: " + gameAthlete.getTotal());
            }
        }
    }


    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_scout, menu);
        return super.onCreateOptionsMenu(menu);
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

            case R.id.menu_save_scout:
                Intent intentChart = new Intent(ScoutActivity.this, ChartActivity.class);
                intentChart.putExtra("game", gameAthlete);
                startActivity(intentChart);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
