package com.dzone.placement_for_engineers;

import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddInternshipExp extends AppCompatActivity {

    TextView close;
    Button submit;
    TextInputEditText t;
    EditText d;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_internship_exp);

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
                String title = t.getText().toString();
                String desc = d.getText().toString();

            }
        });
    }
}
