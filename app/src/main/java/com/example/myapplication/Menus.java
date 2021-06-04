package com.example.myapplication;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.util.ArrayList;

public class Menus {
    private Bitmap icon;
    private  String iconName;
    public Menus() {
    }

    public Menus(Bitmap icon, String iconName) {
        this.icon = icon;
        this.iconName = iconName;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }
    public static ArrayList<Menus> getData(Context mContext){
        Integer[] listMenu = {
                R.drawable.home,
                R.drawable.breakfast,
                R.drawable.map,
                R.drawable.exchange
        };
        String[] listMenuName = {
                "MAIN SCREEN",
                "BREAKFAST",
                "PLACES TO GO",
                "FOREIGN CURRENCY"
        };

        ArrayList<Menus> menulist = new ArrayList<>();
        Menus mMenu;
        Bitmap mIcon;
        for (int i = 0;i<listMenu.length;i++){
            mIcon = BitmapFactory.decodeResource(mContext.getResources(),listMenu[i]);
            mMenu = new Menus(mIcon,listMenuName[i]);
            menulist.add(mMenu);
        }
        return menulist;
    }
}
