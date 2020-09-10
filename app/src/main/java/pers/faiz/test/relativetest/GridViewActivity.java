package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import pers.faiz.test.Adepter.GridViewAdapter;
import pers.faiz.test.model.Icon;

public class GridViewActivity extends AppCompatActivity {

    private GridView grid_photo;
    private GridViewAdapter mAdapter = null;
    private List<Icon> mData = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);

        //视图层V
        grid_photo = (GridView) findViewById(R.id.gridView);
        //数据源M
        mData = new ArrayList();
        mData.add(new Icon(R.mipmap.iv_icon_1, "图标1"));
        mData.add(new Icon(R.mipmap.iv_icon_2, "图标2"));
        mData.add(new Icon(R.mipmap.iv_icon_3, "图标3"));
        mData.add(new Icon(R.mipmap.iv_icon_4, "图标4"));
        mData.add(new Icon(R.mipmap.iv_icon_5, "图标5"));
        mData.add(new Icon(R.mipmap.iv_icon_6, "图标6"));
        mData.add(new Icon(R.mipmap.iv_icon_7, "图标7"));
        //控制层C
        mAdapter = new GridViewAdapter(mData, GridViewActivity.this);

        grid_photo.setAdapter(mAdapter);
        //点击事件
        grid_photo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GridViewActivity.this, "你点击了~" + position + "~项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
