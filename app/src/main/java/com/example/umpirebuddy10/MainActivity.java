package com.example.umpirebuddy10;
import androidx.appcompat.app.AppCompatActivity;
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

        strikeCount = findViewById(R.id.strikeCount);
        ballCount = findViewById(R.id.ballCount);

        sInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                strikeNum++;
                strikeCount.setText(Integer.toString(strikeNum));
            }
        });

        bInc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ballNum++;
                ballCount.setText(Integer.toString(ballNum));
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ;               strikeNum = 0;
                ballNum = 0;

                strikeCount.setText(Integer.toString(strikeNum));
                ballCount.setText(Integer.toString(ballNum));
            }
        });
    }
}
