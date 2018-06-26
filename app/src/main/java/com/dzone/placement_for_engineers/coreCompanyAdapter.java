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

public class coreCompanyAdapter extends RecyclerView.Adapter<coreCompanyAdapter.ViewHolder>
{

    private List<coreCompanyRecyclerItems> listItems;
    private Context mContext;

    public coreCompanyAdapter(List<coreCompanyRecyclerItems> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public coreCompanyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.core_list,parent,false);
        return new coreCompanyAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final coreCompanyAdapter.ViewHolder holder, int position) {

        final coreCompanyRecyclerItems item = listItems.get(position);
        holder.name.setText(item.getName());
        holder.ctc.setText(item.getCtc());
        holder.pref_stream.setText(item.getPref_stream());

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
        public TextView pref_stream;
        public TextView url;
        public TextView wiki;

        public ViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.core_name);
            ctc = itemView.findViewById(R.id.core_ctc);
            pref_stream = itemView.findViewById(R.id.core_pref_stream);
            url = itemView.findViewById(R.id.core_url);
            wiki = itemView.findViewById(R.id.core_wiki);
        }
    }
}
