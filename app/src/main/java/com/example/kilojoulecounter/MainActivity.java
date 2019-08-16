package com.example.kilojoulecounter;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;


public class MainActivity extends AppCompatActivity {
    public ListView diaryList;
    TextView dataView;
    TextView totalView;
    double sum = 0;
    double average = 0;
    public static displayValues data;
    public static List<Double> totalEntries = new ArrayList<Double>();
    public static List<Double> totalEntries1 = new ArrayList<Double>();
    ArrayList<displayValues> list = new ArrayList<>();
    public static ArrayList<displayValues>much = new ArrayList<>();
    public static dataAdapter adapter;
  //  private Object MainActivity;


    // ListView  averageNKI;
    //String names[] = {"Tawanda", "Locadia", "Ryan", "Shamiso"};
    //final ArrayList<String>  names = new ArrayList<String>(asList("shamiso", "tawanda", "locadia", "ryan"));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        totalView = findViewById(R.id.totalView);
        dataView = findViewById((R.id.dataView));
       // dataView.setText("Average Daily NKI is: "+String.format("%.2f",average));
      //  totalView.setText("Average NKI over all days: "+String.format("%.2f",sum));
        String kiloCou = getString(R.string.kiloCou);
        getSupportActionBar().setTitle(kiloCou);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        populate();


        // diaryList = (ListView)findViewById(R.id.entriesList);
       // ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, names );
       // diaryList.setAdapter(listAdapter);

        //diaryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          //  @Override
           // public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
             //   Toast.makeText(getApplicationContext(), "Hello " + names.get(position), Toast.LENGTH_LONG).show();
            //}
        //});

        Button openCalculator = findViewById(R.id.openCalculator);
        openCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent startIntent = new Intent(getApplicationContext(), activity_calculator.class);
                startActivity(startIntent);
                String openCalc = getString(R.string.openingCalc);
                Toast.makeText(MainActivity.this, openCalc , Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void populate(){

        new Thread(new Runnable() {
            @Override
            public void run() {

                Bundle extras = getIntent().getExtras();
                if (extras != null){
                    String date =extras.getString("date");
                    Double breakFast = extras.getDouble("BreakFast");
                    Double lunch = extras.getDouble("Lunch");
                    Double dinner = extras.getDouble("Dinner");
                    Double gym = extras.getDouble("Gym");
                    Double sports = extras.getDouble("Sports");
                    Double jogging = extras.getDouble("Jogging");
                    //Double foodTotal = extras.getDouble("FoodTotal");
                    //Double excerciseTotal = extras.getDouble("ExcerciseTotal");
                    //Double nettTotal = extras.getDouble("NettTotal");
                    // Double dailyAverage = extras.getDouble("DailyAverage");
                    //Double AllDaysAverage = extras.getDouble("AllDaysAverage");
                    Double total = extras.getDouble("Total");
                    Double TotalExcercise = extras.getDouble("Exercise");
                    Double NettTotal = extras.getDouble("NetTotal");
                    //  Double totalExcecise = extras.get("ExcerciseTotal");

                    totalEntries.add(NettTotal);
                    totalEntries1 = displayValues.gettotal();


                    sumEntries();

                    data = new displayValues(date, breakFast, lunch, dinner,gym,sports,jogging,total,TotalExcercise,NettTotal );

                    list.add(data);
                    much.addAll(list);
                }

            }
        }).start();

        diaryList = findViewById(R.id.all_list);
        adapter = new dataAdapter(getApplicationContext(),list);
        diaryList.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        diaryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                displayValues fill_values = (displayValues) adapterView.getAdapter().getItem(i);
                Intent myIntent = new Intent(MainActivity.this, displayActivity.class);
                myIntent.putExtra("position",i);
                myIntent.putExtra("dates", fill_values.getDate());
                myIntent.putExtra("breakF", fill_values.getBreakFast());
                myIntent.putExtra("lunchie", fill_values.getLunch());
                myIntent.putExtra("dinners", fill_values.getDinner());
                myIntent.putExtra("gyms", fill_values.getGym());
                myIntent.putExtra("sportie", fill_values.getSports());
                myIntent.putExtra("joggin", fill_values.getJogging());
                myIntent.putExtra("Total", fill_values.getTotal());
                myIntent.putExtra("Exercise", fill_values.getTotalExcericse());
                myIntent.putExtra("NetTotal",fill_values.getNettTotal());
                startActivity(myIntent);


            }
        });




    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapItems(much);

    }

    private void sumEntries() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                for(Double d : totalEntries1) {
                    sum += d;
                }
                average = sum / totalEntries1.size();
                String averageNKI = getString(R.string.averageNKI);
                String totalNKI = getString(R.string.totalNKI);
                dataView.setText(averageNKI + " " + average);
                totalView.setText(totalNKI + " " + sum);
                totalEntries1.clear();

            }
        }).start();

    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void finish() {

        super.finish();
    }


//    @Override
//    public void onBackPressed() {
//       // Bundle bundle = new Bundle();;
//       // onSaveInstanceState(bundle);
//        super.onBackPressed();
//    }
//    @Override
//    protected  void onStop(){
//
//      super.onStop();
//    }
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//    }
//
//
//    @Override
//    protected void onStart()
//    {
//        super.onStart();
//        Toast.makeText(getApplicationContext(),"Now onStart() calls", Toast.LENGTH_LONG).show(); //onStart Called
//    }
//
//    @Override
//    public void onDestroy(){
//
//        super.onDestroy();
//        Runtime.getRuntime().gc();
//        finish();
//    }


}
