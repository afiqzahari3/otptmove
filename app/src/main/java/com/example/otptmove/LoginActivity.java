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

public class LoginActivity extends AppCompatActivity {

    private Button submitAuthenticationTherapist;
    private EditText emailTherapist, passwordTherapist;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        submitAuthenticationTherapist = findViewById(R.id.submitAuthTherapist);
        emailTherapist = findViewById(R.id.editTextEmail);
        passwordTherapist = findViewById(R.id.editTextPassword);
        firebaseAuth = FirebaseAuth.getInstance();

        submitAuthenticationTherapist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                therapistAuth();
            }
        });


    }

    private void therapistAuth(){

            String email = emailTherapist.getText().toString().trim();
            String password = passwordTherapist.getText().toString().trim();

            if (TextUtils.isEmpty(email)){
                Toast.makeText(this, "Please enter email", Toast.LENGTH_SHORT).show();
                return;
            }
            if (TextUtils.isEmpty(password)){
                Toast.makeText(this, "Please enter password", Toast.LENGTH_SHORT).show();
                return;
            }

            firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(LoginActivity.this, "Authentication Successful!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, therapistDashboard.class);
                        startActivity(intent);
                    }
                    else{
                        String error = task.getException().getMessage();
                        Toast.makeText(LoginActivity.this, "Authentication Unsuccessful!" + error, Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
}


