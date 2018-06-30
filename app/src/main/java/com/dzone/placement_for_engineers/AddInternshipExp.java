package com.dzone.placement_for_engineers;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddInternshipExp extends AppCompatActivity {

    TextView close;
    Button submit;
    TextInputEditText t;
    EditText d;
    private FirebaseAuth mAuth;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference,databaseName;
    private String username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_internship_exp);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
    try{
        databaseName = database.getReference("Users").child(user.getUid());

        ValueEventListener eventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String name = dataSnapshot.child("name").getValue(String.class);
                Log.d("TAG","Name is: " + name);
                username = name;
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        };
        databaseName.addListenerForSingleValueEvent(eventListener);
        databaseReference.child("Name").setValue(username);
    }catch(Exception e){

    }

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

                 String usernamefirebase = user.getDisplayName();
                 if(usernamefirebase.isEmpty()){
                     databaseReference.child("Name").setValue(username);
                 }else{
                     databaseReference.child("Name").setValue(usernamefirebase);
                 }

                Toast.makeText(getApplicationContext(),"Experience Submitted !!",Toast.LENGTH_SHORT).show();

                startActivity(new Intent(AddInternshipExp.this,MainPageActivity.class));
                finish();

            }
        });
    }
}
