package com.example.constrainlayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    TextView tvName;
    TextView tvpass;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tablelayout_login);
        tvName=(TextView) findViewById(R.id.InputEmail1);
        tvpass=(TextView) findViewById(R.id.Inputpass1);
        Intent intent= getIntent();
        tvName.setText(intent.getStringExtra(MainActivity.name));
        tvpass.setText(intent.getStringExtra(MainActivity.passwword));
    }
}
