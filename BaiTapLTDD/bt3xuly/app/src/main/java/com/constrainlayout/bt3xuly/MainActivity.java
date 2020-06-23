package com.constrainlayout.bt3xuly;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    TextView thongtin;
    EditText name,birthday;
    CheckBox phim, nhac, bong;
    Switch honnhan;
    Button dangki;
    ToggleButton bat;
    ImageButton thoat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (EditText) findViewById(R.id.etName);
        birthday = (EditText) findViewById(R.id.etbirthday);
        phim = (CheckBox) findViewById(R.id.cbhobby1);
        nhac = (CheckBox) findViewById(R.id.cbhobby2);
        bong = (CheckBox) findViewById(R.id.cbhobby3);
        honnhan = (Switch) findViewById(R.id.swhonnhan);
        dangki = (Button) findViewById(R.id.btnregister);
        bat = (ToggleButton) findViewById(R.id.btnhien);
        thoat = (ImageButton) findViewById(R.id.btnexit);
        thongtin= (TextView) findViewById(R.id.txtTitle);
        dangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Check();
            }
        });
        bat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            toggle();
            }
        });
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
                birthday.setText("");
                Toast.makeText(MainActivity.this, "Bạn hãy đăng kí", Toast.LENGTH_LONG).show();
            }
        });
    }
    public void Check() {
        if (name.getText().toString().equals("") && birthday.getText().toString().equals("")) {
            Toast.makeText(MainActivity.this, "Bạn nhập thiếu", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(MainActivity.this, "Bạn đăng kí thành công", Toast.LENGTH_LONG).show();
        }
    }
    public void toggle()
        {
        boolean check= bat.isChecked();
        if(check)
        {
           thongtin.setText("Họ và tên: "+ name.getText()+"\n Ngày sinh: "+ birthday.getText()+"\n Sở thích: "+ checkboxhobby()+ "\n Tình trạng hôn nhân: "+tthonnha());
            thongtin.setTextColor(Color.BLUE);
            thongtin.setTextSize(14);
        }
        else
        {
            thongtin.setText("Thông tin");
            thongtin.setTextColor(Color.BLUE);
            thongtin.setTextSize(36);
        }
    }
    public String checkboxhobby()
    {
        String hobby="";
        if(phim.isChecked())
        {
            hobby+=phim.getText();
        }
        if(nhac.isChecked())
        {
            hobby+=","+nhac.getText();
        }
        if(bong.isChecked())
        {
            hobby+=","+bong.getText();
        }
        return hobby;
    }
    public String tthonnha()
    {
        String tt="";
        boolean b= honnhan.isChecked();
        if(b)
            tt="Đã kết hôn";
        else
            tt="Độc thân";

        return tt;
    }

}
