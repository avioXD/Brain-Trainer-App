package com.example.braintrainer;

import java.util.Random;

public class Random_Number_Level {


    public int genRandomQuestionNumber(){
        return (generateNumber(Global_Class.getQuestionDifuclty()-5)+1);
    }
    public int genRandomAnsNumber(int ans){
        if(ans==0 ||  ans==1){
            ans=ans+2;
        }
        int x=0;
        int n=0;
        n = (generateNumber(ans+10))+2;
        return n;
    }
    //setHard generate single number:
    private int generateNumber(int setHard){
        Random random=new Random();
        int number=random.nextInt(setHard);
        if(number!=0){
            return number;
        }
        else{
            return number+2;
        }
    }

}
