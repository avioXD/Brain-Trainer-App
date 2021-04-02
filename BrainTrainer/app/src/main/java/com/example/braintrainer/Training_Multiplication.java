package com.example.braintrainer;

import android.util.Log;

public class Training_Multiplication {
    private String question="";
    private int[] ansIntArray={0,0,0,0};
    Random_Number_Level random_number;
    int level=1;

    public Training_Multiplication( int setLevel){
        random_number=new Random_Number_Level();
        level=setLevel;
        createMath();
    }


    public void createMath(){
        int value1=random_number.genRandomQuestionNumber();
        int value2=random_number.genRandomQuestionNumber();
        int ans=value1*value2;
        Log.i("Additon Work",""+ans);
        question=Integer.toString(value1)+" x "+Integer.toString(value2);
        Log.i("Additon string: ",""+question);
        ansIntArray=fakeAns(ans);
    }

    //Generate Fake 4 Ans: ans[3] = Real Ans:
    public int[] fakeAns(int ans) {
        int[] array = {0,0,0,0};
        for (int i = 0; i < array.length-1; i++) {
            int a=random_number.genRandomAnsNumber(ans);
            if(ans!=a){
                array[i]=a;
            }else{
                array[i]=a+2;
            }
        }
        for(int i = 0; i < array.length-1; i++){
            while(array[i]==array[i+1]){
                array[i]=random_number.genRandomAnsNumber(ans);
            }
        }
        array[3]=ans;
        //returning ans array:
        return array;
    }

    public String getQuestion(){
        return question;
    }
    public String[] getAnsArray_String(){
        String[] ansStrArray={"0","0","0","0"};
        for(int i=0;i<ansIntArray.length;i++){
            ansStrArray[i]=Integer.toString(ansIntArray[i]);
            Log.i("Array Ans String :",ansStrArray[i]);
        }
        return ansStrArray;
    }


}
