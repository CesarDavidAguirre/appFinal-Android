package com.example.cesar.appfinal;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar );
        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout)findViewById(R.id.tab_layaut);
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab2));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        final PageAdapter adapter = new PageAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener(){
            @Override
            public void onTabSelected (TabLayout.Tab tab ){
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected (TabLayout.Tab tab){

            }
            @Override
            public void onTabReselected (TabLayout.Tab tab){

            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        switch (id){
            case R.id.item1: {
                VerHistorial(null);
                return true;
            }

            case R.id.item3:{
                envError(null);
                return true;
            }
            default:{
                return super.onOptionsItemSelected(item);
            }
        }
    }

    public void VerHistorial (View view){
        Intent intent = new Intent(this,VerHistorial.class);
        startActivity(intent);
    }

    public void envError (View view) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_SUBJECT, "Se A Reportado Un Error");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"cesaraguirre566@gmail.com"});
        startActivity(intent);
    }
    public void hoyst(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.hoyts.com.ar"));
        startActivity(intent);
    }
    public void rex(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://cinesgranrex.com.ar"));
        startActivity(intent);
    }
    public void cinerama(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.cinerama.com.ar"));
        startActivity(intent);
    }
    public void dino(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.cinesdinomall.com.ar"));
        startActivity(intent);
    }
}
