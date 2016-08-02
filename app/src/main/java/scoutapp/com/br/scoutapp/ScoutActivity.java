package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    private TextView fieldReception;
    private TextView fieldLob;
    private ToggleButton tgbutton;
    private boolean hit = false;

    private String position;
    private String direction;
    private String action;

    private Athlete athleteOpponent;
    private Athlete athleteUser;
    private Game gameAthlete;
    private Game gameOpponent;
    private ActionSheet directionS;
    private ActionSheet actionS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        fieldName = (TextView) this.findViewById(R.id.opponent_name);
        fieldScore = (TextView) this.findViewById(R.id.score);
        fieldService = (TextView) this.findViewById(R.id.service);
        fieldReception = (TextView) this.findViewById(R.id.reception);
        fieldForehand = (TextView) this.findViewById(R.id.forehand);
        fieldBackhand = (TextView) this.findViewById(R.id.backhand);
        fieldSmash = (TextView) this.findViewById(R.id.smash);
        fieldSlice = (TextView) this.findViewById(R.id.slice);
        fieldBlock = (TextView) this.findViewById(R.id.block);
        fieldFlick = (TextView) this.findViewById(R.id.flick);
        fieldLob = (TextView) this.findViewById(R.id.lob);

        Intent intent = getIntent();
        athleteUser = (Athlete) intent.getSerializableExtra("user");
        athleteOpponent = (Athlete) intent.getSerializableExtra("athlete");
        gameAthlete = (Game) intent.getSerializableExtra("game_athlete");
        gameOpponent = (Game) intent.getSerializableExtra("game_opponent");

        if(gameAthlete != null){
            fillTable();
        } else{
            gameAthlete = new Game();
            gameOpponent = new Game();
            fillTable();
        }

        tgbutton = (ToggleButton) findViewById(R.id.toggleButton);
        tgbutton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    hit = true;
                } else {
                    hit = false;
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        athleteUser = (Athlete) intent.getSerializableExtra("user");
        athleteOpponent = (Athlete) intent.getSerializableExtra("athlete");
        fieldName.setText(athleteUser.getName().toUpperCase() + " X " + athleteOpponent.getName().toUpperCase());
    }

    private void fillTable() {
        fieldScore.setText(gameAthlete.getTotal() + " X " + gameOpponent.getTotal());
        fieldService.setText("Service: " + gameAthlete.getService());
        fieldReception.setText("Reception: " + gameAthlete.getReception());
        fieldForehand.setText("Forehand: " + gameAthlete.getForehand());
        fieldBackhand.setText("Backhand: " + gameAthlete.getBackhand());
        fieldSmash.setText("Smash: " + gameAthlete.getSmash());
        fieldSlice.setText("Slice: " + gameAthlete.getSlice());
        fieldBlock.setText("Block: " + gameAthlete.getBlock());
        fieldFlick.setText("Flick: " + gameAthlete.getFlick());
        fieldLob.setText("Lob: " + gameAthlete.getLob());
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_long:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "left_long";
                break;
            case R.id.left_short:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "left_short";
                break;
            case R.id.middle_long:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "middle_long";
                break;
            case R.id.middle_short:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "middle_short";
                break;
            case R.id.right_long:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "right_long";
                break;
            case R.id.right_short:
                setTheme(R.style.ActionSheetStyleiOS7);
                position = "right_short";
                break;
        }
        showActionSheet();
    }

    public void showActionSheet() {
        actionS = ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("Service", "Reception", "Forehand",
                                        "Backhand", "Smash", "Slice", "Block", "Flick", "Lob")
                .setCancelableOnTouchOutside(true).setListener(this).show();
    }

    public void showDirectionSheet() {
        directionS = ActionSheet.createBuilder(this, getSupportFragmentManager())
                .setCancelButtonTitle("Cancel")
                .setOtherButtonTitles("crossed", "Parallel")
                .setCancelableOnTouchOutside(true).setListener(this).show();
    }

    @Override
    public void onOtherButtonClick(ActionSheet actionSheet, int index) {
        if(actionSheet == actionS) {
            switch (index) {
                case 0:
                    action = "service";
                    break;
                case 1:
                    action = "reception";
                    break;
                case 2:
                    action = "forehand";
                    break;
                case 3:
                    action = "backhand";
                    break;
                case 4:
                    action = "smash";
                    break;
                case 5:
                    action = "slice";
                    break;
                case 6:
                    action = "block";
                    break;
                case 7:
                    action = "flick";
                    break;
                case 8:
                    action = "lob";
                    break;
            }
            showDirectionSheet();
        } else {
            if (actionSheet == directionS) {
                switch (index) {
                    case 0:
                        direction = "crossed";
                        break;
                    case 1:
                        direction = "parallel";
                        break;
                }
                if(hit) {
                    gameAthlete.hitPoint(position, action, direction);
                } else {
                    gameOpponent.hitPoint(position, action, direction);
                }
                fillTable();
            }
        }
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancel) {
        if (!isCancel) {
            fieldScore.setText(gameAthlete.getTotal() + " X " + gameOpponent.getTotal());
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
        Intent intent = getIntent();
        Athlete athlete = (Athlete) intent.getSerializableExtra("athlete");
        Athlete athleteUser = (Athlete) intent.getSerializableExtra("user");
        Championship championship = (Championship) intent.getSerializableExtra("championship");
        switch (item.getItemId()) {
            case android.R.id.home:

                Intent intentRegister = new Intent(ScoutActivity.this, ChampRegisterActivity.class);
                intentRegister.putExtra("athlete", athlete);
                intentRegister.putExtra("user", athleteUser);
                intentRegister.putExtra("championship", championship);
                startActivity(intentRegister);
                finish();
                break;

            case R.id.menu_save_scout:
                Intent intentChart = new Intent(ScoutActivity.this, ChartActivity.class);
                intentChart.putExtra("game_athlete", gameAthlete);
                intentChart.putExtra("game_opponent", gameOpponent);
                intentChart.putExtra("athlete", athlete);
                intentChart.putExtra("user", athleteUser);
                intentChart.putExtra("championship", championship);
                startActivity(intentChart);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
