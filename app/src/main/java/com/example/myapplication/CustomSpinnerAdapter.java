package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomSpinnerAdapter extends BaseAdapter {
    private ArrayList<Menus> mMenuList;
    private View v;
    private Context mContext;
    private ImageView imgMenus;
    private TextView txtMenus;

    public CustomSpinnerAdapter(ArrayList<Menus> mMenuList, Context mContext) {
        this.mMenuList = mMenuList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mMenuList.size();
    }

    @Override
    public Object getItem(int position) {
        return mMenuList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        v = LayoutInflater.from(mContext).inflate(R.layout.spinner_item,null);
        imgMenus = v.findViewById(R.id.spinner_item_img);
        txtMenus = v.findViewById(R.id.spinner_item_text);

        imgMenus.setImageBitmap(mMenuList.get(position).getIcon());
        txtMenus.setText(mMenuList.get(position).getIconName());
        return v;
    }
}
