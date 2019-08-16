package com.example.kilojoulecounter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class displayActivity extends AppCompatActivity implements View.OnClickListener {


    TextView date;
    TextView breakFast;
    TextView Lunch;
    TextView Dinner;
    TextView Gym;
    TextView Sports;
    TextView Jogging;
    TextView ExcerciseTotal;
    TextView NettTotal;
    TextView total;
    int pos = 0;
    int position;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        //getSupportActionBar().setTitle("dairy display");
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        date = (TextView)findViewById(R.id.textView);
        breakFast = (TextView)findViewById(R.id.textView2);
        Lunch = (TextView)findViewById(R.id.textView3);
        Dinner = (TextView)findViewById(R.id.textView4);
        Gym = (TextView)findViewById(R.id.textView5);
        Sports = (TextView)findViewById(R.id.textView6);
        Jogging = (TextView)findViewById(R.id.textView7);
        total = (TextView)findViewById(R.id.textView8);
        ExcerciseTotal = (TextView)findViewById(R.id.textView9);
        NettTotal = (TextView)findViewById(R.id.textView10);

        Button next = (Button)findViewById(R.id.nextbtn);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                position = pos+1;
                if(!(position>= MainActivity.adapter.getCount()-1)){
                   // int d = getIntent().getExtras().getInt("position");
                    //Log.i("info", "here" + d);

                    pos+=1;


                }
                else{
                    pos = -1;
                }

               // return position;
                String nextClk = getString(R.string.NextClick);
                Toast.makeText(displayActivity.this ,nextClk + position, Toast.LENGTH_LONG  ).show();
            }

        });

        Button previous = (Button)findViewById(R.id.prevbtn);
        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(displayActivity.this, "Previous clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button exit = (Button)findViewById(R.id.returnBtn);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent overView = new Intent(getApplicationContext(),MainActivity.class);

                startActivity(overView);

                Toast.makeText(displayActivity.this, "Exit clicked", Toast.LENGTH_SHORT).show();

            }
        });

        Button calculator = (Button)findViewById(R.id.calculatorBtn);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calcIntent = new Intent(getApplicationContext(), activity_calculator.class);
                startActivity(calcIntent);


                //String openCalc = getString(R.string.openingCalc);


               // Toast.makeText(displayActivity.this, openCalc, Toast.LENGTH_SHORT).show();
            }
        });




        Bundle extras = getIntent().getExtras();
        if(extras!=null) {


            pos = extras.getInt("position");
            Log.i("info", "I got here"+ pos);
            String dates = extras.getString("dates");
            Double breakF = extras.getDouble("breakF");
            Double lunchie = extras.getDouble("lunchie");
            Double dinners = extras.getDouble("dinners");
            Double gyms = extras.getDouble("gyms");
            Double sportie = extras.getDouble("sportie");
            Double joggin = extras.getDouble("joggin");
            Double Total = extras.getDouble("Total");
            Double Exercise = extras.getDouble("Exercise");
            Double NetTotal = extras.getDouble("NetTotal");


            date.setText("date : "+dates);
            breakFast.setText("BreakFast: "+breakF+"");
            Lunch.setText("Lunch: "+lunchie+"");
            Dinner.setText("Dinner: "+dinners+"");
            Gym.setText("Gym: "+gyms+"");
            Sports.setText("Sports: "+sportie+"");
            Jogging.setText("Jogging: "+joggin+"");
            total.setText("Total consumption: "+Total+"");
            ExcerciseTotal.setText("Exercise total: "+Exercise+"");
            NettTotal.setText("NetTotal :"+NetTotal+" ");
        }





    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }


    @Override
    public void onClick(View view) {

    }
}
