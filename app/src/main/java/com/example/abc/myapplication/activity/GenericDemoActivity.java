package com.example.abc.myapplication.activity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.abc.myapplication.R;

public class GenericDemoActivity extends AppCompatActivity implements View.OnClickListener {
    Button number,text;
    TextView displaytext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generic_demo);
        number=findViewById(R.id.bt_geniric_demo_number);
        text=findViewById(R.id.bt_geniric_demo_text);
        displaytext=findViewById(R.id.display_text);
        number.setOnClickListener(this);
        text.setOnClickListener(this);
    }

     <T> void genericDisplay (T element)
    {
        displaytext.setText(element.getClass().getName() +
                " = " + element);
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment secondFragment;
        switch (v.getId()) {

            case R.id.bt_geniric_demo_text:
                genericDisplay(11);
                break;
            case R.id.bt_geniric_demo_number:

                genericDisplay("Generic Demo");

                break;
        }
    }

}
