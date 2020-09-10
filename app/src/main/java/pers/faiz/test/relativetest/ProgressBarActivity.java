package pers.faiz.test.relativetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ProgressBarActivity extends AppCompatActivity {

    private ProgressBar pb;
    private int currentProcess = 0;
    private int maxProgress;
    private Handler mHandler;
    private TextView tv;

    // 第一种方法
//    private Handler mHandler = new Handler(Looper.myLooper()) {
//        @Override
//        public void handleMessage(@NonNull Message msg) {
//            super.handleMessage(msg);
//            switch (msg.what) {
//                case 0:
//                    pb.setProgress(currentProcess);
//                    break;
//            }
//        }
//    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_bar);
        pb = findViewById(R.id.pb);
        maxProgress = pb.getMax();
        tv = findViewById(R.id.tv_test);
        Thread testThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //Looper.prepare();
                //Toast.makeText(ProgressBarActivity.this,"测试toast",Toast.LENGTH_SHORT).show();
                tv.setText("faiz");
                for (; currentProcess <= maxProgress; currentProcess += 10) {
                    try {
                        Thread.sleep(1000);
                        pb.setProgress(currentProcess);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                //Looper.loop();
            }
        });
        testThread.start();
    }

    //第一种方法
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//        new Thread(){
//            @Override
//            public void run() {
//                while (true){
//                    try{
//                        for (int i = 0;i  <= 100; i++){
//                            Thread.sleep(1000);
//                            currentProcess += 10;
//                            if(currentProcess > maxProgress){
//                                break;
//                            }
//                            mHandler.sendEmptyMessage(0);
//                        }
//                    }catch (InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }.start();
//    }
//第二种错误的方法
//    class LooperThread extends Thread {
//        @Override
//        public void run() {
//            Looper.prepare();
//            currentProcess += 10;
//            mHandler.sendEmptyMessage(0);
//            if (currentProcess >= maxProgress) {
//                Looper.myLooper().quitSafely();
//            }
//            Looper.loop();
//        }
//    }

//第三种方法


    @Override
    protected void onStart() {
        super.onStart();
//
//        Thread testThread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Looper.prepare();
//                mHandler = new Handler(Looper.myLooper()){
//                    @Override
//                    public void handleMessage(Message msg) {
//                        super.handleMessage(msg);
//                        switch(msg.what){
//                            case 0:
//                                Log.e("faiz", "handleMessage: hello");
//                                break;
//                        }
//                    }
//                };
//                Looper.loop();
//            }
//        });

//        for (;currentProcess<=maxProgress;currentProcess+=10){
//            mHandler.sendEmptyMessage(0);
//        }
    }

}
