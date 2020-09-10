package pers.faiz.test.relativetest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import pers.faiz.test.Adepter.NewsAdapter;
import pers.faiz.test.Adepter.NewsAdapter2;
import pers.faiz.test.model.News;

public class AdapterActivity extends AppCompatActivity {
    private ListView listView;
    private NewsAdapter2 adapter = null;
    private ArrayList<News> mData = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter);

//        ListView lv = findViewById(R.id.lv);
//        String[] strs = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k"};
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, strs);
//        lv.setAdapter(adapter);
        listView = findViewById(R.id.lv);
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add(new News("我是一个新闻" + i, "我是一个新闻" + i, R.mipmap.news));
        }
        adapter = new NewsAdapter2(mData, AdapterActivity.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(AdapterActivity.this, "你点击了" + i + "项", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
