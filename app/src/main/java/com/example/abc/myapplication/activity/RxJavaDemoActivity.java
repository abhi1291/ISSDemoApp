package com.example.abc.myapplication.activity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.abc.myapplication.R;

import java.util.Arrays;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import io.reactivex.subjects.ReplaySubject;

public class RxJavaDemoActivity extends AppCompatActivity {

    /**
     * Basic Observable, Observer, Subscriber example
     * Observable emits list of animal names
     */

    private static final String TAG = "demo";
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rx_java_demo);

        Integer[] numbers = {1, 2, 3, 4,18, 6, 7, 19, 9, 10,
                11, 12, 13, 14, 15, 16, 17,  5 ,8, 20};
        result=findViewById(R.id.rx_demo_string);
        Observable.just(numbers)
               .subscribeOn(Schedulers.io())

                .map(new Function<Integer[], Integer[]>() {
                    @Override
                    public Integer[] apply(Integer[] integers) throws Exception {
                        Arrays.sort(integers);
                        return integers;
                    }
                })

                .observeOn(Schedulers.io())
                .subscribe(new Observer<Integer[]>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Integer[] integers) {
                        Log.d(TAG, "Modified array: " + Arrays.toString(integers)+Thread.currentThread().getName());
                        ProgressDialog progress=new ProgressDialog(RxJavaDemoActivity.this);
                        progress.setMessage("Downloading Music");
                        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                        progress.setIndeterminate(true);
                        progress.setProgress(0);
                        progress.show();
                        //startActivity(new Intent(RxJavaDemoActivity.this,SecondActivity.class));

                        // you might have to loop through the array
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                })

        ;

    }

}