package com.example.android.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.os.Bundle;

import static android.os.Build.VERSION_CODES.M;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {
                            case R.id.navigation_location:
                                selectedFragment = LocationActivity.newInstance();
                                break;
                            case R.id.navigation_home:
                                selectedFragment = HomeActivity.newInstance();
                                break;
                            case R.id.navigation_add:
                                selectedFragment = AddActivity.newInstance();
                                break;
                            case R.id.navigation_logs:
                                selectedFragment = LogsActivity.newInstance();
                                break;
                            case R.id.navigation_profile:
                                selectedFragment = ProfileActivity.newInstance();
                                break;
                        }
                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;
                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, HomeActivity.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }
}

//    private TextView mTextMessage;
//
//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            Fragment selectedFragment = null;
//            switch (item.getItemId()) {
//                case R.id.navigation_home:
//                    mTextMessage.setText(R.string.title_home);
//                    return true;
//                case R.id.navigation_location:
//                    mTextMessage.setText(R.string.title_location);
//                    Intent b=new Intent(MainActivity.this, LocationActivity.class);
//                    startActivity(b);
//                    return true;
//                case R.id.navigation_add:
//                    mTextMessage.setText(R.string.title_add);
//                    Intent c=new Intent(MainActivity.this, AddActivity.class);
//                    startActivity(c);
//                    return true;
//                case R.id.navigation_logs:
//                    mTextMessage.setText(R.string.title_logs);
//                    Intent d=new Intent(MainActivity.this, LogsActivity.class);
//                    startActivity(d);
//                    return true;
//                case R.id.navigation_profile:
//                    mTextMessage.setText(R.string.title_profile);
//                    Intent e=new Intent(MainActivity.this, ProfileActivity.class);
//                    startActivity(e);
//                    return true;
//            }
//            return false;
//        }
//
//    };
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        mTextMessage = (TextView) findViewById(R.id.message);
//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//    }
//
//}
