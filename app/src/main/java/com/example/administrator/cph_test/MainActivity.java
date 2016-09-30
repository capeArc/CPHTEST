package com.example.administrator.cph_test;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String name;
    String password;
    EditText e1,e2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        e1 = (EditText) findViewById(R.id.name);
        e2 = (EditText) findViewById(R.id.password);
    }

    public void onClick(View view){

        try {
            if(e1.getText().toString().equals("admin") && e2.getText().toString().equals("abc")){
                Intent intent = new Intent(this, Collection.class);
                startActivity(intent);
            }
            else {
                Toast.makeText(this, "Please enter valid name and password!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception ex){
            Toast.makeText(this, ""+ex, Toast.LENGTH_LONG).show();
        }
    }
}
