package com.example.prashantkumar.installedappsearch;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by PrashantKumar on 3/31/2017.
 */
public class AppListViewAdapter extends ArrayAdapter<App> {
    AppListViewAdapter(Context context, List<App> appList){
        super(context, R.layout.app_list_view, appList);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View view = layoutInflater.inflate(R.layout.app_list_view, parent, false);

        App app = getItem(position);
        TextView packageName = (TextView)view.findViewById(R.id.packageName);
        ImageView icon = (ImageView)view.findViewById(R.id.icon);
        TextView label = (TextView)view.findViewById(R.id.label);

        packageName.setText(app.getPackageName());
        icon.setBackground(app.getIcon());
        label.setText(app.getLable());

        return view;
    }
}
