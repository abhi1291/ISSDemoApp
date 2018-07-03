package com.example.abc.myapplication.activity;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.abc.myapplication.R;
import com.example.abc.myapplication.fragment.FirstFragment;

public class FragmentLuncherActivity extends AppCompatActivity {
    private static final String TAG = "Demo";
    Integer count =0;
    private String STATE_Value ="State";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_luncher);
        Log.d(TAG, "onCreate: A");
        Log.d(TAG, "savedInstanceState: "+savedInstanceState);
        if(savedInstanceState==null) {
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.fm_frag_container, firstFragment);
            fragmentTransaction.commit();
        }
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
      //  Log.d(TAG, "onResume: "+count);
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
        Log.d(TAG, "onRestart: A");
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
