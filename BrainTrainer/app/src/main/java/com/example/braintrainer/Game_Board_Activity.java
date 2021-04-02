package com.example.braintrainer;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class Game_Board_Activity extends AppCompatActivity {

    Start_newGame newGame;
    TextView clickResult[] = new TextView[4], mathView, timerView;
    Button showGameLevel, questionCountshow, nextButton;
    private boolean answered = false, clicked = false;
    private CountDownTimer timer;
    private int qCount=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_board);
        setContentId();
        createQuestions();
        startTimmer();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (answered == true) {
                    buttonClickAnimate(nextButton);
                    nextButton.setBackgroundResource(R.drawable.nextbutton_hover);
                    createQuestions();
                    answered = false;

                }
            }
        });
        animateIn();
    }

    //Create Question
    public void createQuestions() {
        qCount++;
        defaultXmlIn();
        clicked = false;
        answered = false;
        newGame = new Start_newGame();
        setQuestionContentView();
        questionCountshow.setText("Question: "+Integer.toString(qCount));
    }


    //XML contents define:
    public void setContentId() {
        mathView = (TextView) findViewById(R.id.qut_text_Button);
        timerView = (TextView) findViewById(R.id.timmer_textButton);
        clickResult[0] = (TextView) findViewById(R.id.op1);
        clickResult[1] = (TextView) findViewById(R.id.op2);
        clickResult[2] = (TextView) findViewById(R.id.op3);
        clickResult[3] = (TextView) findViewById(R.id.op4);
        showGameLevel = (Button) findViewById(R.id.gameLevelShow);
        questionCountshow = (Button) findViewById(R.id.showQuestionCount);
        nextButton = (Button) findViewById(R.id.nextQuestionButton);
    }

    @Override
    public void onBackPressed() {
        timer.cancel();
        startActivity(new Intent(Game_Board_Activity.this, Select_Game_Activity.class));
        finish();
    }

    // Question arranging action perform:
    public void setQuestionContentView() {
        mathView.setText(newGame.getQuestion());
        for (int i = 0; i < 4; i++) {
            clickResult[i].setText(getAnswerSetItems(i));
        }

    }

    public String getAnswerSetItems(int index) {
        return (newGame.getArrayList().get(index));
    }

    //.........................................................
    ///Animate Default:
    public void animateIn() {
        showGameLevel.setText("Level " + Integer.toString(Global_Class.getLevel()));
    }

    public void checkedCardAnimate(int card, int timmer) {
        clickResult[card].setAlpha(0f);
        clickResult[card].animate().alpha(1f).setDuration(timmer);
    }

    public void buttonClickAnimate(Button button) {
        button.setAlpha(0f);
        button.animate().alpha(1f).setDuration(400);
    }

    public void defaultXmlIn() {
        buttonClickAnimate(nextButton);
        nextButton.setBackgroundResource(R.drawable.nextbutton_hover);
        for (int i = 0; i < 4; i++) {
            clickResult[i].setBackgroundResource(R.drawable.op1);
            clickResult[i].setTextColor(getResources().getColor(R.color.orange_500));

        }

    }

        //Tap on cards:
    public void tapCard(View view){
        if(clicked==false && answered==false) {
            Log.i("Check:", "True");
            clicked=true;
            answered=true;
            int cardTag = Integer.parseInt(view.getTag().toString());
            clickResult[cardTag].animate().setDuration(200);
            if (Global_Class.checkResult(clickResult[cardTag].getText().toString()) && answered==true) {

                Global_Class.upPoints();

                checkedCardAnimate(cardTag,200);
                clickResult[cardTag].setBackgroundResource(R.drawable.opclicked_correct);
                clickResult[cardTag].setTextColor(getResources().getColor(R.color.white));

            } else{
                Global_Class.upWrongPoints();
                Global_Class.getWrongPoints();
                checkedCardAnimate(cardTag,2000);
                clickResult[cardTag].setBackgroundResource(R.drawable.opclicked_wrong);
                clickResult[cardTag].setTextColor(getResources().getColor(R.color.white));

                for (int i = 0; i < 4; i++) {
                    if (Global_Class.checkResult(clickResult[i].getText().toString())) {
                        Log.i("Check:", "Check true");
                        checkedCardAnimate(cardTag,200);
                        clickResult[i].setBackgroundResource(R.drawable.opclicked_correct);
                        clickResult[i].setTextColor(getResources().getColor(R.color.white));
                        clicked=false;
                    }
                }
            }
        }else{
            Log.i("Check:", "False");
        }
        answered=true;
    }
   //Question timmer:
    public void startTimmer() {
        timer=new CountDownTimer(Global_Class.getTime()*1000+100,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerView.setText(Integer.toString((int) (millisUntilFinished / 1000)) + "s");
            }

            @Override
            public void onFinish() {
                Global_Class.updateTotalScore();
                startActivity(new Intent(Game_Board_Activity.this, Game_Score_Activity.class));
                timer.cancel();
                finish();
            }
        }.start();


    }
}

