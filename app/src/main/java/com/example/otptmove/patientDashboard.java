package com.example.otptmove;

import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class patientDashboard extends AppCompatActivity {

    ListView listViewTherapists;
    DatabaseReference databaseProfileTherapists;
    List<profile> therapistList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_dashboard);

        databaseProfileTherapists = FirebaseDatabase.getInstance().getReference("Information");
        listViewTherapists = findViewById(R.id.listViewTherapist);
        therapistList = new ArrayList<>();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseProfileTherapists.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                therapistList.clear();
                for (DataSnapshot therapistSnapshot : dataSnapshot.getChildren()){
                    profile Profile = therapistSnapshot.getValue(profile.class);
                    therapistList.add(Profile);
                }
                therapistList adapter = new therapistList(patientDashboard.this, therapistList);
                listViewTherapists.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}

