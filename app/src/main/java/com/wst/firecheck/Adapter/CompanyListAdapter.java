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
import com.wst.firecheck.model.Company;
import java.util.List;

/**
 * Created by li449 on 2018/3/27.
 */

public class CompanyListAdapter extends ArrayAdapter<Company> {
    private  int resourceId;
    public CompanyListAdapter(Context context,int textViewResourceId,List<Company> companys)
    {
        super(context,textViewResourceId,companys);
        resourceId=textViewResourceId;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Company company=getItem(position);
        View view;
        ViewHolder viewHolder;
        if(convertView==null)
        {
            view= LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder=new ViewHolder();
            viewHolder.companyId=view.findViewById(R.id.cid);
            viewHolder.companyName=view.findViewById(R.id.companyName);
            view.setTag(viewHolder);
        }else
        {
            view=convertView;
            viewHolder=(ViewHolder)view.getTag();
        }
        viewHolder.companyId.setText(String.valueOf(company.getCompanyId()));
        viewHolder.companyName.setText(company.getCompanyName());
        return view;
    }
}
class ViewHolder{
    TextView companyId;
    TextView companyName;
}
