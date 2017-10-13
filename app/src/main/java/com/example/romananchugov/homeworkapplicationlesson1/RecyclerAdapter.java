package com.example.romananchugov.homeworkapplicationlesson1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by romananchugov on 13.10.17.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {
    List<RecyclerElement> data;

    public RecyclerAdapter(List<RecyclerElement> data){
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_element_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.imageView.setImageResource(data.get(position).getImageUrl());
        holder.idText.setText(data.get(position).getId());
        holder.textView.setText(data.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;
        TextView idText;
        ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.text);
            idText = (TextView) itemView.findViewById(R.id.recyclerElemIdTextView);
            imageView = itemView.findViewById(R.id.imageViewElement);
        }
    }
}
