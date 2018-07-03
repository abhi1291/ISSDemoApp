package com.example.abc.myapplication.activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abc.myapplication.R;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.ReplaySubject;
import service.MyService;

public class InbinderServiceActivity extends AppCompatActivity implements View.OnClickListener {
     public MyService localService;
    private boolean isBound = false;
    TextView displayText;
    private String TAG = "demo";
    public static final  Integer AsynchConst=0,BehaviorConst=1,ReplayConst=2,PublishConst=3;
    Button Asynch,Behavior,Replay,Publish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messanger_service);
        displayText=findViewById(R.id.tv_binder_service_display_text);
        Behavior=findViewById(R.id.behvior);
        Replay=findViewById(R.id.replay);
        Publish=findViewById(R.id.publish_subject);
        Asynch=findViewById(R.id.async);

        Behavior.setOnClickListener(this);

        Replay.setOnClickListener(this);
        Publish.setOnClickListener(this);
        Asynch.setOnClickListener(this);
    }

    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            MyService.LocalBinder binder = (MyService.LocalBinder) service;
            localService = binder.getService();
            isBound = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName arg0) {
            isBound = false;
        }
    };

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, MyService.class);
        intent.putExtra("url","ABC");
        bindService(intent, connection, Context.BIND_AUTO_CREATE);
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (isBound) {
            unbindService(connection);
            isBound = false;
        }
    }
    public <T extends io.reactivex.subjects.Subject> void displayText(T constant ) {
        if (isBound) {

            String date = localService.getTime();
            localService.setSetObserver(getFirstObserver(),getSecondObserver(),constant);
            Toast.makeText(this, date, Toast.LENGTH_SHORT).show();
        }
    }

    private Observer<String> getFirstObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, " First onSubscribe : " + d.isDisposed());
            }

            @Override
            public void onNext(String value) {

                displayText.append(" First onNext : value : " + value);
                displayText.append("\n");
                Log.d(TAG, " First onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {

                Log.d(TAG, " First onError : " + e.getMessage());
            }

            @Override
            public void onComplete() {
            /*    textView.append(" First onComplete");
                textView.append(AppConstant.LINE_SEPARATOR);*/
               // Log.d(TAG, " First onComplete");
            }
        };
    }
    private Observer<String> getSecondObserver() {
        return new Observer<String>() {

            @Override
            public void onSubscribe(Disposable d) {
            }
            @Override
            public void onNext(String value) {
                displayText.append(" Second onNext : value : " + value);
                displayText.append("\n");
                Log.d(TAG, " Second onNext value : " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.async:
                displayText.setText("");
                displayText(AsyncSubject.create());

                break;
            case R.id.behvior:
                displayText.setText("");
            displayText(BehaviorSubject.create());
                break;
            case R.id.replay:
                displayText.setText("");
                displayText(ReplaySubject.create());
                break;

            case R.id.publish_subject:
                displayText.setText("");
                displayText(PublishSubject.create());
                break;


        }
    }
}