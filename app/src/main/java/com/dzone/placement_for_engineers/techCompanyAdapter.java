package com.dzone.placement_for_engineers;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class techCompanyAdapter extends RecyclerView.Adapter<techCompanyAdapter.ViewHolder>
{

    private List<techCompanyRecyclerItems> listItems;
    private Context mContext;

    public techCompanyAdapter(List<techCompanyRecyclerItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tech_list,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        final techCompanyRecyclerItems item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.ctc.setText(item.getCtc());
        holder.role.setText(item.getRole());
        holder.type.setText(item.getType());

        holder.url.setText(item.getUrl());
        holder.url.setMovementMethod(LinkMovementMethod.getInstance());
        holder.url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = holder.url.getText().toString();
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(url));
                mContext.startActivity(b);
            }
        });

        holder.wiki.setText(item.getWiki());
        holder.wiki.setMovementMethod(LinkMovementMethod.getInstance());
        holder.wiki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = holder.wiki.getText().toString();
                Intent b = new Intent(Intent.ACTION_VIEW);
                b.setData(Uri.parse(url));
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
        public TextView ctc;
        public TextView role;
        public TextView type;
        public TextView url;
        public TextView wiki;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.tech_name);
            ctc = itemView.findViewById(R.id.tech_ctc);
            role = itemView.findViewById(R.id.tech_role);
            type = itemView.findViewById(R.id.tech_type);
            url = itemView.findViewById(R.id.tech_url);
            wiki = itemView.findViewById(R.id.tech_wiki);
        }
    }
}
