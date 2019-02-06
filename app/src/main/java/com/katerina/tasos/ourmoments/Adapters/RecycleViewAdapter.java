package com.katerina.tasos.ourmoments.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.katerina.tasos.ourmoments.Objects.Images;
import com.katerina.tasos.ourmoments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {
    private ArrayList<Images> galleryList;
    private Context context;

    public RecycleViewAdapter(Context context, ArrayList<Images> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item, viewGroup, false);
        return new RecycleViewAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecycleViewAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(galleryList.get(i).getName());
        final String t = galleryList.get(i).getName();
        if (galleryList.get(i) != null) {

            if (galleryList.get(i).getCloudLink().length() > 5) {
                Picasso.get().load(galleryList.get(i).getCloudLink()).resize(240, 120).placeholder(R.drawable.heart).into(viewHolder.img);
            } else {
                Picasso.get().load(R.drawable.heart).into(viewHolder.img);
            }
        }
    }

    @Override
    public int getItemCount() {
        return galleryList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private ImageView img;

        public ViewHolder(View view) {
            super(view);

            title = view.findViewById(R.id.title);
            img = view.findViewById(R.id.img);
        }
    }

}
