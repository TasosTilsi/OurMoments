package com.katerina.tasos.ourmoments.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.katerina.tasos.ourmoments.Objects.Images;
import com.katerina.tasos.ourmoments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by tasos on 18/10/2017.
 */

public class CustomAdapter extends ArrayAdapter<Images> {
    private ArrayList<Images> objects;
    private Context context;

    public CustomAdapter(Context context, ArrayList<Images> objects) {
        super(context, 0, objects);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        final ViewHolder holder;

        Images image = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
            holder = new ViewHolder();

            holder.image = (ImageView) convertView.findViewById(R.id.img);
            holder.image_textView = (TextView) convertView.findViewById(R.id.title);
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.item_progress_bar);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        // Lookup view for data population
        // Populate the data into the template view using the data object

        if (image != null) {
            holder.image_textView.setText(image.getName());
            if (image.getCloudLink() != null) {
                Picasso.with(getContext()).load(image.getCloudLink())/*.resize(240, 120)*/.into(holder.image, new com.squareup.picasso.Callback() {
                    @Override
                    public void onSuccess() {
                        holder.progressBar.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError() {

                    }
                });
            } else {
                holder.progressBar.setVisibility(View.GONE);
                holder.image.setImageResource(R.drawable.smallheart);
                //Picasso.with(getContext()).load(R.drawable.heart).into(holder.image);
            }
        }
        return convertView;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    static class ViewHolder {
        ImageView image;
        TextView image_textView;
        ProgressBar progressBar;
    }
}

/*
public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    private ArrayList<Images> galleryList;
    private Context context;

    public CustomAdapter(Context context, ArrayList<Images> galleryList) {
        this.galleryList = galleryList;
        this.context = context;
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.adapter_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder viewHolder, int i) {

        viewHolder.title.setText(galleryList.get(i).getName());
        final String t = galleryList.get(i).getName();
        if (galleryList.get(i) != null) {

            if (galleryList.get(i).getCloudLink().length() > 5) {
                Picasso.with(context).load(galleryList.get(i).getCloudLink()).resize(240, 120).placeholder(R.drawable.heart).into(viewHolder.img);
            } else {
                Picasso.with(context).load(R.drawable.heart).into(viewHolder.img);
            }
        }

        viewHolder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, t, Toast.LENGTH_SHORT).show();
            }
        });
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

}*/
