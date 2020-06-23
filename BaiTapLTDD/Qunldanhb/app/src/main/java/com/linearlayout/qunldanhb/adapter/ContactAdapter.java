package com.linearlayout.qunldanhb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.linearlayout.qunldanhb.R;
import com.linearlayout.qunldanhb.model.Contact;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<Contact> {
    private Context context;
    private int resource;
    private List<Contact> arrayContact;
    public ContactAdapter(@NonNull Context context, int resource, @NonNull List<Contact> objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.arrayContact=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder viewholder;
        if(convertView==null)
        {
            viewholder=new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.item_listview,parent,false);
            viewholder.imgavatar= (ImageView) convertView.findViewById(R.id.img_avatar);
            viewholder.tvname=(TextView) convertView.findViewById(R.id.name);
            viewholder.tvnumber=(TextView) convertView.findViewById(R.id.number);
            convertView.setTag(viewholder);
        }else
        {
            viewholder= (ViewHolder)convertView.getTag();
        }
        Contact contact=arrayContact.get(position);
        viewholder.tvname.setText(contact.getmName());
        viewholder.tvnumber.setText(contact.getmNumber());
        if(contact.isNam())
        {
            viewholder.imgavatar.setBackgroundResource(R.drawable.ic_nam);
        }else
        {
            viewholder.imgavatar.setBackgroundResource(R.drawable.ic_nu);
        }
        return convertView;
    }
    public class ViewHolder{
        ImageView imgavatar;
        TextView tvname;
        TextView tvnumber;

    }
}
