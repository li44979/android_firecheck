package com.wst.firecheck.Adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.wst.firecheck.R;
import com.wst.firecheck.model.User;

import java.util.List;

/**
 * Created by li449 on 2018/3/28.
 */

public class UserListAdapter extends ArrayAdapter<User>{
    private  int resourceId;
    public UserListAdapter(@NonNull Context context,int textViewResourceId, @NonNull List<User> users) {
        super(context,textViewResourceId, users);
        resourceId=textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        User user=getItem(position);
        View view;
        User_ViewHolder viewHolder;
        if(convertView==null)
        {
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new User_ViewHolder();
            viewHolder.name=view.findViewById(R.id.name);
            viewHolder.mobile=view.findViewById(R.id.mobile);
            view.setTag(viewHolder);
        }else
        {
            view=convertView;
            viewHolder=(User_ViewHolder) view.getTag();
        }
        viewHolder.name.setText(user.getName());
        viewHolder.mobile.setText(user.getMobilePhone());
        return view;
    }
}
 class User_ViewHolder{
    TextView name;
    TextView mobile;
}
