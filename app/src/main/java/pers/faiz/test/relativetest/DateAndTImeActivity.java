package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.Toast;

public class DateAndTImeActivity extends AppCompatActivity implements View.OnClickListener,Chronometer.OnChronometerTickListener{

    private Chronometer chronometer;
    private Button btnStart, btnStop, btnReset, btnFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_and_time);

        initView();


    }

    private void initView() {
        chronometer =  findViewById(R.id.chronometer);
        btnStart =  findViewById(R.id.btn_start);
        btnStop =  findViewById(R.id.btn_stop);
        btnReset =  findViewById(R.id.btn_reset);
        btnFormat =  findViewById(R.id.btn_format);
        chronometer.setOnChronometerTickListener(this);
        btnStart.setOnClickListener(this);
        btnStop.setOnClickListener(this);
        btnReset.setOnClickListener(this);
        btnFormat.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_start:
                chronometer.start();// 开始计时
                break;
            case R.id.btn_stop:
                chronometer.stop();// 停止计时
                break;
            case R.id.btn_reset:
                chronometer.setBase(SystemClock.elapsedRealtime());//复位
                break;
            case R.id.btn_format:
                chronometer.setFormat("Time：%s");// 更改时间显示格式
                break;
        }

    }

    @Override
    public void onChronometerTick(Chronometer chronometer) {
        String time = chronometer.getText().toString();
        if(time.equals("00:00")){
            Toast.makeText(this,"时间到了",Toast.LENGTH_SHORT).show();
        }
    }
}
