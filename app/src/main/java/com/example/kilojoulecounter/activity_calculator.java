package com.example.kilojoulecounter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class activity_calculator extends AppCompatActivity implements  View.OnClickListener{

    public String date, arrayVal;
    public int i;
    public Double breakfastVal, lunchVal, dinnerVal, gymVal, sportsVal, joggingVal, foodVal, TotalFood, totalExcercise, NettTotal, totalVal;
    public static displayValues values;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
       // getSupportActionBar().setTitle("KiloJoule Calculator");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button addBtn = (Button) findViewById(R.id.AddButton);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                EditText dates = findViewById(R.id.DatesEditText);
                EditText breakfasttext = findViewById(R.id.breakFastEditText);
                EditText lunchtext = findViewById(R.id.lunchEditText);
                EditText dinnertext = findViewById(R.id.dinnerEditText);
                EditText gymtext = findViewById(R.id.GymEditText);
                EditText sportstext = findViewById(R.id.sportsEditText);
                EditText joggingtext = findViewById(R.id.JoggingEditText);
                TextView TotalFoodText = findViewById(R.id.TotalFoodText);
                TextView ExcerciseFoodText = findViewById(R.id.ExcerciseFoodText);
                TextView NettFoodText = findViewById(R.id.NettFoodText);

                try {
                    breakfastVal = Double.parseDouble(breakfasttext.getText().toString());
                    dinnerVal = Double.parseDouble(dinnertext.getText().toString());
                    lunchVal = Double.parseDouble(lunchtext.getText().toString());
                    gymVal = Double.parseDouble(gymtext.getText().toString());
                    sportsVal = Double.parseDouble(sportstext.getText().toString());
                    joggingVal = Double.parseDouble(joggingtext.getText().toString());
                    TotalFood = breakfastVal + lunchVal + dinnerVal;
                    totalExcercise = gymVal + sportsVal + joggingVal;
                    NettTotal = TotalFood - totalExcercise;

                    String totalF = getString(R.string.totalFood);
                    String totalE = getString(R.string.totalExcercise);
                    String netNKI = getString(R.string.netNKI);
                    String addCLk = getString(R.string.addCli);
                    TotalFoodText.setText(totalF + " " + String.format("%.2f", TotalFood) + " ");
                    ExcerciseFoodText.setText(totalE + " " + String.format("%.2f", totalExcercise) + " ");
                    NettFoodText.setText(netNKI + " " + String.format("%.2f", NettTotal) + "");
                    Toast.makeText(activity_calculator.this, addCLk, Toast.LENGTH_SHORT).show();

                } catch (NumberFormatException e){

                    Toast.makeText(activity_calculator.this, "Enter Values", Toast.LENGTH_SHORT).show();
                    String [] texts = {"breakfastVal", "lunchVal", "dinnerVal", "gymVal", "sportsVal", "joggingVal"};

//                    breakfasttext.setText("");
//                    lunchtext.setText("");
//                    dinnertext.setText("");
//                    gymtext.setText("");
//                    sportstext.setText("");
//                    joggingtext.setText("");
//                    dates.setText("");
                    return;
                }



//                breakfasttext.setText(" ");
//                lunchtext.setText("");
//                dinnertext.setText("");
//                gymtext.setText("");
//                sportstext.setText("");
//                joggingtext.setText("");
//                dates.setText(" ");
            }
        });


        Button saveBtn = (Button) findViewById(R.id.SaveButton);
        saveBtn.setOnClickListener(this);

        exitButton();


    }




    private void  exitButton() {

        Button exitBtn = (Button) findViewById(R.id.ExitButton);
        exitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

    @Override
    public void onClick(View view) {

        EditText datetext = (EditText)findViewById(R.id.DatesEditText);
        String x = datetext.getText().toString();
        Intent data = new Intent(this,MainActivity.class);
        data.putExtra("date",x);
        data.putExtra("BreakFast",breakfastVal);
        data.putExtra("Lunch",lunchVal);
        data.putExtra("Dinner",dinnerVal);
        data.putExtra("Gym",gymVal);
        data.putExtra("Jogging",joggingVal);
        data.putExtra("Sports",sportsVal);
        data.putExtra("Total",TotalFood);
        data.putExtra("Exercise",totalExcercise);
        data.putExtra("NetTotal", NettTotal);
       // i.putExtra("ExcerciseTotal",excerciseVal);
        //i.putExtra("NettTotal",netVal);
        startActivity(data);

    }



    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onDestroy(){

        super.onDestroy();
    }


}
