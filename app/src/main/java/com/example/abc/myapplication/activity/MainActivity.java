package com.example.abc.myapplication.activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.abc.myapplication.R;

import java.util.ArrayList;

import service.MyService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "Demo";
    Context context;
    Spinner district;
    EditText name;
    TextView formName;
    Integer count =0;
    private String STATE_Value="value";
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: A");
        setContentView(R.layout.activity_main);
        context=this;


        district=findViewById(R.id.sp_main_district);
        name=findViewById(R.id.et_main_name);
        formName=findViewById(R.id.tv_main_form_name);
        formName.setText("Profile");
        Button next=findViewById(R.id.bt_main_next);
        intent=new Intent(context, MyService.class);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startService(intent);

            }
        });

        Button stop=findViewById(R.id.bt_main_stop);
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopService(intent);
            }
        });
        ArrayList<String> districtList=new ArrayList<>();
        districtList.add("Maharashtra");
        districtList.add("Goa");

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(context,android.R.layout.simple_spinner_item,districtList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        district.setAdapter(arrayAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: A");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: A");
        Log.d(TAG, "onResume: "+count);
        count=10;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: A");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG,     "onRestart: A");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged A: "+count);

        Log.d(TAG, "onConfigurationChanged: A");
    }



    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.d(TAG, "onSaveInstanceState: A");
        outState.putInt(STATE_Value, count);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        Log.d(TAG, "onRestoreInstanceState: " +savedInstanceState.getInt(STATE_Value));
        count =savedInstanceState.getInt(STATE_Value);

        super.onRestoreInstanceState(savedInstanceState);
    }
}
