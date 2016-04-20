package scoutapp.com.br.scoutapp.scout.com.br.scout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import scoutapp.com.br.scoutapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView newScout = (TextView) findViewById(R.id.new_scout);
        newScout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentNewScout = new Intent(HomeActivity.this, ScoutActivity.class);
                startActivity(intentNewScout);
            }
        });


        TextView history = (TextView) findViewById(R.id.history);
        history.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intentNovoScout = new Intent(HomeActivity.this, HistoryActivity.class);
                startActivity(intentNovoScout);
            }
        });

    }
}
