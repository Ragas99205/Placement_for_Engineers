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

public class nontechCompanyAdapter extends RecyclerView.Adapter<nontechCompanyAdapter.ViewHolder>
{

    private List<nontechCompanyRecyclerItems> listItems;
    private Context mContext;

    public nontechCompanyAdapter(List<nontechCompanyRecyclerItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nontech_list,parent,false);
        return new nontechCompanyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        final nontechCompanyRecyclerItems item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.ctc.setText(item.getCtc());
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
        public TextView type;
        public TextView url;
        public TextView wiki;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.nontech_name);
            ctc = itemView.findViewById(R.id.nontech_ctc);
            type = itemView.findViewById(R.id.nontech_type);
            url = itemView.findViewById(R.id.nontech_url);
            wiki = itemView.findViewById(R.id.nontech_wiki);
        }
    }
}
