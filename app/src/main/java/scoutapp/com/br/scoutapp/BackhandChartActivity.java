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

public class BackhandChartActivity extends ChartBase implements SeekBar.OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChartBackhand;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_backhand_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // -----Backhand Chart-----
        mChartBackhand = (PieChart) findViewById(R.id.backhand_chart);
        mChartBackhand.setUsePercentValues(true);
        mChartBackhand.setDescription("");
        mChartBackhand.setExtraOffsets(5, 10, 5, 5);

        mChartBackhand.setDragDecelerationFrictionCoef(0.95f);

        mChartBackhand.setCenterTextTypeface(mTfLight);
        mChartBackhand.setCenterText(generateCenterSpannableText());

        mChartBackhand.setDrawHoleEnabled(false);
        mChartBackhand.setHoleColor(Color.WHITE);

        mChartBackhand.setTransparentCircleColor(Color.WHITE);
        mChartBackhand.setTransparentCircleAlpha(110);

        mChartBackhand.setHoleRadius(58f);
        mChartBackhand.setTransparentCircleRadius(61f);

        mChartBackhand.setDrawCenterText(false);

        mChartBackhand.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChartBackhand.setRotationEnabled(true);
        mChartBackhand.setHighlightPerTapEnabled(true);


        // add a selection listener
        mChartBackhand.setOnChartValueSelectedListener(this);

        setData();

        mChartBackhand.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChartAthlete.spin(2000, 0, 360);

        // entry label styling
        mChartBackhand.setEntryLabelColor(Color.BLACK);
        mChartBackhand.setEntryLabelTypeface(mTfRegular);
        mChartBackhand.setEntryLabelTextSize(12f);
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
                Intent intentChart = new Intent(BackhandChartActivity.this, ChartActivity.class);
                intentChart.putExtra("game_athlete", gameAthlete);
                intentChart.putExtra("game_opponent", gameOpponent);
                intentChart.putExtra("athlete", athlete);
                intentChart.putExtra("user", athleteUser);
                startActivity(intentChart);
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
        listTechniques.add(game.getBackhandLeftLongCrossed());
        listTechniques.add(game.getBackhandLeftLongParallel());
        listTechniques.add(game.getBackhandLeftShortCrossed());
        listTechniques.add(game.getBackhandLeftShortParallel());

        listTechniques.add(game.getBackhandMiddleLongCrossed());
        listTechniques.add(game.getBackhandMiddleLongParallel());
        listTechniques.add(game.getBackhandMiddleShortCrossed());
        listTechniques.add(game.getBackhandMiddleShortParallel());

        listTechniques.add(game.getBackhandRightLongCrossed());
        listTechniques.add(game.getBackhandRightLongParallel());
        listTechniques.add(game.getBackhandRightShortCrossed());
        listTechniques.add(game.getBackhandRightShortParallel());

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
        mChartBackhand.setData(data);

        // undo all highlights
        mChartBackhand.highlightValues(null);

        mChartBackhand.invalidate();
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
