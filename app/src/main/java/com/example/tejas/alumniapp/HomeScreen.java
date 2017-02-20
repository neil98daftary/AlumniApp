package com.example.tejas.alumniapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class HomeScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        sp = getSharedPreferences("log_data", Context.MODE_PRIVATE);
        editor = sp.edit();


        String[] branches={"Computer","IT","EXTC","ETRX"};
        ListAdapter listAdapter=new HomeScreenCustomAdapter(this,branches);
        ListView listview=(ListView)findViewById(R.id.listview);
        listview.setAdapter(listAdapter);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String food = String.valueOf(adapterView.getItemAtPosition(i));
                Toast.makeText(HomeScreen.this, food, Toast.LENGTH_SHORT).show();

                if(food=="Computer")
                {
                    Intent i2=new Intent(HomeScreen.this,Computers.class);
                    startActivity(i2);
                }

                if(food=="IT")
                {
                    Intent i3=new Intent(HomeScreen.this,IT.class);
                    startActivity(i3);

                }

                if(food=="EXTC")
                {
                    Intent i4=new Intent(HomeScreen.this,EXTC.class);
                    startActivity(i4);

                }

                if(food=="ETRX")
                {
                    Intent i5=new Intent(HomeScreen.this,ETRX.class);
                    startActivity(i5);

                }

            }
        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_homescreen) {
           Intent intent=new Intent(HomeScreen.this,HomeScreen.class);
            startActivity(intent);
        } else if (id == R.id.nav_aboutspit) {
            Intent intent=new Intent(HomeScreen.this,SPIT.class);
            startActivity(intent);

        } else if (id == R.id.nav_developers) {
            Intent intent = new Intent(HomeScreen.this, Developers.class);
            startActivity(intent);
        }else if (id == R.id.nav_alumniregistration) {
            Intent intent = new Intent(HomeScreen.this, Register.class);
            startActivity(intent);
        }else if (id == R.id.nav_signout) {

            editor.putInt("log", 0);
            editor.commit();
            Intent intent = new Intent(HomeScreen.this, Login.class);
            startActivity(intent);
            finish();

        }
        else if (id == R.id.nav_industry) {
            Intent intent = new Intent(HomeScreen.this, industry.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
