package com.example.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class Go_Activity extends AppCompatActivity {

    TextView levelView;
    ImageView levelBoard;
    Button go;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go);

        go=(Button)findViewById(R.id.GoButton);
        go.setBackgroundResource(R.drawable.gobutton);
        levelBoard=(ImageView)findViewById(R.id.levelBoard);
        levelView=(TextView)findViewById(R.id.levelNo);
        levelView.setText(Integer.toString(Global_Class.getLevel()));

        //Go button action perform;
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                go.setBackgroundResource(R.drawable.gobutton_fg);
                startActivity(new Intent(Go_Activity.this,Game_Board_Activity.class));
                finish();
            }
        });

        contentAnimate();

    }


    @Override
    public void onBackPressed() {
        startActivity(new Intent(Go_Activity.this, Select_Game_Activity.class));
        finish();
    }


    //***************************************// Animation In:
    public void contentAnimate(){
        //setButton before animate:
        go.setAlpha(0);
        go.setTranslationY(70f);
        //go button animate:
        go.animate().translationY(0f).alpha(1f).setDuration(600);

        levelBoard.setTranslationY(-50);
        levelBoard.setAlpha(0f);

        levelBoard.animate().translationY(0f).alpha(1f).setDuration(600);

        levelView.setTranslationY(-50f);
        levelView.setAlpha(0f);
        levelView.animate().translationY(0f).alpha(1f).setDuration(600);
    }

    //**********************************************************************
}



