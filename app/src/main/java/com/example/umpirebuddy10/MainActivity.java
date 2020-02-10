package com.example.umpirebuddy10;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView strikeCount;
    TextView ballCount;

    int strikeNum = 0;
    int ballNum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button exit   = findViewById(R.id.exit);
        Button reset  = findViewById(R.id.reset);
        Button sInc   = findViewById(R.id.sInc);
        Button bInc   = findViewById(R.id.bInc);
        Button about  = findViewById(R.id.about);

        strikeCount = findViewById(R.id.strikeCount);
        ballCount = findViewById(R.id.ballCount);

        sInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(strikeNum < 3 && ballNum < 4)
                {
                    strikeNum++;
                    strikeCount.setText(Integer.toString(strikeNum));
                }

                if(strikeNum == 3)
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Three Strikes!")
                            .setMessage("Batter's Out!")
                            .setNeutralButton("Close", null)
                            .setIcon(android.R.drawable.stat_sys_warning).show();
                }


            }
        });

        bInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(ballNum < 4 && strikeNum < 3)
                {
                    ballNum++;
                    ballCount.setText(Integer.toString(ballNum));
                }

                if(ballNum == 4)
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Four Balls!")
                            .setMessage("Batter Walks!")
                            .setNeutralButton("Close", null)
                            .setIcon(android.R.drawable.stat_sys_warning).show();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(strikeNum < 3 && ballNum < 4)
                {
                    finish();
                    System.exit(0);
                }

                if(strikeNum == 3)
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Batter is out!")
                            .setMessage("Reset the counts.")
                            .setNeutralButton("Close", null)
                            .setIcon(android.R.drawable.stat_sys_warning).show();
                }

                if(ballNum == 4)
                {
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Batter has walked!")
                            .setMessage("Reset the counts.")
                            .setNeutralButton("Close", null)
                            .setIcon(android.R.drawable.stat_sys_warning).show();
                }

            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strikeNum = 0;
                ballNum = 0;

                strikeCount.setText(Integer.toString(strikeNum));
                ballCount.setText(Integer.toString(ballNum));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(strikeNum < 3 && ballNum < 4) {
                    openAbout();
                }
            }
        });
    }

    public void openAbout() {
        Intent intent = new Intent(this, About.class);
        startActivity(intent);
    }
}
