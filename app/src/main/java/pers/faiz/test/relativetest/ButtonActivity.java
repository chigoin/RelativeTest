package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ButtonActivity extends AppCompatActivity {
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        bt = findViewById(R.id.bt);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (bt.isEnabled() == false) {
                    bt.setEnabled(true);
                    bt.setText("按钮可用");
                } else {
                    bt.setEnabled(false);
                    bt.setText("按钮不可用");
                }
            }
        });
    }
}
