package service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.SystemClock;
import android.widget.Toast;

import io.reactivex.subjects.BehaviorSubject;

public class MessageServiceDemo extends Service {
    /** Command to the service to display a message */
   public static final int MSG_SAY_HELLO = 1;
    private long startTime = 0L;

    private Handler customHandler = new Handler();

    long timeInMilliseconds = 0L;
    long timeSwapBuff = 0L;
    long updatedTime = 0L;

    String timeValue="";
    /**
     * Handler of incoming messages from clients.
     */
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(getApplicationContext(), "hello ! " +timeValue, Toast.LENGTH_SHORT).show();

                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    final Messenger mMessenger = new Messenger(new IncomingHandler());

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(getApplicationContext(), "binding", Toast.LENGTH_SHORT).show();
        customHandler.postDelayed(updateTimerThread, 0);
        return mMessenger.getBinder();
    }

    private Runnable updateTimerThread = new Runnable() {

        public void run() {

            timeInMilliseconds = SystemClock.uptimeMillis() - startTime;

            updatedTime = timeSwapBuff + timeInMilliseconds;

            int secs = (int) (updatedTime / 1000);
            int mins = secs / 60;
            secs = secs % 60;
            int milliseconds = (int) (updatedTime % 1000);
            timeValue=mins + ":"
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




}