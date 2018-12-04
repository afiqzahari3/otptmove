package com.example.otptmove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class therapistDashboard extends AppCompatActivity {

    Button profileTherapist , displayPatient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_dashboard);

        profileTherapist = findViewById(R.id.buttonProfileTherapist);

        profileTherapist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(therapistDashboard.this , therapistProfile.class);
                startActivity(intent);
            }
        });
    }
}
