package com.example.prashantkumar.installedappsearch;

import android.graphics.drawable.Drawable;

/**
 * Created by PrashantKumar on 3/31/2017.
 */
public class App {
    Drawable _icon;
    String _label, _packageName;


    public App(){

    }

    public App(String label, Drawable icon, String packageName ){
        this._label = label;
        this._icon = icon;
        this._packageName = packageName;
    }

    public void setLable(String lable){
        this._label = lable;
    }


    public void setIcon(Drawable icon){
        this._icon = icon;
    }

    public void setPackageName(String packageName){
        this._packageName = packageName;
    }

    public String getLable(){
        return this._label;
    }


    public Drawable getIcon(){
        return this._icon;
    }

    public String getPackageName(){
        return this._packageName;
    }

}
