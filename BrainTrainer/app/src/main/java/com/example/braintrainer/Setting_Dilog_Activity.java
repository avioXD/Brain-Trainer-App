package com.example.braintrainer;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Setting_Dilog_Activity extends AppCompatActivity {
    Dialog newDialog;
    Button close;
    Button choseDiffuculty[]=new Button[3];


    public Setting_Dilog_Activity(Context context) {
        newDialog=new Dialog(context);
        newDialog.setContentView(R.layout.activity_settings_overlay);
        newDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.dialog_background));
        newDialog.getWindow().setLayout(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        newDialog.setCancelable(false);
        close=(Button)newDialog.findViewById(R.id.closeButton);
        newDialog.show();

    }

    public Button getClose(){
        return close;
    }


    public void selectOption(View view){
        Button clicked=(Button) view;
        int opTag=Integer.parseInt(clicked.getTag().toString());
    }


}
