package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Main4Activity extends AppCompatActivity {

    EditText e1,p1;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        e1=findViewById(R.id.e1);
        p1=findViewById(R.id.p1);
        b1=findViewById(R.id.b1);


    }
}
