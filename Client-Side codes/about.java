package com.example.shahityaa.myapplication;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class about extends AppCompatActivity {

    private DrawerLayout m1DrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

       Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        m1DrawerLayout = findViewById(R.id.drawer_layout);

        m1DrawerLayout.addDrawerListener(
                new DrawerLayout.DrawerListener() {
                    @Override
                    public void onDrawerSlide(View drawerView, float slideOffset) {
                        // Respond when the drawer's position changes
                    }

                    @Override
                    public void onDrawerOpened(View drawerView) {
                        // Respond when the drawer is opened
                    }

                    @Override
                    public void onDrawerClosed(View drawerView) {
                        // Respond when the drawer is closed
                    }

                    @Override
                    public void onDrawerStateChanged(int newState) {
                        // Respond when the drawer motion state changes
                    }
                }
        );

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        m1DrawerLayout.closeDrawers();

                        switch (menuItem.getItemId()) {
                            case R.id.aboutUs:
                                Intent about = new Intent(getApplicationContext(), about.class);
                                startActivity(about);
                                return true;
                            case R.id.servicesOffered:
                                Intent serv = new Intent(getApplicationContext(),services.class);
                                startActivity(serv);
                                return true;
                            case R.id.fixAppointments:
                                Intent appnt = new Intent(getApplicationContext(),appointment.class);
                                startActivity(appnt);
                                return true;
                            case R.id.bill:
                                Intent intent = new Intent (getApplicationContext(),page2.class);
                                startActivity(intent);
                                return true;
                            case R.id.nav_home:
                                Intent hintent = new Intent (getApplicationContext(),MainActivity.class);
                                /*PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(),1,hintent,PendingIntent.FLAG_CANCEL_CURRENT);
                                try
                                {
                                    pendingIntent.send();
                                }
                                catch(PendingIntent.CanceledException e)
                                {
                                    e.printStackTrace();
                                }*/
                                startActivity(hintent);
                                return true;
                            default:
                                return true;
                        }
                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here


                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu)
    {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        final Context context = this;
        String notif = "Long press the above button";

        switch (item.getItemId())
        {
            case R.id.op1:
                Intent about = new Intent(context,about.class);
                startActivity(about);
                return true;
            case R.id.op2:
                Intent serv = new Intent(context,services.class);
                startActivity(serv);
                return true;
            case R.id.op3:
                Intent appnt = new Intent(context,appointment.class);
                startActivity(appnt);
                return true;
            case R.id.op4:
                Intent intent = new Intent (context,page2.class);
                startActivity(intent);
                return true;
            case android.R.id.home:
                m1DrawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return true;
        }
    }

}
