package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlacementConAdapter extends RecyclerView.Adapter<PlacementConAdapter.ViewHolder>{

    private List<PlacementConRecyclerItems> listItems;
    private Context mContext;

    public PlacementConAdapter(List<PlacementConRecyclerItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.placement_con_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final PlacementConRecyclerItems item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.address.setText(item.getAddress());
        holder.locality.setText(item.getLocality());
        holder.url.setText(item.getUrl());
        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String web = holder.url.getText().toString();
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(web));
                mContext.startActivity(b);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        public TextView name;
        public TextView locality;
        public TextView address;
        public TextView url;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.plac_con_name);
            address = itemView.findViewById(R.id.plac_con_address);
            url = itemView.findViewById(R.id.plac_con_url);
            locality = itemView.findViewById(R.id.plac_con_locality);
        }
    }
}
