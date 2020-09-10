package pers.faiz.test.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.w3c.dom.Text;

import java.util.ArrayList;

import pers.faiz.test.model.News;
import pers.faiz.test.relativetest.R;

public class NewsAdapter extends BaseAdapter {

    private ArrayList<News> mData;
    private Context mContext;


    public NewsAdapter(ArrayList<News> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    //    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, viewGroup, false);
//        ImageView img = view.findViewById(R.id.img);
//        TextView tvTitle = view.findViewById(R.id.tv_title);
//        TextView tvContent = view.findViewById(R.id.tv_content);
//        img.setBackgroundResource(mData.get(i).getImage());
//        tvContent.setText(mData.get(i).getContent());
//        tvTitle.setText(mData.get(i).getTitle());
//        return view;
//    }
//BaseAdapter 优化
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //一、使用ViewHolder复用源码
        //二、使用ViewHolder缓存
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.listview_item, viewGroup, false);
            holder.img = view.findViewById(R.id.img);
            holder.title = view.findViewById(R.id.tv_title);
            holder.content = view.findViewById(R.id.tv_content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.img.setBackgroundResource(R.mipmap.news);
        holder.title.setText(mData.get(i).getTitle());
        holder.content.setText(mData.get(i).getContent());
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
}
