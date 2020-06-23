package com.linearlayout.qunldanhb;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.linearlayout.qunldanhb.adapter.ContactAdapter;
import com.linearlayout.qunldanhb.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contact> arrayContact;
    ContactAdapter adapter;
    EditText edtname;
    EditText edtnumber;
    RadioButton rbtnnam;
    RadioButton rbtnnu;
    Button luu;
    ListView lvContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_main);
        edtname=(EditText) findViewById(R.id.edt_name);
        edtnumber=(EditText) findViewById(R.id.edt_number);
        rbtnnam=(RadioButton) findViewById(R.id.rbtn_nam);
        rbtnnu=(RadioButton) findViewById(R.id.rbtn_nu);
        luu=(Button) findViewById(R.id.btn_themdb);
        lvContact=(ListView) findViewById(R.id.lv_contact);
        arrayContact= new ArrayList<>();
        adapter= new ContactAdapter(this, R.layout.item_listview,arrayContact);
        lvContact.setAdapter(adapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ShowDialogConfirm(position);
            }
        });

    }
    public void show(View v)
    {
        if(v.getId()==R.id.btn_themdb) {
            String name = edtname.getText().toString().trim();
            String num = edtnumber.getText().toString().trim();
            boolean isgt=true;
            if(rbtnnam.isChecked())
            {
                isgt=true;
            }else{
                isgt=false;
            }
            if(TextUtils.isEmpty(name) || TextUtils.isEmpty(num))
            {
                Toast.makeText(MainActivity.this,"Tên hoặc số điện thoại trống",Toast.LENGTH_SHORT).show();
            }else
            {
                Contact contact=new Contact(isgt, name,num);
                arrayContact.add(contact);
            }
            adapter.notifyDataSetChanged();
        }
    }
    public  void ShowDialogConfirm(final int position){
        AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
        ab.setTitle("Thông báo");
        ab.setMessage("Bạn muốn sửa hay xóa?");
        ab.setPositiveButton("Sửa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (arrayContact.get(position).isNam())
                {
                    rbtnnam.setChecked(true);
                }else
                {
                    rbtnnu.setChecked(true);
                }
                edtname.setText(arrayContact.get(position).getmName());
                edtnumber.setText(arrayContact.get(position).getmNumber());
                luu.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean gt=true;
                        if(rbtnnu.isChecked())
                        {
                            gt=false;
                        }
                        String name = edtname.getText().toString().trim();
                        String num = edtnumber.getText().toString().trim();
                        Contact contact=new Contact(gt, name,num);
                        arrayContact.set(position,contact);
                        adapter.notifyDataSetChanged();
                    }
                });

            }
        });
        ab.setNegativeButton("Xóa", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                AlertDialog.Builder ab = new AlertDialog.Builder(MainActivity.this);
                ab.setTitle("Chú ý");
                ab.setMessage("Bạn chắc chắn xóa?");
                ab.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayContact.remove(position);
                        adapter.notifyDataSetChanged();
                    }
                });
                ab.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                ab.show();
            }
        });
        ab.show();
    }

}
