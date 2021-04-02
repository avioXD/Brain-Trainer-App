package com.example.braintrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class Home_Activity extends AppCompatActivity {

    Button start ;




    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        start = (Button) findViewById(R.id.startButton);
        animateDropIn();

        start.setBackgroundResource(R.drawable.start_button);


        //Click start button:>>>>>>>>>>>>>>>>>>>>>
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                start.animate().alpha(0f).setDuration(500);
                start.setBackgroundResource(R.drawable.start_button_fg);
                start.animate().alpha(1f).setDuration(300);
                Global_Class.setStart(true);
                Global_Class.easy();
                startActivity(new Intent(Home_Activity.this , Select_Game_Activity.class));
                finish();
            }
        });


    }

    @Override
    public void onBackPressed() {
    finish();
    }

//*******************Animations************************************//

    public void animateDropIn(){
        ImageView logo=(ImageView)findViewById(R.id.logo);
        ImageView logoName=(ImageView)findViewById(R.id.logoname);

        logo.setAlpha(0f);
        logoName.setAlpha(0f);
        start.setAlpha(0f);

        logo.setTranslationY(-100f);
        logoName.setTranslationY(-100f);
        start.setTranslationY(50f);


        logoName.animate().translationY(0f).alphaBy(1f).setDuration(1000);
        logo.animate().translationY(0f).alphaBy(1f).setDuration(1000);
        start.animate().translationY(0f).alphaBy(1f).setDuration(1000);


    }




}
