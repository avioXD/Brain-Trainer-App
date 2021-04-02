package com.example.braintrainer;

import android.app.Application;


import java.util.ArrayList;
import java.util.Collections;


public class Start_newGame extends Application{
    private String question="Null";
    private ArrayList<String> arrayList;
    private int option;

    public  Start_newGame()  {
        //Global_Class;
        switch(Global_Class.getGameType()){
            case 1:
        Training_Addition training_addition=new Training_Addition(Global_Class.getLevel());
        setQuestions(training_addition.getQuestion(),training_addition.getAnsArray_String());
                break;
           case 2:
               Training_substraction training_substraction=new Training_substraction(Global_Class.getLevel());
               setQuestions(training_substraction.getQuestion(),training_substraction.getAnsArray_String());
               break;
           case 3:
               Training_Multiplication training_multiplication=new Training_Multiplication(Global_Class.getLevel());
               setQuestions(training_multiplication.getQuestion(),training_multiplication.getAnsArray_String());
               break;
           case 4:
               Training_Division training_division=new Training_Division(Global_Class.getLevel());
               setQuestions(training_division.getQuestion(),training_division.getAnsArray_String());
           default:
       }


    }
 //******************************************************************
    //convert String to arrayList and shuffeling :  ans[3] = Real Ans:
    public void  setQuestions(String setQ,String[] ansList) {
        Global_Class.setResult(ansList[3]);
        arrayList=new ArrayList<String>();
        question=setQ;
        for(int n=0;n<4;n++){
            arrayList.add(ansList[n]);
        }
        shuffleAns();
    }

    //shuffle Questions:
    public void shuffleAns(){
        Collections.shuffle(arrayList);
    }
    public String getAnswerSetItems(int index){
        return (arrayList.get(index));
    }
    public ArrayList<String> getArrayList(){
        return arrayList;
    }
    public String getQuestion(){

        try {
            return question;
        }catch (NullPointerException e){
            return question="Null";
        }
    }
    //**********************************************************************
}
