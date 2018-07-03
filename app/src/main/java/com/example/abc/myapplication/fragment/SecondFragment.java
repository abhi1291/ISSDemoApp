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
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.abc.myapplication.R;

public class SecondFragment extends Fragment implements View.OnClickListener {
    private String TAG = "Demo";
    Button remove, hide;
    private String TAG_FRAGMENT="Second";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.d(TAG, "onAttach: frag B");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,
                container, false);
        remove = view.findViewById(R.id.bt_first_frag_remove);
        hide = view.findViewById(R.id.bt_first_frag_hide);
        remove.setOnClickListener(this);
        hide.setOnClickListener(this);
        Log.d(TAG, "onCreateView frag: B");

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach frag : B");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate frag : B");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart frag: B");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume frag: B");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause frag: B");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: B");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy frag: B");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated frag: B");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView frag: B");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach frag: B");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState frag: B");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "onConfigurationChanged frag: A");
    }

    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment secondFragment;
        switch (v.getId()) {

            case R.id.bt_first_frag_remove:


                secondFragment=fragmentManager.findFragmentByTag(TAG_FRAGMENT);;
                fragmentTransaction.remove(secondFragment).commit();
                //.setCustomAnimations(android.R.anim.fade_in,


                break;
            case R.id.bt_first_frag_hide:


               secondFragment=fragmentManager.findFragmentByTag(TAG_FRAGMENT);;

                        //.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                fragmentTransaction.hide(secondFragment).commit();
                break;
        }
    }
}
