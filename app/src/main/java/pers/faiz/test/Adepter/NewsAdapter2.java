package pers.faiz.test.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;

import pers.faiz.test.model.News;
import pers.faiz.test.relativetest.R;

public class NewsAdapter2 extends BaseAdapter {

    private ArrayList<News> mData;
    private Context mContext;

    //    定义两种风格
    private static final int TYPE_NEWS_1 = 0;
    private static final int TYPE_NEWS_2 = 1;

    public NewsAdapter2(ArrayList<News> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return TYPE_NEWS_1;
        } else {
            return TYPE_NEWS_2;
        }
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
//        获取item的样式
        int type = getItemViewType(i);
        ViewHolder holder = null;
        ViewHolder2 holder2 = null;
        if (view == null) {
            switch (type){
                case TYPE_NEWS_1:
                    holder = new ViewHolder();
                    view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, viewGroup, false);
                    holder.img = view.findViewById(R.id.img);
                    holder.title = view.findViewById(R.id.tv_title);
                    holder.content = view.findViewById(R.id.tv_content);
                    view.setTag(holder);
                    break;
                case TYPE_NEWS_2:
                    holder2 = new ViewHolder2();
                    view = LayoutInflater.from(mContext).inflate(R.layout.listview_item2, viewGroup, false);
                    holder2.img = view.findViewById(R.id.img);
                    holder2.title = view.findViewById(R.id.tv_title);
                    holder2.content = view.findViewById(R.id.tv_content);
                    view.setTag(holder2);
                    break;
            }

        } else {
            switch (type){
                case TYPE_NEWS_1:
                    holder = (ViewHolder) view.getTag();
                    break;
                case TYPE_NEWS_2:
                    holder2 = (ViewHolder2) view.getTag();
                    break;
            }
        }

        switch (type){
            case TYPE_NEWS_1:
                holder.img.setBackgroundResource(R.mipmap.news);
                holder.title.setText(mData.get(i).getTitle());
                holder.content.setText(mData.get(i).getContent());
                break;
            case TYPE_NEWS_2:
                holder2.img.setBackgroundResource(R.mipmap.news);
                holder2.title.setText(mData.get(i).getTitle());
                holder2.content.setText(mData.get(i).getContent());
                break;
        }

        return view;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    static class ViewHolder {
        ImageView img;
        TextView title;
        TextView content;
    }

    static class ViewHolder2 {
        ImageView img;
        TextView title;
        TextView content;
    }
}
