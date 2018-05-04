package com.nish.traggle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class CommunityActivity extends AppCompatActivity {

    private TextView mTextMessage;
    Intent myIntent;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    myIntent = new Intent(CommunityActivity.this, MainActivity.class);
                    CommunityActivity.this.startActivity(myIntent);
                    return true;
                case R.id.navigation_search:
                    myIntent = new Intent(CommunityActivity.this, SearchActivity.class);
                    CommunityActivity.this.startActivity(myIntent);
                    return true;
                case R.id.navigation_community:
                    myIntent = new Intent(CommunityActivity.this, CommunityActivity.class);
                    CommunityActivity.this.startActivity(myIntent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_community);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_community);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
