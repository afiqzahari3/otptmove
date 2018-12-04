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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class registerPatient extends AppCompatActivity {

    private Button regPatientButton;
    private EditText regPatientEmail, regPatientPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_patient);

        regPatientButton = findViewById(R.id.buttonRegisterPatient);
        regPatientEmail = findViewById(R.id.registerEmailPatient);
        regPatientPassword = findViewById(R.id.registerPasswordPatient);
        firebaseAuth = FirebaseAuth.getInstance();


        regPatientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();

            }
        });


    }
    private void registerUser(){
        String email = regPatientEmail.getText().toString().trim();
        String password = regPatientPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(registerPatient.this, "Registration Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(registerPatient.this, redirectPatient.class);
                    startActivity(intent);
                }
                else{
                    String error = task.getException().getMessage();
                    Toast.makeText(registerPatient.this, "Registration Unsuccessful!" + error, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
