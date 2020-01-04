package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    EditText e1, e2, e3;
    Button b1;
    Handler database_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        b1 = findViewById(R.id.b1);

        database_login = new Handler(Main2Activity.this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String se1 = e2.getText().toString();
                String se2 = e3.getText().toString();

                if (se1.isEmpty()) {

                    e2.setError("Please enter email");
                } else if (se2.isEmpty()) {

                    e3.setError("Plaese enter password");
                } else {


                    boolean b = database_login.checkUser(se1,se2);

                    if(b){

                        Toast.makeText(Main2Activity.this, "Done", Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(Main2Activity.this, "No okk", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });


    }
}
