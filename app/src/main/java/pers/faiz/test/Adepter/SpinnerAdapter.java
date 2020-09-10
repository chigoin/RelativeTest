package pers.faiz.test.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pers.faiz.test.model.Hero;
import pers.faiz.test.relativetest.R;

public class SpinnerAdapter extends BaseAdapter {

    private List<Hero> mData;
    private Context context;

    public SpinnerAdapter(List<Hero> mData, Context context) {
        this.context = context;
        this.mData = mData;
    }

    @Override
    public int getCount() {
        return mData != null ? mData.size() : 0;
    }

    @Override
    public Object getItem(int i) {
        return mData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(context).inflate(R.layout.spinner_item, viewGroup, false);
            holder.imgIv = view.findViewById(R.id.img_hero);
            holder.nameTv = view.findViewById(R.id.hero_name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.imgIv.setBackgroundResource(mData.get(i).getImg());
        holder.nameTv.setText(mData.get(i).getName());
        return view;
    }

    private static class ViewHolder {
        ImageView imgIv;
        TextView nameTv;
    }
}
