package com.kijiri.aurora.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kijiri.aurora.ui.home.TempResponse;

import java.util.List;

public class TempResponseAdapter extends RecyclerView.Adapter<TempResponseAdapter.ItemViewHolder> {
    private List<TempResponse> tempResponses;

    public TempResponseAdapter(List<TempResponse> tempResponses) {
        this.tempResponses = tempResponses;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater
                .from(viewGroup.getContext())
                .inflate(android.R.layout.simple_list_item_2, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        TempResponse tempResponse = tempResponses.get(position);
        holder.title.setText(tempResponse.getResponse());
    }

    @Override
    public int getItemCount() {
        return tempResponses.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ItemViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(android.R.id.text1);
        }
    }

}
