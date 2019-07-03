package com.wahyudemo.drawer;

import android.os.*;
import android.support.design.widget.*;
import android.support.v4.widget.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;

import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
{
    private TextView mTextMessage;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
	private NavigationView mNavigationView;
    private CoordinatorLayout mLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavigationView = findViewById(R.id.nav_view);
        mLayout = findViewById(R.id.main_layout);
		mTextMessage = findViewById(R.id.message);

        setSupportActionBar(mToolbar);
        setupNavDrawer();
    }

    private void setupNavDrawer()
    {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener(){
                // Handle navigation Click by id
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem)
                {
                    switch (menuItem.getItemId()) {
                        case R.id.nav_home:
                            mTextMessage.setText("Home");
                            break;
                        case R.id.nav_notification:
                            mTextMessage.setText("Notification");
                            break;
                        case R.id.nav_dashboard:
                            mTextMessage.setText("Dashboard");
                            break;
                        case R.id.nav_settings:
                            Snackbar.make(mLayout, "Replace your own action", Snackbar.LENGTH_SHORT).show();
                            break;
                        case R.id.nav_about:
                            Snackbar.make(mLayout, "Replace your own action", Snackbar.LENGTH_SHORT).show();
                            break;
                    }
                    mDrawerLayout.closeDrawers();
                    return true;
                }
            });

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open, R.string.close){
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();
		mDrawerLayout.closeDrawers();
    }
}
