package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

public class ToggleAndSwitchActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private ToggleButton tb;
    private Switch sw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_and_switch);
        sw = findViewById(R.id.sw);
        tb = findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(this);
        sw.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.tb:
                if (compoundButton.isChecked()) {
                    sw.setChecked(false);
                } else {
                    sw.setChecked(true);
                }
                Toast.makeText(this, "操作进行中", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sw:
                if (compoundButton.isChecked()) {
                    tb.setChecked(false);
                } else {
                    tb.setChecked(true);
                }
                Toast.makeText(this, "操作进行中", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
