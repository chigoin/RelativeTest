package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {

    private Button btnToast;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        btnToast = findViewById(R.id.btn_toast);
        toast = Toast.makeText(this, "使用Toast控件", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 0);

//        自定义吐丝控件
        LinearLayout layout =(LinearLayout) toast.getView();
        TextView tv = layout.findViewById(android.R.id.message);
        tv.setTextColor(Color.parseColor("#F86C37"));
        layout.setBackgroundColor(Color.BLUE);
        ImageView img = new ImageView(this);
        img.setBackgroundResource(R.mipmap.ic_launcher);
        layout.addView(img);

        btnToast.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                toast.show();
            }
        });
    }
}
