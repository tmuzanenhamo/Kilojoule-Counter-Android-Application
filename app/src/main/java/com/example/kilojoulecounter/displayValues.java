package com.example.kilojoulecounter;


import java.io.Serializable;
import java.util.ArrayList;

public class displayValues implements Serializable {

    private String date;
    private Double BreakFast;
    private Double Lunch;
    private Double Dinner;
    private Double Gym;
    private Double Sports;
    private Double Jogging;
    private Double FoodTotal;
    private Double totalExercise;
    private Double NettTotal;
    private Double DailyAverage;
    public  Double AllDaysAverage;
    public Double TotalFood;
    public static ArrayList<Double> latest=new ArrayList<>();
    public static ArrayList<Double>latests=new ArrayList<>();




    public displayValues() {
    }

    public displayValues(String date, Double breakFast, Double Lunch, Double Dinner, Double Gym, Double Sports, Double Jogging,  Double TotalFood, Double totalExercise, Double NettTotal) {
        this.date = date;
        BreakFast = breakFast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;
        this.Gym = Gym;
        this.Sports = Sports;
        this.Jogging = Jogging;

       // this.Total = Total;

      //  this.ExerciseTotal = ExcerciseTotal;

       // this.DailyAverage = DailyAverage;
        //this.AllDaysAverage = AllDaysAverage;
        this.TotalFood = TotalFood;
        this.totalExercise = totalExercise;
        this.NettTotal = NettTotal;

    }

    @Override

    public String toString() {
        return "BreakFast = " +BreakFast+" Lunch = "+Lunch+" Dinner = "+Dinner+" Gym = "+Gym+" Sports = "+Sports+"Jogging ="+Jogging+ "Total ="+ TotalFood +"Exercise = "+ totalExercise + "NetTotal = " + NettTotal;//" FoodTotal ="+FoodTotal+" ExcerciseTotal= "+ExerciseTotal+ "DailyAverage =" + DailyAverage+"All Days Average ="+AllDaysAverage;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {

        this.date = date;
    }

    public Double getBreakFast() {

        return BreakFast;
    }

    public void setBreakFast(Double breakFast) {
        BreakFast = breakFast;
    }

    public Double getLunch() {

        return Lunch;
    }

    public void setLunch(Double Lunch) {

        this.Lunch = Lunch;
    }

    public Double getDinner() {

        return Dinner;
    }

    public void setDinner(Double Dinner) {


        this.Dinner = Dinner;
    }

    public Double getGym() {
        return Gym;
    }

    public void setGym(Double Gym) {

        this.Gym = Gym;
    }

    public Double getSports() {

        return Sports;
    }

    public void setSports(Double Sports) {

        this.Sports = Sports;
    }

    public Double getJogging() {

        return Jogging;
    }

    public void setJogging(Double Jogging) {

        this.Jogging = Jogging;
    }

    public Double getTotal()

    {
        return TotalFood;
    }

    public void setTotal(Double TotalFood)
    {
        this.TotalFood = TotalFood;
    }

    public Double getTotalExcericse()
    {
        return totalExercise;
    }

    public void setTotalExcericse(Double totalExercise) {

        this.totalExercise = totalExercise;
    }

    public Double getNettTotal()
    {
        return NettTotal;
    }

    public void setNettTotal(Double NettTotal)
    {
        this.NettTotal = NettTotal;
    }

//    public Double getDailyAverage() {
//        return DailyAverage;
//    }
//
//    public void setDailyAverage(Double DailyAverage)
//    {
//        this.DailyAverage = DailyAverage;
//    }
//
//    public Double getAllDaysAverage() {
//
//        return AllDaysAverage;
//    }
//
//    public void setAllDaysAverage(Double AllDaysAverage) {
//        this.AllDaysAverage = AllDaysAverage;
//    }

    public static ArrayList<Double> gettotal(){
        if(MainActivity.totalEntries!=null){
            for(int i = 0; i<MainActivity.totalEntries.size();i++)
                latest.add(MainActivity.totalEntries.get(i));
        }
        return latest;
    }
}
