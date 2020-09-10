package pers.faiz.test.Adepter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


import pers.faiz.test.model.Group;
import pers.faiz.test.model.Item;
import pers.faiz.test.relativetest.R;

public class ExListViewAdapter extends BaseExpandableListAdapter {

    private ArrayList<Group> gData;
    private ArrayList<ArrayList<Item>> iData;
    private Context context;

    public ExListViewAdapter(ArrayList<Group> gData, ArrayList<ArrayList<Item>> iData, Context context) {
        this.gData = gData;
        this.iData = iData;
        this.context = context;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public int getGroupCount() {
        return gData != null ? gData.size() : 0;
    }

    @Override
    public int getChildrenCount(int i) {
        return iData.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return gData.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return iData.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderGroup holderGroup = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.exlist_group, viewGroup, false);
            holderGroup = new ViewHolderGroup();
            holderGroup.tvGroupName = view.findViewById(R.id.category_tv);
            view.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup) view.getTag();
        }

        holderGroup.tvGroupName.setText(gData.get(i).getgName());
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        ViewHolderItem holderItem = null;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.exlist_item, viewGroup, false);
            holderItem = new ViewHolderItem();
            holderItem.imgIv = view.findViewById(R.id.hero_iv);
            holderItem.nameTv = view.findViewById(R.id.name_iv);
            view.setTag(holderItem);
        } else {
            holderItem = (ViewHolderItem) view.getTag();
        }
        holderItem.imgIv.setBackgroundResource(iData.get(i).get(i1).getImg());
        holderItem.nameTv.setText(iData.get(i).get(i1).getName());

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    private static class ViewHolderGroup {
        private TextView tvGroupName;
    }

    private static class ViewHolderItem {
        private ImageView imgIv;
        private TextView nameTv;
    }
}
