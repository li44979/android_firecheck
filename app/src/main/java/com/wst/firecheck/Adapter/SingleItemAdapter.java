package com.wst.firecheck.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wst.firecheck.Domin.InfoItem;
import com.wst.firecheck.R;

import java.util.List;

/**
 * Created by admin on 2018/2/28.
 */

public class SingleItemAdapter extends RecyclerView.Adapter<SingleItemAdapter.ViewHolder> {
    private List<InfoItem> mInfoItemList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvTitle;
        TextView tvContent;
        public ViewHolder(View view) {
            super(view);
            tvTitle = (TextView) view.findViewById(R.id.tv_item_title);
            tvContent = (TextView) view.findViewById(R.id.tv_item_content);
        }
    }

    public SingleItemAdapter(List<InfoItem> infoItemList){
        mInfoItemList = infoItemList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_title_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        InfoItem info = mInfoItemList.get(position);
        holder.tvTitle.setText(info.GetTitle());
        holder.tvContent.setText(info.GetContent());
    }

    @Override
    public int getItemCount() {
        return mInfoItemList.size();
    }
}
