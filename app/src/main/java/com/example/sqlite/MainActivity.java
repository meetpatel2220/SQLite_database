package com.example.sqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 EditText e1,e2,e3;
  Button b1,b2;
  Handler database_ragistration;
  Model model_ragistartion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        model_ragistartion=new Model();
        database_ragistration=new Handler(MainActivity.this);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String se1=e2.getText().toString();
                String se2=e3.getText().toString();

                if(se1.isEmpty()){

                    e2.setError("Please enter email");
                }
                else if(se2.isEmpty()){

                    e3.setError("Plaese enter password");
                }
                else {

                    model_ragistartion.setEmail(se1);
                   model_ragistartion.setPassword(se2);
                database_ragistration.adduser(model_ragistartion);
                    Toast.makeText(MainActivity.this, "Ragistration successful", Toast.LENGTH_SHORT).show();

                }
            }
        });



    }
}
