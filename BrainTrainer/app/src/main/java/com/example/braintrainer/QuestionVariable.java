package com.example.braintrainer;

import android.app.Application;
import android.renderscript.Sampler;
import android.widget.ListView;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class QuestionVariable {


    String Question;
    String resultSets[] =new String[4];
    String sendResultSets[]= new String[4];

    ArrayList<String> arrayList;



   public void  QuestionVariable(String setQ,Integer[] ansList) {
        arrayList=new ArrayList<String>();
        Question=setQ;
        for(int n=0;n<ansList.length;n++){
            resultSets[n]=Integer.toString(ansList[n]);
            arrayList.add(resultSets[n]);
        }
        suffleAns();
    }

    public void suffleAns(){
        Collections.shuffle(arrayList);
    }

    public String getAnswerSetItems(int index){
        return (arrayList.get(index));
    }



}
