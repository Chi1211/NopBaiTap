package com.example.demo3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtSo;
    Button btnGiam;
    Button btnTang;
    Button btnOpenActivity;
    int currentNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSo = (TextView) findViewById(R.id.txtNumber);
        txtSo.setTextColor(Color.parseColor("#A11A1A"));
        btnGiam =   (Button) findViewById(R.id.btnGiam);
        btnTang = (Button) findViewById(R.id.btnTang);
        btnOpenActivity = (Button)findViewById(R.id.btnNext);
        btnGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                currentNumber = Integer.parseInt((String) txtSo.getText()) -1;
                txtSo.setText(String.valueOf(currentNumber));
            }
        });
        btnTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentNumber = Integer.parseInt((String) txtSo.getText()) -1;
                txtSo.setText(String.valueOf(currentNumber));
            }
        });
        btnOpenActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), AgeActivity.class);
                startActivity(i);
            }
        });
    }

    public  boolean onCreateOptionMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        return  true;
    }

}
