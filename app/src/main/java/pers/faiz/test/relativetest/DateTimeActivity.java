package pers.faiz.test.relativetest;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class DateTimeActivity extends AppCompatActivity {

    private DatePicker dp;
    private CalendarView cv;
    private TimePicker tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        initial();

    }

    private void initial() {
        dp = findViewById(R.id.dp);
        cv = findViewById(R.id.cv);
        tp = findViewById(R.id.tp);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int monthOfYear = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        dp.init(year, monthOfYear, dayOfMonth, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int i, int i1, int i2) {
                Toast.makeText(DateTimeActivity.this, "您选择的日期是：" + i + "年" + (i1 + 1) + "月" + i2 + "日!", Toast.LENGTH_SHORT).show();
            }
        });

        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker timePicker, int i, int i1) {
                Toast.makeText(DateTimeActivity.this, "您选择的时间是：" + i + "时" + i1 + "分!", Toast.LENGTH_SHORT).show();
            }
        });

        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                Toast.makeText(DateTimeActivity.this, "您选择的时间是：" + i + "年" + i1 + "月" + i2 + "日", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
