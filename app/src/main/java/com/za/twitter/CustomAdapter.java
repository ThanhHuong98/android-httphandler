package com.za.twitter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<User> implements View.OnClickListener {

    private ArrayList<User> users = new ArrayList<>();
    Context mContext;

    public CustomAdapter(ArrayList<User> data, Context context){
        super(context, R.layout.list_item, data);
        this.users = data;
        this.mContext = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        View row = convertView;

        if(row == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            row = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder.txFullName = (TextView) row.findViewById(R.id.fullname);
            viewHolder.txEmail = (TextView) row.findViewById(R.id.email);

            row.setTag(viewHolder);

        }else {
            viewHolder = (ViewHolder) row.getTag();
        }

        User user = getItem(position);
        viewHolder.txFullName.setText(user.getFirstName() + " " + user.getLastName());
        viewHolder.txEmail.setText(user.getEmail());
        return row;
    }


    @Override
    public void onClick(View v) {

    }

    private class ViewHolder{
        TextView txFullName;
        TextView txEmail;

    }
}
