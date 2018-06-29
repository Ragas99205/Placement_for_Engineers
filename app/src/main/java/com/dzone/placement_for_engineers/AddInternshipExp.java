package com.dzone.placement_for_engineers;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddInternshipExp extends AppCompatActivity {

    TextView close;
    Button submit;
    TextInputEditText t;
    EditText d;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_internship_exp);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        t = (TextInputEditText)findViewById(R.id.add_intern_title);
        d = (EditText)findViewById(R.id.add_intern_desc);

        close = (TextView)findViewById(R.id.intern_close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        submit = (Button)findViewById(R.id.submit_intern_exp);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = t.getText().toString().trim();
                String desc = d.getText().toString().trim();

                if (TextUtils.isEmpty(title)) {
                    Toast.makeText(getApplicationContext(), "Enter title !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(desc)) {
                    Toast.makeText(getApplicationContext(), "Enter Description !!", Toast.LENGTH_SHORT).show();
                    return;
                }

                FirebaseUser user = mAuth.getCurrentUser();
                databaseReference = database.getReference("InterviewExpInternship").child(user.getUid()).child(title);
                databaseReference.child("Title").setValue(title);
                databaseReference.child("Description").setValue(desc);
                databaseReference.child("Name").setValue(user.getDisplayName());

                Toast.makeText(getApplicationContext(),"Experience Submitted !!",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(AddInternshipExp.this,MainPageActivity.class));
                finish();

            }
        });
    }
}
