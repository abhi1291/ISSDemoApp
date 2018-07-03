package com.example.abc.myapplication.fragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.abc.myapplication.R;

public class FirstFragment extends Fragment {
    private String TAG = "Demo";
    Button second,secondTime;
    private String TAG_FRAGMENT="Second";
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach:cr frag A");
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        Log.d(TAG, "onCreateView frag : A");
        View view = inflater.inflate(R.layout.first_fragment,
                container, false);
        second=view.findViewById(R.id.bt_first_frag_second);
        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              FragmentManager fragmentManager = getFragmentManager();
               FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                SecondFragment secondFragment=new SecondFragment();
                fragmentTransaction.replace(R.id.fm_frag_container, secondFragment,TAG_FRAGMENT).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        secondTime=view.findViewById(R.id.bt_first_frag_second_time);
        secondTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment secondFragment=fragmentManager.findFragmentByTag(TAG_FRAGMENT);
                //.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                fragmentTransaction.attach( secondFragment).commit();

            }
        });


        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach frag: A");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate frag: A");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart frag: A");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume frag: A");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause frag: A");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop frag: A");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy frag: A");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated frag: A");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView frag: A ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach frag: A");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState frag: A");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged frag: A");
    }
}
