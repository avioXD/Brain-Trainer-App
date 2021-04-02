package com.example.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_Over_Activity extends AppCompatActivity {
    ImageView goBack,home_button;
    TextView score;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        score=(TextView)findViewById(R.id.highScore) ;
        score.setText(Integer.toString(Global_Class.getTotalScore()));
        home_button=(ImageView)findViewById(R.id.home_button);
        home_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Game_Over_Activity.this,Home_Activity.class));
                finish();
            }
        });
    }
}
