package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pers.faiz.test.Adepter.SpinnerAdapter;
import pers.faiz.test.model.Hero;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Spinner spinner1, spinner2;
    private List<Hero> mData;
    private SpinnerAdapter adapter;

    //判断是否为刚进去时触发onItemSelected的标志
    private boolean one_selected = false;
    private boolean two_selected = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        bindView();

    }

    private void bindView() {
        spinner1 = findViewById(R.id.spin1);
        spinner2 = findViewById(R.id.spin2);
        mData = new ArrayList<>();


        mData.add(new Hero(R.mipmap.iv_lol_icon1, "迅捷斥候：提莫（Teemo）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon2, "诺克萨斯之手：德莱厄斯（Darius）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon3, "无极剑圣：易（Yi）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon4, "德莱厄斯：德莱文（Draven）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon5, "德邦总管：赵信（XinZhao）"));
        mData.add(new Hero(R.mipmap.iv_lol_icon6, "狂战士：奥拉夫（Olaf）"));
        adapter = new SpinnerAdapter(mData, SpinnerActivity.this);
        spinner2.setAdapter(adapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        switch (adapterView.getId()) {
            case R.id.spin1:
                if (one_selected) {
                    Toast.makeText(SpinnerActivity.this, "您的分段是~：" + adapterView.getItemAtPosition(i).toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    one_selected = true;
                }
                break;
            case R.id.spin2:
                if (two_selected) {
                    TextView txt_name = view.findViewById(R.id.hero_name);
                    Toast.makeText(SpinnerActivity.this, "您选择的英雄是~：" + txt_name.getText().toString(),
                            Toast.LENGTH_SHORT).show();
                } else {
                    two_selected = true;
                }
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
