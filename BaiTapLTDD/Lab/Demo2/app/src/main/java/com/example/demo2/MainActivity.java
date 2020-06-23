package com.example.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    Button btnChangeImage;
    ImageView imgView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnChangeImage= (Button) findViewById(R.id.btnchangeImg);
        imgView= (ImageView) findViewById(R.id.imgView1);
        imgView.setBackgroundResource(R.mipmap.full_jpg);
        btnChangeImage.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                imgView.setBackgroundResource(R.mipmap.conan);
            }
        });
    }
}
