package com.example.kilojoulecounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class dataAdapter extends ArrayAdapter<displayValues> {
    // Double datas = 1000.0;
    private Context mcontext;
    private ArrayList<displayValues> consumptionList;

    public dataAdapter(Context context, ArrayList<displayValues> list) {
        super(context, 0, list);
        mcontext = context;
        consumptionList = list;
    }

    public int getCount() {


        return consumptionList.size();
    }

    public displayValues getItem(int position) {

        return (displayValues) consumptionList.get(position);
    }

    public long getItemId(int position) {

        return position;
    }

    public void swapItems(ArrayList<displayValues> item) {
        consumptionList = item;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_items, parent, false);


        }

        displayValues values = (displayValues) getItem(position);
        TextView date = (TextView) convertView.findViewById(R.id.dailyNKI);
        TextView dateEntered = (TextView) convertView.findViewById(R.id.dateEntered);
        /* String dateB = get */
        String daily = mcontext.getResources().getString(R.string.totalConsump);
        String dates = mcontext.getResources().getString(R.string.date);

        date.setText( dates +":" + values.getDate());
        dateEntered.setText(daily + ":" + values.getNettTotal() + "");
        return convertView;


    }


}
