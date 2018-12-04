package com.example.otptmove;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class therapistProfile extends AppCompatActivity {

    private Button submitProfile;
    private EditText nameTherapist;
    private Spinner spinner;
    DatabaseReference databaseProfileTherapist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_therapist_profile);

        databaseProfileTherapist = FirebaseDatabase.getInstance().getReference("Information");
        nameTherapist = findViewById(R.id.therapistName);
        spinner = findViewById(R.id.spinnerType);
        submitProfile = findViewById(R.id.submitProfile);

        submitProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editProfile();
            }
        });
    }
    private void editProfile(){
        String name = nameTherapist.getText().toString().trim();
        String type = spinner.getSelectedItem().toString();

        if(!TextUtils.isEmpty(name)){
            String id = databaseProfileTherapist.push().getKey();
            profile Profile = new profile(id,name,type);
            databaseProfileTherapist.child(id).setValue(Profile);

            Toast.makeText(this, "Updated!", Toast.LENGTH_LONG).show();

        }else{
            Toast.makeText(this, "Enter your name", Toast.LENGTH_LONG).show();
        }
    }
}
