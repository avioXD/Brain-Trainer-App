package com.example.braintrainer;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game_Score_Activity extends AppCompatActivity {

    TextView showScore;
    Button nextLevel,Home;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_score);
        setContentId();
        animateIn();
        nextLevel.setBackgroundResource(R.drawable.nextlevel);
        if(Global_Class.getLevel()==Global_Class.getMaxLevel()) {
            nextLevel.setBackgroundResource(R.drawable.gameover_hover);
            nextLevel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        nextLevel.setBackgroundResource(R.drawable.gameover);
                        startActivity(new Intent(Game_Score_Activity.this, Select_Game_Activity.class));
                        finish();
                    }
            });
        }else{
            nextLevel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (Global_Class.getLevel() != Global_Class.getMaxLevel()) {
                        Global_Class.levelUp();
                        nextLevel.setBackgroundResource(R.drawable.nextlevel_hover);
                        startActivity(new Intent(Game_Score_Activity.this, Go_Activity.class));
                        finish();
                    }
                }
            });
        }
        showContentView();

        Home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Home.setBackgroundResource(R.drawable.home_button_hover);
                startActivity(new Intent(Game_Score_Activity.this,Home_Activity.class));
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(Game_Score_Activity.this, Game_Score_Activity.class));
        finish();
    }

    public void setContentId(){
        showScore=(TextView)findViewById(R.id.score);
        nextLevel=(Button) findViewById(R.id.nextLevel);
        Home=(Button) findViewById(R.id.goHome);
    }

    public void showContentView(){
        showScore.setText(Integer.toString(Global_Class.getTotalScore()));
    }

    //animations:
    public void animateIn(){
        ImageView board=(ImageView)findViewById(R.id.scoreBoardview);
        board.setTranslationY(-50f);
        board.setAlpha(0f);

        board.animate().translationY(0f).alpha(1f).setDuration(700);

        showScore.setAlpha(0f);
        showScore.setTranslationY(-50f);
        showScore.animate().translationY(0f).alpha(1f).setDuration(700);

        Home.setTranslationX(-10f);
        Home.setAlpha(0f);
        Home.animate().translationX(0f).alpha(1f).setDuration(700);

        nextLevel.setTranslationX(50f);
        nextLevel.setAlpha(0f);
        nextLevel.animate().translationX(0f).alpha(1f).setDuration(700);
    }
}
