package com.example.braintrainer;

import android.util.Log;

public class Training_Division {
    private String question="";
    private int[] ansIntArray={0,0,0,0};
    Random_Number_Level random_number;
    int level=1;

    public Training_Division( int setLevel){
        random_number=new Random_Number_Level();
        level=setLevel;
        createMath();
    }


    public void createMath(){
        int value1=random_number.genRandomQuestionNumber();
        int value2=random_number.genRandomQuestionNumber();
        int ans=0;
        if(value1==0){
            value1=1;
        }if(value2==0){
            value2=1;
        }
        int temp=value1*value2;
        ans= temp/value1;
        Log.i("Additon Work",""+ans);
        question=Integer.toString(temp)+" / "+Integer.toString(value1);
        Log.i("Substraction string: ",""+question);
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
