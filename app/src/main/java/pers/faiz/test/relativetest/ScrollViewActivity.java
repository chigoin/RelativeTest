package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class ScrollViewActivity extends AppCompatActivity {

    private LinearLayout layout;
    private ScrollView sv;
    private Button[] btns;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        initial();

    }

    private void initial() {
        layout = findViewById(R.id.layout);
        btns = new Button[]{new Button(this), new Button(this)};
        sv = new ScrollView(this);
        sv.setVerticalScrollBarEnabled(false);
        tv = new TextView(this);
        btns[0].setText("回到顶部");
        btns[1].setText("回到底部");
        for (int i = 0; i < btns.length; i++) {
            layout.addView(btns[i]);
            switch (i) {
                case 0:
                    btns[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sv.fullScroll(ScrollView.FOCUS_UP);

                        }
                    });
                    break;
                case 1:
                    btns[i].setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            sv.fullScroll(ScrollView.FOCUS_DOWN);

                        }
                    });
                    break;
            }

        }
        sv.addView(tv);
        layout.addView(sv);
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 100; i++) {
            sb.append("文本内容" + i + "\n");
            tv.setText(sb.toString());

        }

    }
}