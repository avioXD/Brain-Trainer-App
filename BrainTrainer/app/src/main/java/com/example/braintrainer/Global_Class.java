package com.example.braintrainer;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

class Global_Class {
    Global_Class global_class;
    //**********************************************************

    private static int time=0;
    public static int getTime(){
        return time;
    }
    public static void setTime(int set){
        time=set;

    }

    //Game started state and finish state:******************************************
    private static boolean isStart=true, isFinish=false;
    public static  void setFinish(boolean set){
        isFinish=set;
    }
    public static void setStart(boolean set){
        isStart=set;
    }
    public static boolean getStart(){
       return isStart;
    }
    public static boolean getFinish(){
        return isFinish;
    }

   //*********************************************//
    //setter and getter for gameType 1:Addition 2:Subtraction 3:Multiplication 4:Division
    private static int gameType=1;
    public static void setGameType(int set){
       gameType=set;
    }
    public static int getGameType(){
        return gameType;
    }



    //************************************************************************
    private static String result=Integer.toString(0);
    public static boolean checkResult(String get){
        if(result.equals(get)){
            return true;
        }else{
            return false;
        }
    }
    public static void setResult(String set){
        result=set;
    }


   // score calculate:*******************************************************
    private static int level=1;
    private static int maxLevel=1;
    private static int questionDifuclty=0;
    private static int totalScore=0;
    private static int questionMarks=1;
    private static int timeReduction=10;
    public static void levelUp(){
        level+=1;
        questionMarks+=1;
        setTime(getTime()-timeReduction);
    }
    public static int getLevel(){
        return level;
    }
    public static void resetLevel(){
        level=1;
    }

    //set defuculty:
    public static void easy(){
        maxLevel=5;
        questionDifuclty=10;
        setTime(60);
    }
    public static void medium(){
        maxLevel=80;
        questionDifuclty=50;
        setTime(90);
    }
    public static void hard(){
        maxLevel=10;
        questionDifuclty=150;
        setTime(110);
    }

    //
    public static int getQuestionDifuclty(){
        return questionDifuclty;
    }

    ////
    public static int points=0;
    public static void resetPoint(){
        points=0;
    }
    public static void upPoints(){
        points+=1;
    }
    public static int getPoints(){
        return points;
    }

    public static void updateTotalScore(){
        totalScore+=points*questionMarks;
    }
    public static int getTotalScore(){
        return totalScore;
    }
    public static void resetTotalScore(){
        totalScore=0;
    }
    public static int wrongPoints=0;
    public static void upWrongPoints(){
        wrongPoints+=1;
    }
    public static void resetWrongPoint(){
        points=0;
    }
    public static void getWrongPoints(){
        points+=1;
    }
    public static int getMaxLevel(){
        return maxLevel;
    }
    public static void resetScores(){
        points=0;
        totalScore=0;
        wrongPoints=0;
        questionMarks=1;
    }


}
