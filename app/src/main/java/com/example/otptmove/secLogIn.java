package com.example.otptmove;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class secLogIn extends AppCompatActivity {

    private Button logInPat;
    private EditText patEmail, patPassword;
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sec_log_in);

        logInPat = findViewById(R.id.buttLogInPatient);
        patEmail = findViewById(R.id.patEmail);
        patPassword = findViewById(R.id.patPassword);
        auth = FirebaseAuth.getInstance();

        logInPat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patLogin();

            }
        });


    }

    private void patLogin(){

        String email = patEmail.getText().toString().trim();
        String password = patPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(secLogIn.this, "Authentication Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(secLogIn.this, patientDashboard.class);
                    startActivity(intent);
                }
                else{
                    String error = task.getException().getMessage();
                    Toast.makeText(secLogIn.this, "Authentication Unsuccessful!" + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
