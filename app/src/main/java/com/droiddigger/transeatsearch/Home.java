package com.droiddigger.transeatsearch;

import android.content.Intent;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Home extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    static final CameraPosition home = CameraPosition.builder().target(new LatLng(23.780443, 90.406741)).
            zoom(15).bearing(0).tilt(45).build();
    MarkerOptions bus=new MarkerOptions().
            position(new LatLng(23.780261, 90.407497)).title("BRACU");
    FirebaseDatabase database;
    DatabaseReference position;
    @BindView(R.id.bottom_sheet)
    LinearLayout bottomsheet;
    BottomSheetBehavior bottomSheetBehavior;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        BitmapDescriptorFactory.defaultMarker();
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        bottomSheetBehavior = BottomSheetBehavior.from(bottomsheet);
        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;
        mMap.moveCamera(CameraUpdateFactory.newCameraPosition(home));
        mMap.addMarker(bus);
    }
    @Override
    protected void onStart() {
        super.onStart();

        database = FirebaseDatabase.getInstance();
        position = database.getReference("root/position");
        position.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String positionString = dataSnapshot.getValue(String.class);
                String[] parts = positionString.split("_");
                String part1 = parts[0];
                String part2 = parts[1];
                Log.d("Cor", part1 + part2);
                bus = new MarkerOptions().position(new LatLng(Double.parseDouble(part1), Double.parseDouble(part2))).
                        title("Alif Paribahan").icon(BitmapDescriptorFactory.fromResource(R.drawable.bus));
                mMap.clear();
                mMap.addMarker(bus);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    @OnClick(R.id.openNewAct)void openAct(){
        startActivity(new Intent(Home.this, Seat_Status.class));
    }
    @OnClick(R.id.dummy1)void dummy1(){
        Toast.makeText(this, "This will be added later", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.dummy2)void dummy2(){
        Toast.makeText(this, "This will be added later", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.dummy3)void dummy3(){
        Toast.makeText(this, "This will be added later", Toast.LENGTH_SHORT).show();
    }
}