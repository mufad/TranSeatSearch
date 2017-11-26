package com.droiddigger.transeatsearch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Seat_Status extends AppCompatActivity {

    @BindView(R.id.seat_1) ImageView seat_one;
    @BindView(R.id.seat_2) ImageView seat_two;
    @BindView(R.id.seat_3) ImageView seat_three;
    @BindView(R.id.seat_4) ImageView seat_four;
    @BindView(R.id.seat_5) ImageView seat_five;
    FirebaseDatabase database;
    DatabaseReference seat_1, seat_2, seat_3, seat_4, seat_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seat__status);
        ButterKnife.bind(this);
        database=FirebaseDatabase.getInstance();
        seat_1=database.getReference("root/seat_1");
        seat_2=database.getReference("root/seat_2");
        seat_3=database.getReference("root/seat_3");
        seat_4=database.getReference("root/seat_4");
        seat_5=database.getReference("root/seat_5");

        seat_1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String seatStatus = dataSnapshot.getValue(String.class);
                if (seatStatus.equalsIgnoreCase("empty")){
                    seat_one.setImageDrawable(getDrawable(R.drawable.green));
                }else {

                    seat_one.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        seat_2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String seatStatus = dataSnapshot.getValue(String.class);
                if (seatStatus.equalsIgnoreCase("empty")){
                    seat_two.setImageDrawable(getDrawable(R.drawable.green));
                }else {

                    seat_two.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        seat_3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String seatStatus = dataSnapshot.getValue(String.class);
                if (seatStatus.equalsIgnoreCase("empty")){
                    seat_three.setImageDrawable(getDrawable(R.drawable.green));
                }else {

                    seat_three.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        seat_4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String seatStatus = dataSnapshot.getValue(String.class);
                if (seatStatus.equalsIgnoreCase("empty")){
                    seat_four.setImageDrawable(getDrawable(R.drawable.green));
                }else {

                    seat_four.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        seat_5.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String seatStatus = dataSnapshot.getValue(String.class);
                if (seatStatus.equalsIgnoreCase("empty")){
                    seat_five.setImageDrawable(getDrawable(R.drawable.green));
                }else {

                    seat_five.setImageDrawable(getDrawable(R.drawable.red));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }


}
