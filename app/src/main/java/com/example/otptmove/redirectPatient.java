package com.example.otptmove;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class redirectPatient extends AppCompatActivity {

    private Button redir;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_redirect_patient);

        redir = findViewById(R.id.redirectPatient);

        redir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(redirectPatient.this, secLogIn.class);
                startActivity(intent);
            }
        });
    }
}
