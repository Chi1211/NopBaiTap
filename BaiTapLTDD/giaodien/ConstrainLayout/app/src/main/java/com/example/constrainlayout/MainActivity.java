package com.example.constrainlayout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText user;
    EditText pass;
    Button login;
    public static final String name="key_username1";
    public static final String passwword="key_pass1";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       user=(EditText) findViewById(R.id.InputEmail);
       pass=(EditText) findViewById(R.id.Inputpass);
        login=(Button)findViewById(R.id.btnlogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(MainActivity.this, LoginActivity.class );
                intent.putExtra(name, user.getText().toString());
                intent.putExtra(passwword, pass.getText().toString());
                startActivity(intent);
            }
        });
    }

}
