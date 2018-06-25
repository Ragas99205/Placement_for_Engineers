package com.dzone.placement_for_engineers;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class interviewExpAdapter extends RecyclerView.Adapter<interviewExpAdapter.ViewHolder>
{

    private List<interviewExpRecyclerItems> listItems;
    private Context mContext;

    public interviewExpAdapter(List<interviewExpRecyclerItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.intern_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final interviewExpRecyclerItems item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.title.setText(item.getTitle());
        holder.desc.setText(item.getDesc());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name;
        public TextView title;
        public TextView desc;


        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.intern_name);
            title = itemView.findViewById(R.id.intern_title);
            desc = itemView.findViewById(R.id.intern_desc);
        }
    }
}
