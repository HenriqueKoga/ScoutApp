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
import android.widget.TextView;

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

    private boolean buttonLeftLong = false;
    private boolean buttonLeftShort = false;
    private Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        game = new Game();

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

        fieldScore.setText("Hits: " + game.getTotal());
        fieldService.setText("Service: " + game.getService());
        fieldReceiving.setText("Receiving: " + game.getReceiving());
        fieldForehand.setText("Forehand: " + game.getForehand());
        fieldBackhand.setText("Backhand: " + game.getBackhand());
        fieldSmash.setText("Smash: " + game.getSmash());
        fieldSlice.setText("Slice: " + game.getSlice());
        fieldBlock.setText("Block: " + game.getBlock());
        fieldFlick.setText("Flick: " + game.getFlick());
        fieldLob.setText("Lob: " + game.getLob());

        Intent intent = getIntent();
        Athlete athlete = (Athlete) intent.getSerializableExtra("athlete");

        if(athlete != null){
            fieldName.setText("ATHLETE_NAME X " + athlete.getName().toUpperCase());
        }
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
        game.setService(game.getService() + 1);
        fieldService.setText("Service: " + game.getService());
    }

    private void receivingPoint() {
        game.setReceiving(game.getReceiving() + 1);
        fieldReceiving.setText("Receiving: " + game.getReceiving());
    }

    private void forehandPoint() {
        if (buttonLeftLong) {
            game.setForehandLeftLong(game.getForehandLeftLong() + 1);
            buttonLeftLong = false;
        }
        if (buttonLeftShort) {
            game.setForehandLeftShort(game.getForehandLeftShort() + 1);
            buttonLeftShort = false;
        }
        game.setForehand(game.getForehand() + 1);
        fieldForehand.setText("Forehand: " + game.getForehand());
        Log.d("Forehand Long", "forehand left long: " + game.getForehandLeftLong());
        Log.d("Forehand Short", "forehand left short: " + game.getForehandLeftShort());
        Log.d("Forehand Total", "forehand total: " + game.getForehand());
    }

    private void backhandPoint() {
        game.setBackhand(game.getBackhand() + 1);
        fieldBackhand.setText("Backhand: " + game.getBackhand());
    }

    private void smashPoint() {
        game.setSmash(game.getSmash() + 1);
        fieldSmash.setText("Smash: " + game.getSmash());
    }

    private void slicePoint() {
        game.setSlice(game.getSlice() + 1);
        fieldSlice.setText("Slice: " + game.getSlice());
    }

    private void blockPoint() {
        game.setBlock(game.getBlock() + 1);
        fieldBlock.setText("Block: " + game.getBlock());
    }

    private void flickPoint() {
        game.setFlick(game.getFlick() + 1);
        fieldFlick.setText("Flick: " + game.getFlick());
    }

    private void lobPoint() {
        game.setLob(game.getLob() + 1);
        fieldLob.setText("Lob: " + game.getLob());
    }

    @Override
    public void onDismiss(ActionSheet actionSheet, boolean isCancle) {
        game.setTotal(game.getTotal() + 1);
        fieldScore.setText("Acertos: " + game.getTotal());
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
                Intent intentHome = new Intent(ScoutActivity.this, ChartActivity.class);
                startActivity(intentHome);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
