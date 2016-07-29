package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.SeekBar;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

import scoutapp.com.br.scoutapp.model.Athlete;
import scoutapp.com.br.scoutapp.model.Game;

public class ForehandChartActivity extends ChartBase implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChartForehand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forehand_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // -----Forehand Chart-----
        mChartForehand = (PieChart) findViewById(R.id.forehand_chart);
        mChartForehand.setUsePercentValues(true);
        mChartForehand.setDescription("");
        mChartForehand.setExtraOffsets(5, 10, 5, 5);

        mChartForehand.setDragDecelerationFrictionCoef(0.95f);

        mChartForehand.setCenterTextTypeface(mTfLight);
        mChartForehand.setCenterText(generateCenterSpannableText());

        mChartForehand.setDrawHoleEnabled(false);
        mChartForehand.setHoleColor(Color.WHITE);

        mChartForehand.setTransparentCircleColor(Color.WHITE);
        mChartForehand.setTransparentCircleAlpha(110);

        mChartForehand.setHoleRadius(58f);
        mChartForehand.setTransparentCircleRadius(61f);

        mChartForehand.setDrawCenterText(false);

        mChartForehand.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChartForehand.setRotationEnabled(true);
        mChartForehand.setHighlightPerTapEnabled(true);


        // add a selection listener
        mChartForehand.setOnChartValueSelectedListener(this);

        setData();

        mChartForehand.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChartAthlete.spin(2000, 0, 360);

        // entry label styling
        mChartForehand.setEntryLabelColor(Color.BLACK);
        mChartForehand.setEntryLabelTypeface(mTfRegular);
        mChartForehand.setEntryLabelTextSize(12f);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chart_techniques, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = getIntent();
        Game gameAthlete = (Game) intent.getSerializableExtra("game_athlete");
        Game gameOpponent = (Game) intent.getSerializableExtra("game_opponent");
        Athlete athlete = (Athlete) intent.getSerializableExtra("athlete");
        Athlete athleteUser = (Athlete) intent.getSerializableExtra("user");
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intentRegister = new Intent(ForehandChartActivity.this, ChartActivity.class);
                intentRegister.putExtra("game_athlete", gameAthlete);
                intentRegister.putExtra("game_opponent", gameOpponent);
                intentRegister.putExtra("athlete", athlete);
                intentRegister.putExtra("user", athleteUser);
                startActivity(intentRegister);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

//        tvX.setText("" + (mSeekBarX.getProgress()));
//        tvY.setText("" + (mSeekBarY.getProgress()));
//
//        setData(mSeekBarX.getProgress(), mSeekBarY.getProgress());
    }

    private void setData() {

        ArrayList<PieEntry> entries = new ArrayList<>();

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game_athlete");

        ArrayList<Integer>listTechniques = new ArrayList<>();
        listTechniques.add(game.getForehandLeftLongCrossed());
        listTechniques.add(game.getForehandLeftLongParallel());
        listTechniques.add(game.getForehandLeftShortCrossed());
        listTechniques.add(game.getForehandLeftShortParallel());

        listTechniques.add(game.getForehandMiddleLongCrossed());
        listTechniques.add(game.getForehandMiddleLongParallel());
        listTechniques.add(game.getForehandMiddleShortCrossed());
        listTechniques.add(game.getForehandMiddleShortParallel());

        listTechniques.add(game.getForehandRightLongCrossed());
        listTechniques.add(game.getForehandRightLongParallel());
        listTechniques.add(game.getForehandRightShortCrossed());
        listTechniques.add(game.getForehandRightShortParallel());

        for (int i = 0; i < listTechniques.size() ; i++) {
            if(listTechniques.get(i) > 0){
                entries.add(new PieEntry((float)  listTechniques.get(i)/game.getTotal() * 100, mTechniquesSpec[i]));
            }
        }

        PieDataSet dataSet = new PieDataSet(entries, "");
        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);

        // add a lot of colors

        ArrayList<Integer> colors = new ArrayList<>();

        for (int c : ColorTemplate.VORDIPLOM_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.JOYFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.COLORFUL_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.LIBERTY_COLORS)
            colors.add(c);

        for (int c : ColorTemplate.PASTEL_COLORS)
            colors.add(c);

        colors.add(ColorTemplate.getHoloBlue());

        dataSet.setColors(colors);
        //dataSet.setSelectionShift(0f);

        PieData data = new PieData(dataSet);
        data.setValueFormatter(new PercentFormatter());
        data.setValueTextSize(11f);
        data.setValueTextColor(Color.BLACK);
        data.setValueTypeface(mTfLight);
        mChartForehand.setData(data);

        // undo all highlights
        mChartForehand.highlightValues(null);

        mChartForehand.invalidate();
    }

    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("SCOUTChart\n Athlete performance");
        s.setSpan(new RelativeSizeSpan(1.7f), 0, 12, 0);
        s.setSpan(new StyleSpan(Typeface.NORMAL), 14, s.length() - 15, 0);
        s.setSpan(new ForegroundColorSpan(Color.GRAY), 14, s.length() - 15, 0);
        s.setSpan(new RelativeSizeSpan(.8f), 14, s.length() - 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 14, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 20, s.length(), 0);
        return s;
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        if (e == null)
            return;
        Log.i("VAL SELECTED",
                "Value: " + e.getY() + ", index: " + h.getX()
                        + ", DataSet index: " + h.getDataSetIndex());
    }

    @Override
    public void onNothingSelected() {
        Log.i("PieChart", "nothing selected");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO Auto-generated method stub
    }

}
