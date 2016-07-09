package scoutapp.com.br.scoutapp;

import android.content.Intent;
import android.os.Bundle;

import android.graphics.Color;
import android.graphics.Typeface;
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
import android.widget.SeekBar.OnSeekBarChangeListener;

import com.github.mikephil.charting.animation.Easing;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;


import java.util.ArrayList;

import scoutapp.com.br.scoutapp.model.Game;


public class ChartActivity extends DemoBase implements OnSeekBarChangeListener,
        OnChartValueSelectedListener {

    private PieChart mChartAthlete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setupActionBar();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // -----Athlete Chart-----
        mChartAthlete = (PieChart) findViewById(R.id.chartAthlete);
        mChartAthlete.setUsePercentValues(true);
        mChartAthlete.setDescription("");
        mChartAthlete.setExtraOffsets(5, 10, 5, 5);

        mChartAthlete.setDragDecelerationFrictionCoef(0.95f);

        mChartAthlete.setCenterTextTypeface(mTfLight);
        mChartAthlete.setCenterText(generateCenterSpannableText());

        mChartAthlete.setDrawHoleEnabled(true);
        mChartAthlete.setHoleColor(Color.WHITE);

        mChartAthlete.setTransparentCircleColor(Color.WHITE);
        mChartAthlete.setTransparentCircleAlpha(110);

        mChartAthlete.setHoleRadius(58f);
        mChartAthlete.setTransparentCircleRadius(61f);

        mChartAthlete.setDrawCenterText(true);

        mChartAthlete.setRotationAngle(0);
        // enable rotation of the chart by touch
        mChartAthlete.setRotationEnabled(true);
        mChartAthlete.setHighlightPerTapEnabled(true);


        // add a selection listener
        mChartAthlete.setOnChartValueSelectedListener(this);

        setData(9, 100);

        mChartAthlete.animateY(1400, Easing.EasingOption.EaseInOutQuad);
        // mChartAthlete.spin(2000, 0, 360);

        // entry label styling
        mChartAthlete.setEntryLabelColor(Color.BLACK);
        mChartAthlete.setEntryLabelTypeface(mTfRegular);
        mChartAthlete.setEntryLabelTextSize(12f);
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_chart, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intentRegister = new Intent(ChartActivity.this, ScoutActivity.class);
                startActivity(intentRegister);
                break;

            case R.id.actionToggleValues: {
                for (IDataSet<?> set : mChartAthlete.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChartAthlete.invalidate();
                break;
            }
            case R.id.actionToggleHole: {
                if (mChartAthlete.isDrawHoleEnabled())
                    mChartAthlete.setDrawHoleEnabled(false);
                else
                    mChartAthlete.setDrawHoleEnabled(true);
                mChartAthlete.invalidate();
                break;
            }
            case R.id.actionDrawCenter: {
                if (mChartAthlete.isDrawCenterTextEnabled())
                    mChartAthlete.setDrawCenterText(false);
                else
                    mChartAthlete.setDrawCenterText(true);
                mChartAthlete.invalidate();
                break;
            }
            case R.id.actionToggleXVals: {
                mChartAthlete.setDrawEntryLabels(!mChartAthlete.isDrawEntryLabelsEnabled());
                mChartAthlete.invalidate();
                break;
            }
            case R.id.actionSave: {
                // mChartAthlete.saveToGallery("title"+System.currentTimeMillis());
                mChartAthlete.saveToPath("title" + System.currentTimeMillis(), "");
                break;
            }
            case R.id.actionTogglePercent:
                mChartAthlete.setUsePercentValues(!mChartAthlete.isUsePercentValuesEnabled());
                mChartAthlete.invalidate();
                break;
            case R.id.animateX: {
                mChartAthlete.animateX(1400);
                break;
            }
            case R.id.animateY: {
                mChartAthlete.animateY(1400);
                break;
            }
            case R.id.animateXY: {
                mChartAthlete.animateXY(1400, 1400);
                break;
            }
            case R.id.actionToggleSpin: {
                mChartAthlete.spin(1000, mChartAthlete.getRotationAngle(), mChartAthlete.getRotationAngle() + 360, Easing.EasingOption
                        .EaseInCubic);
                break;
            }
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

    private void setData(int count, float range) {

        float mult = range;

        ArrayList<PieEntry> entries = new ArrayList<>();

        Intent intent = getIntent();
        Game game = (Game) intent.getSerializableExtra("game");

        ArrayList<Integer>listTechniques = new ArrayList<>();
        listTechniques.add(game.getService());
        listTechniques.add(game.getReceiving());
        listTechniques.add(game.getForehand());
        listTechniques.add(game.getBackhand());
        listTechniques.add(game.getSmash());
        listTechniques.add(game.getSlice());
        listTechniques.add(game.getBlock());
        listTechniques.add(game.getFlick());
        listTechniques.add(game.getLob());

        for (int i = 0; i < listTechniques.size() ; i++) {
            if(listTechniques.get(i) > 0){
                entries.add(new PieEntry((float)  listTechniques.get(i)/game.getTotal() * 100, mTechniques[i]));
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
        mChartAthlete.setData(data);

        // undo all highlights
        mChartAthlete.highlightValues(null);

        mChartAthlete.invalidate();
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
