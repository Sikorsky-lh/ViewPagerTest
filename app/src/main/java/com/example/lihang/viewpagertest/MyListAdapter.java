package com.example.lihang.viewpagertest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lihang on 2017/3/17.
 */

public class MyListAdapter extends ArrayAdapter<Chat> {
    private int resourceId;
    public MyListAdapter(Context context, int resource, List<Chat> objects) {
        super(context, resource, objects);
        this.resourceId=resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        Chat chat=getItem(position);
        if(convertView==null){
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
        }else {
            view=convertView;
        }
        ImageView userImg= (ImageView) view.findViewById(R.id.Img_contact);
        TextView userName= (TextView) view.findViewById(R.id.Name_contact);
        TextView userContent= (TextView) view.findViewById(R.id.Description_contact);

        userImg.setImageResource(chat.getImgId());
        userName.setText(chat.getName());
        userContent.setText(chat.getContent());
        return view;
    }
}
