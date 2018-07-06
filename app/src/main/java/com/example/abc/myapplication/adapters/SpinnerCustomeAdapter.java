package com.example.abc.myapplication.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abc.myapplication.R;

import java.util.ArrayList;
import java.util.List;

import model.Book;
import model.Library;

public class SpinnerCustomeAdapter extends ArrayAdapter<String> {

    private Activity activity;
    private List<Library> data;
    Library tempValues=null;
    LayoutInflater inflater;


    public SpinnerCustomeAdapter(
            Activity activitySpinner,
            int textViewResourceId,
            List objects

    )
    {
        super(activitySpinner, textViewResourceId, objects);


        activity = activitySpinner;
        data     = objects;



        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getCustomView(position, convertView, parent);
    }


    public View getCustomView(int position, View convertView, ViewGroup parent) {


        View row = inflater.inflate(R.layout.spinner_rows, parent, false);

        tempValues = null;
        tempValues = (Library) data.get(position);

        TextView label        = (TextView)row.findViewById(R.id.company);
        TextView sub          = (TextView)row.findViewById(R.id.sub);
        ImageView companyLogo = (ImageView)row.findViewById(R.id.image);


            // Set values for spinner each row 
            label.setText(tempValues.getName());
            sub.setText(tempValues.getAddress());


        return row;
    }
}