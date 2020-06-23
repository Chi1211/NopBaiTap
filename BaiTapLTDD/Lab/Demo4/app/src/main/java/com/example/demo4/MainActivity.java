package com.example.demo4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    TextView name;
    TextView year;
    TextView notice;
    Button btnCal;
    int age;
    Activity agr_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCal = (Button) findViewById(R.id.btnCal);
        name = (TextView) findViewById(R.id.InputName);
        year =  (TextView) findViewById(R.id.InputYear);
        notice = (TextView) findViewById(R.id.txtNotices);
        notice.setTextColor(Color.BLUE);
        notice.setTextSize(24);
        getWindow().getDecorView().setBackgroundColor(Color.LTGRAY);
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                age = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(year.getText().toString());
                notice.setText("Bạn " + name.getText() + ","+ age + " Tuổi");
            }
        });
    }
}
