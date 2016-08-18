package scoutapp.com.br.scoutapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;

import scoutapp.com.br.scoutapp.adapter.ItemAdapter;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.Game;
import scoutapp.com.br.scoutapp.model.Item;

public class ScoutActivity extends AppCompatActivity implements ItemAdapter.ItemListener{

    BottomSheetBehavior behavior;
    private BottomSheetDialog mBottomSheetTechniques;
    private BottomSheetDialog mBottomSheetDirection;
    private ItemAdapter mAdapter;
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

        fieldName.setText(athleteUser.getName().toUpperCase() + " X " + athleteOpponent.getName().toUpperCase());

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

        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new ItemAdapter(techniquesList(), this);
        recyclerView.setAdapter(mAdapter);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public void onItemClick(Item item) {
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Intent intent = getIntent();
//        athleteUser = (Athlete) intent.getSerializableExtra("user");
//        athleteOpponent = (Athlete) intent.getSerializableExtra("athlete");
//        fieldName.setText(athleteUser.getName().toUpperCase() + " X " + athleteOpponent.getName().toUpperCase());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.setListener(null);
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

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_long:
                position = "left_long";
                break;
            case R.id.left_short:
                position = "left_short";
                break;
            case R.id.middle_long:
                position = "middle_long";
                break;
            case R.id.middle_short:
                position = "middle_short";
                break;
            case R.id.right_long:
                position = "right_long";
                break;
            case R.id.right_short:
                position = "right_short";
                break;
        }
        showBottomSheetTechniques();
    }

    private void showBottomSheetTechniques() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        mBottomSheetTechniques = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.sheet, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(techniquesList(), new ItemAdapter.ItemListener() {
            @Override
            public void onItemClick(Item item) {
                if (mBottomSheetTechniques != null) {
                    switch (item.getTitle()) {
                        case "Service":
                            action = "service";
                            break;
                        case "Reception":
                            action = "reception";
                            break;
                        case "Forehand":
                            action = "forehand";
                            break;
                        case "Backhand":
                            action = "backhand";
                            break;
                        case "Smash":
                            action = "smash";
                            break;
                        case "Slice":
                            action = "slice";
                            break;
                        case "Block":
                            action = "block";
                            break;
                        case "Flick":
                            action = "flick";
                            break;
                        case "Lob":
                            action = "lob";
                            break;
                    }
                    mBottomSheetTechniques.dismiss();
                    showBottomSheetDirections();
                }
            }
        }));

        mBottomSheetTechniques.setContentView(view);
        mBottomSheetTechniques.show();
        mBottomSheetTechniques.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetTechniques = null;
            }
        });
    }

    private void showBottomSheetDirections() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        mBottomSheetDirection = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.sheet, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ItemAdapter(directionsList(), new ItemAdapter.ItemListener() {
            @Override
            public void onItemClick(Item item) {
                if (mBottomSheetDirection != null) {
                    switch (item.getTitle()) {
                        case "Crossed":
                            direction = "crossed";
                            Log.d("Direction", "crossed");
                            break;
                        case "Parallel":
                            direction = "parallel";
                            break;
                    }
                    mBottomSheetDirection.dismiss();
                }
            }
        }));

        mBottomSheetDirection.setContentView(view);
        mBottomSheetDirection.show();
        mBottomSheetDirection.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                if(hit) {
                    gameAthlete.hitPoint(position, action, direction);
                } else {
                    gameOpponent.hitPoint(position, action, direction);
                }
                fillTable();
                fieldScore.setText(gameAthlete.getTotal() + " X " + gameOpponent.getTotal());
                mBottomSheetDirection = null;
            }
        });
    }

    public ArrayList<Item> techniquesList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Service"));
        items.add(new Item("Reception"));
        items.add(new Item("Forehand"));
        items.add(new Item("Backhand"));
        items.add(new Item("Smash"));
        items.add(new Item("Slice"));
        items.add(new Item("Block"));
        items.add(new Item("Flick"));
        items.add(new Item("Lob"));

        return items;
    }

    public ArrayList<Item> directionsList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("Crossed"));
        items.add(new Item("Parallel"));

        return items;
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
}
