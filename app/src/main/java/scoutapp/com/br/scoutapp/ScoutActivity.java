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
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

import scoutapp.com.br.scoutapp.adapter.ItemAdapter;
import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Championship;
import scoutapp.com.br.scoutapp.model.Game;
import scoutapp.com.br.scoutapp.model.Item;
import scoutapp.com.br.scoutapp.model.User;

public class ScoutActivity extends AppCompatActivity implements ItemAdapter.ItemListener{

    BottomSheetBehavior behavior;
    private BottomSheetDialog mBottomSheetTechniques;
    private BottomSheetDialog mBottomSheetDirection;
    private ItemAdapter mAdapter;
    private TextView fieldName;
    private TextView fieldScore;
    private TextView fieldTitleTable;
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
    private User athleteUser;
    private Game gameUser;
    private Game gameOpponent;
    private ArrayList<String> points;
    private Map<Integer, ArrayList> detailsPoint;
    private ArrayList<String> detailsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();

        fieldName = (TextView) this.findViewById(R.id.opponent_name);
        fieldScore = (TextView) this.findViewById(R.id.score);
        fieldTitleTable = (TextView) this.findViewById(R.id.title);
        fieldService = (TextView) this.findViewById(R.id.service);
        fieldReception = (TextView) this.findViewById(R.id.reception);
        fieldForehand = (TextView) this.findViewById(R.id.forehand);
        fieldBackhand = (TextView) this.findViewById(R.id.backhand);
        fieldSmash = (TextView) this.findViewById(R.id.smash);
        fieldSlice = (TextView) this.findViewById(R.id.slice);
        fieldBlock = (TextView) this.findViewById(R.id.block);
        fieldFlick = (TextView) this.findViewById(R.id.flick);
        fieldLob = (TextView) this.findViewById(R.id.lob);

        points = new ArrayList<>();
        detailsPoint = new HashMap();

        Intent intent = getIntent();
        athleteUser = (User) intent.getSerializableExtra("user");
        athleteOpponent = (Athlete) intent.getSerializableExtra("athlete_opponent");
        gameUser = (Game) intent.getSerializableExtra("game_user");
        gameOpponent = (Game) intent.getSerializableExtra("game_opponent");

        fieldName.setText(athleteUser.getName().toUpperCase() + " X " + athleteOpponent.getName().toUpperCase());

        if(gameUser != null){
            fillTable();
        } else{
            gameUser = new Game();
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
        Athlete athleteOpponent = (Athlete) intent.getSerializableExtra("athlete_opponent");
        User athleteUser = (User) intent.getSerializableExtra("user");
        Championship championship = (Championship) intent.getSerializableExtra("championship");
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intentRegister = new Intent(ScoutActivity.this, ChampRegisterActivity.class);
                intentRegister.putExtra("athlete_opponent", athleteOpponent);
                intentRegister.putExtra("user", athleteUser);
                intentRegister.putExtra("championship", championship);
                startActivity(intentRegister);
                finish();
                break;

            case R.id.menu_save_scout:
                Intent intentChart = new Intent(ScoutActivity.this, ChartActivity.class);
                intentChart.putExtra("game_user", gameUser);
                intentChart.putExtra("game_opponent", gameOpponent);
                intentChart.putExtra("athlete_opponent", athleteOpponent);
                intentChart.putExtra("user", athleteUser);
                intentChart.putExtra("championship", championship);
                startActivity(intentChart);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.left_long:
                position = "left_long";
                showBottomSheetTechniques();
                break;
            case R.id.left_short:
                position = "left_short";
                showBottomSheetTechniques();
                break;
            case R.id.middle_long:
                position = "middle_long";
                showBottomSheetTechniques();
                break;
            case R.id.middle_short:
                position = "middle_short";
                showBottomSheetTechniques();
                break;
            case R.id.right_long:
                position = "right_long";
                showBottomSheetTechniques();
                break;
            case R.id.right_short:
                position = "right_short";
                showBottomSheetTechniques();
                break;
            case R.id.undo:
                undo();
                break;
            case R.id.redo:
                redo();
                break;
        }
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
                    gameUser.hitPoint(position, action, direction);
                    points.add("hit");
                } else {
                    gameOpponent.hitPoint(position, action, direction);
                    points.add("miss");
                }
                detailsList = new ArrayList<>();
                detailsList.add(position);
                detailsList.add(action);
                detailsList.add(direction);
                detailsPoint.put(points.size()-1, detailsList);

                fillTable();
                fieldScore.setText(gameUser.getTotal() + " X " + gameOpponent.getTotal());
                mBottomSheetDirection = null;
            }
        });
    }

    public void redo(){
        Toast.makeText(ScoutActivity.this, "It is not possible to redo the point", Toast.LENGTH_LONG).show();
    }

    public void undo(){
        ArrayList list = detailsPoint.get(points.size()-1);
        if (!points.isEmpty()) {
            if (points.get(points.size() - 1) == "hit") {
                gameUser.undoPoint(list.get(0).toString(), list.get(1).toString(), list.get(2).toString());
            } else {
                gameOpponent.undoPoint(list.get(0).toString(), list.get(1).toString(), list.get(2).toString());
            }
            detailsPoint.remove(detailsPoint.get(points.size() - 1));
            points.remove(points.size() - 1);
            fillTable();
        } else {
            Toast.makeText(ScoutActivity.this, "It is not possible to undo the point", Toast.LENGTH_LONG).show();
        }
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
        fieldScore.setText(gameUser.getTotal() + " X " + gameOpponent.getTotal());
        fieldTitleTable.setText("HITS");
        fieldService.setText("Service: " + gameUser.getService());
        fieldReception.setText("Reception: " + gameUser.getReception());
        fieldForehand.setText("Forehand: " + gameUser.getForehand());
        fieldBackhand.setText("Backhand: " + gameUser.getBackhand());
        fieldSmash.setText("Smash: " + gameUser.getSmash());
        fieldSlice.setText("Slice: " + gameUser.getSlice());
        fieldBlock.setText("Block: " + gameUser.getBlock());
        fieldFlick.setText("Flick: " + gameUser.getFlick());
        fieldLob.setText("Lob: " + gameUser.getLob());
    }
}
