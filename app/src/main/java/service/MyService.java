package service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Source;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;

public class MyService extends Service {
    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    String timeValue = "";

    private final IBinder binder = new LocalBinder();

    public class LocalBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        startTime = SystemClock.uptimeMillis();
        customHandler.postDelayed(updateTimerThread, 0);
        return binder;
    }

    public String getTime() {

        return timeValue;
    }

    public <T extends Subject> void setSetObserver(final Observer<String> observer, final Observer<String> observer2,
                                                   final T source) {

        source.subscribe(observer);
        source.interval(0, 2, TimeUnit.SECONDS);
        source.onNext(timeValue);
        source.onNext(timeValue);

        source.onNext(timeValue);
        // it will get 1, 2, 3, 4 and onComplete

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 100ms
                source.subscribe(observer2);
                source.onNext(timeValue);
                source.onComplete();
            }
        }, 3000);
        /*
         * it will emit 3(last emitted), 4 and onComplete for second observer also.
         */


    }

    final Handler handler = new Handler();

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timeValue = mins + ":"
                    + String.format("%02d", secs) + ":"
                    + String.format("%03d", milliseconds);
            customHandler.postDelayed(this, 0);
        }

    };

    @Override
    public void onDestroy() {
        customHandler.removeCallbacks(updateTimerThread);
        // The service is no longer used and is being destroyed
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }


}