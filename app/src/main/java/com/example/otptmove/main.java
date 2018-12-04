package com.example.otptmove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class main extends AppCompatActivity {

    private Button gotoTherapist, gotoPatient ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gotoTherapist = findViewById(R.id.bt1);
        gotoPatient = findViewById(R.id.bt2);

        gotoTherapist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        gotoPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(main.this, patientDashboard.class);
                startActivity(intent);
            }
        });
    }
}
