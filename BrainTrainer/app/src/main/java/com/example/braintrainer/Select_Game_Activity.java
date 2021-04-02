package com.example.braintrainer;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.zip.Inflater;

import static com.example.braintrainer.R.id.closeButton;
import static com.example.braintrainer.R.id.easy;
import static com.example.braintrainer.R.id.optionsButton;
import static com.example.braintrainer.R.id.parent;


public class Select_Game_Activity extends Activity {

    Button add,sub,multi,div,about,settings;
    boolean chosed;
    Intent intent;
    ImageView text;
    Dialog settingsDialog;
    Button close;
    CardView settingsCardView;
    Button easy,medium,hard;
    boolean aboutIsShowing=false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_mode);



        //declaring buttons:
        add=(Button)findViewById(R.id.additionButton);
        sub=(Button)findViewById(R.id.substractionButton);
        multi=(Button)findViewById(R.id.multiplicationButton);
        div=(Button)findViewById(R.id.divisionButton);
        about=(Button)findViewById(R.id.aboutButton);
        settings=(Button)findViewById(R.id.optionsButton);
        text=(ImageView)findViewById(R.id.choseTraining);

        //Run every time :
        defaultXml();
        chosed=false;
        onClickedButtons();
        Global_Class.resetScores();
        Global_Class.resetLevel();

        //animations:
        animateOtherObjects();
        catagoryAnimateIn(add,400);
        catagoryAnimateIn(sub,500);
        catagoryAnimateIn(multi,600);
        catagoryAnimateIn(div,700);


    }

    @Override
    public void onBackPressed() {
        startActivity(new Intent(this, Home_Activity.class));
        finish();
    }

//?****************************************************************************************//
    //After clicked the changes:
    public void onClickedButtons(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosed==false){
                    chosed=true;
                    add.setBackgroundResource(R.drawable.addition_hover);
                    //Working Function:
                    nextPage(1);


                }
            }
        });

        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosed==false){
                    chosed=true;
                    sub.setBackgroundResource(R.drawable.substraction_hover);
                    //Working Function:
                    nextPage(2);

                }
            }
        });

        multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosed==false){
                    chosed=true;
                    multi.setBackgroundResource(R.drawable.multiplication_hover);
                    //Working Function:
                    nextPage(3);

                }
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chosed==false){
                    chosed=true;
                    div.setBackgroundResource(R.drawable.division_hover);
                    //Working Function:
                    nextPage(4);
                }
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                settings.animate().rotation(360).alpha(0f).setDuration(300);
                settingsCardView.setVisibility(View.VISIBLE);
                LayoutInflater inflater=LayoutInflater.from(Select_Game_Activity.this);
                View view=inflater.inflate(R.layout.activity_settings_overlay,null);
                settingsCardView.addView(view);
                settingsCardView.setAlpha(0f);
                settingsCardView.animate().alpha(1f).setDuration(300);

             /*
                Dialog newDialog=new Dialog(Select_Game_Activity.this);
                newDialog.setContentView(R.layout.activity_settings_overlay);
                newDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
                newDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                Window window=newDialog.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();
                wlp.gravity = Gravity.TOP | Gravity.RIGHT;
                newDialog.setCancelable(false);
                close=(Button)newDialog.findViewById(R.id.closeButton);
                newDialog.show();*/
                close=view.findViewById(closeButton);
                close.animate().rotation(360f).setDuration(300);

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        close.animate().rotation(360).alpha(0f).setDuration(300);
                        settings.animate().rotation(720).alpha(1f).setDuration(700);
                        settingsCardView.setVisibility(View.GONE);
                    }
                });
                easy=view.findViewById(R.id.easy);
                medium=view.findViewById(R.id.medium);
                hard=view.findViewById(R.id.hard);
                easy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Global_Class.easy();
                        easy.setBackgroundResource(R.drawable.easy_yellow);
                        medium.setBackgroundResource(R.drawable.medium);
                        hard.setBackgroundResource(R.drawable.hard);
                    }
                });
                medium.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Global_Class.medium();
                        medium.setBackgroundResource(R.drawable.medium_yellow);
                        easy.setBackgroundResource(R.drawable.easy);
                        hard.setBackgroundResource(R.drawable.hard);

                    }
                });
                hard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Global_Class.hard();
                        hard.setBackgroundResource(R.drawable.hard_yellow);
                        easy.setBackgroundResource(R.drawable.easy);
                        medium.setBackgroundResource(R.drawable.medium);
                    }
                });

            }

        });
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = LayoutInflater.from(Select_Game_Activity.this);
                View view = inflater.inflate(R.layout.about_layout, null);
                CardView cardView = (CardView) findViewById(R.id.aboutShow);
                cardView.addView(view);
                if(!aboutIsShowing) {
                   cardView.setVisibility(View.VISIBLE);
                   aboutIsShowing=true;

                   
                }else{
                    cardView.setVisibility(View.GONE);
                    aboutIsShowing=false;
                }


            }
        });


    }

    //Next page data functions:
    public void nextPage(int option){
        intent=new Intent();
        intent.putExtra("Options", option);
        Global_Class.setGameType(option);
        startActivity(new Intent(this, Go_Activity.class));
        finish();
    }


    //*******************************************************************//






    //********************************************************************************//
    //animate entry:
    public void catagoryAnimateIn(Button button,int time){
        //setOptions animate:
        button.setTranslationX(-100f);
        button.setAlpha(.5f);
        //animate options:
        button.animate().translationX(0f).alpha(1f).setDuration(time);
    }

    public void animateOtherObjects(){
        //steAnimate text:
        text.setTranslationY(-50f);
        text.setAlpha(0f);
        //animate Text:
        text.animate().translationY(0f).alpha(1f).setDuration(500);

        about.setAlpha(0f);
        about.animate().alpha(1f).setDuration(600);


        settings.setAlpha(0f);
        settings.animate().rotation(360).alpha(1f).setDuration(700);

    }
    //default design:
    public void defaultXml(){
        text.setImageResource(R.drawable.chose_yourtraining);
        add.setBackgroundResource(R.drawable.addition);
        sub.setBackgroundResource(R.drawable.substraction);
        multi.setBackgroundResource(R.drawable.multiplication);
        div.setBackgroundResource(R.drawable.division);
        settingsCardView=(CardView)findViewById(R.id.settingsCard);
    }


}
