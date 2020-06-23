package com.linearlayout.firebasedata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    DatabaseReference mdata;
    Button btnregister;
    EditText edtemail, edtpass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnregister=(Button) findViewById(R.id.btnlogin);
        edtemail=(EditText) findViewById(R.id.btnemail);
        edtpass=(EditText) findViewById(R.id.btnpass);
        mdata= FirebaseDatabase.getInstance().getReference();
        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=edtemail.getText().toString();
                String pass=edtpass.getText().toString();
                TaiKhoan tk = new TaiKhoan(email, pass);
                mdata.child("Taikhoan").push().setValue(tk, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(@Nullable DatabaseError error, @NonNull DatabaseReference ref) {
                        if(error == null)
                        {
                            Toast.makeText(MainActivity.this,"Đăng ký thành công",Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(MainActivity.this,"Đăng ký không thành công",Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
