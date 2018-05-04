package com.nish.traggle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    private TextView mTextMessage;
    Intent myIntent;
    private GoogleMap mMap;
    private Fragment mFragment;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    myIntent = new Intent(MainActivity.this, MainActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    return true;
                case R.id.navigation_search:
                    myIntent = new Intent(MainActivity.this, SearchActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    return true;
                case R.id.navigation_community:
                    myIntent = new Intent(MainActivity.this, CommunityActivity.class);
                    MainActivity.this.startActivity(myIntent);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setSelectedItemId(R.id.navigation_home);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng nyc = new LatLng(40.756755, -73.956118);
        mMap.addMarker(new MarkerOptions().position(nyc).title("Marker in NYC"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(nyc));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(nyc, 12));
    }
}
