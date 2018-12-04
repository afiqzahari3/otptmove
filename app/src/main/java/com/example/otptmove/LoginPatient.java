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

public class LoginPatient extends AppCompatActivity {

    private Button regPatient, LoginPatient;
    private EditText emailPatient, passwordPatient;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_patient);

        mAuth = FirebaseAuth.getInstance();
        LoginPatient = findViewById(R.id.buttonLogInPatient);
        emailPatient = findViewById(R.id.patientEmail);
        passwordPatient = findViewById(R.id.patientPassword);
        regPatient = findViewById(R.id.buttonRegPatient);

        regPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPatient.this, registerPatient.class);
                startActivity(intent);
            }
        });

        LoginPatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPatient();

            }
        });

    }

    private void loginPatient(){
        String email = emailPatient.getText().toString().trim();
        String password = passwordPatient.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(LoginPatient.this, "Authentication Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginPatient.this, patientDashboard.class);
                    startActivity(intent);
                }
                else{
                    String error = task.getException().getMessage();
                    Toast.makeText(LoginPatient.this, "Authentication Unsuccessful!" + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
