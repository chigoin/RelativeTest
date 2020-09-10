package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.util.StringJoiner;

public class CheckBoxActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    private CheckBox[] checkBoxes = new CheckBox[3];
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        btn = findViewById(R.id.bt);
        btn.setOnClickListener(this);
        checkBoxes = new CheckBox[]{findViewById(R.id.cb1), findViewById(R.id.cb2), findViewById(R.id.cb3)};
        for(CheckBox cb:checkBoxes){
            cb.setOnCheckedChangeListener(this);
        }
    }

    @Override
    public void onClick(View view) {
        StringJoiner choose = new StringJoiner(",", "你的选择是", "!");
        for (CheckBox cb : checkBoxes) {
            if (cb.isChecked() == true) {
                choose.add(cb.getText());
            }
        }
        Toast.makeText(getApplicationContext(), choose.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        if (compoundButton.isChecked() == true) {
            Toast.makeText(getApplicationContext(), compoundButton.getText(), Toast.LENGTH_LONG).show();
        }
    }
}
