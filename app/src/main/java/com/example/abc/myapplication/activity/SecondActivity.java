package com.example.abc.myapplication.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.abc.myapplication.Utils.LocaleManager;
import com.example.abc.myapplication.R;

public class SecondActivity  extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Demo";
    Context context;
    private String STATE_Value ="State";
    private Button french,english;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        context=this;
        french=findViewById(R.id.bt_second_french);
        english=findViewById(R.id.bt_second_eng);

        french.setOnClickListener(this);
        english.setOnClickListener(this);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: B");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume: B");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause: A");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: B");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy: A");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart: B");
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(LocaleManager.setLocale(base));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case  R.id.bt_second_eng:

                LocaleManager.setNewLocale(getApplicationContext(),"en");
                recreate();
                break;
            case  R.id.bt_second_french:
                LocaleManager.setNewLocale(getApplicationContext(),"fr");
                recreate();
                break;
        }
    }
}
