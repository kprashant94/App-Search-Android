package com.example.prashantkumar.installedappsearch;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickSearchButton(View view){
        EditText searchTerm = (EditText)findViewById(R.id.searchTerm);
        TextView noAppFound = (TextView)findViewById(R.id.noAppFound);
        ListView listView = (ListView)findViewById(android.R.id.list);

        final PackageManager packageManager = getPackageManager();
        List<ApplicationInfo> apps = packageManager.getInstalledApplications(0);
        List<App> foundApps = new ArrayList<>();
        boolean found = false;
        for(final ApplicationInfo app : apps){
            String label = (String)packageManager.getApplicationLabel(app);
            Drawable icon = packageManager.getApplicationIcon(app);
            if(label.toLowerCase().contains(searchTerm.getText().toString().toLowerCase())){
                App foundApp = new App(label, icon, app.packageName);
                foundApps.add(foundApp);
                found = true;
            }
        }

        if(found){
            noAppFound.setVisibility(View.INVISIBLE);
            listView.setVisibility(View.VISIBLE);
            ListAdapter listAdapter = new AppListViewAdapter(this, foundApps);
            listView.setAdapter(listAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    TextView packageName = (TextView)view.findViewById(R.id.packageName);
                    Intent intent = getPackageManager().getLaunchIntentForPackage(packageName.getText().toString());
                    startActivity(intent);
                }
            });
        }
        else{
            listView.setVisibility(View.INVISIBLE);
            noAppFound.setVisibility(View.VISIBLE);

        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
