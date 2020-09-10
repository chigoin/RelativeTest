package pers.faiz.test.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import pers.faiz.test.model.Icon;
import pers.faiz.test.relativetest.R;

public class GridViewAdapter extends BaseAdapter {

    private List<Icon> mData;
    private Context mContext;

    public GridViewAdapter(List<Icon> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
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
        ViewHolder holder = null;
        if (view == null) {
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.gridview_item
                    , viewGroup
                    , false);
            holder.img_icon =  view.findViewById(R.id.img_icon);
            holder.name =  view.findViewById(R.id.txt_icon);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.img_icon.setImageResource(mData.get(i).getIconId());
        holder.name.setText(mData.get(i).getName());
        return view;
    }

    static class ViewHolder {
        private ImageView img_icon;
        private TextView name;
    }

}
