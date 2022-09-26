package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<Item> itemLists;

    public RecyclerViewAdapter(List<Item> itemLists) {
        this.itemLists = itemLists;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.listviewitem,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Item item=itemLists.get(position);
        holder.itemText.setText(item.getItemname());
        holder.itemImage.setImageResource(item.getItemimg());
    }

    @Override
    public int getItemCount() {
        return itemLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemText;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemImage= itemView.findViewById(R.id.listview_image);
            itemText=itemView.findViewById(R.id.listview_text);
        }
    }
}
