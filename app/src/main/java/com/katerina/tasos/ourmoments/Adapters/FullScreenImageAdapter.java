package com.katerina.tasos.ourmoments.Adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler;
import com.katerina.tasos.ourmoments.Objects.Images;
import com.katerina.tasos.ourmoments.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FullScreenImageAdapter extends PagerAdapter {

    int pos;
    private Activity activity;
    private ArrayList<Images> images;
    private LayoutInflater inflater;

    // constructor
    public FullScreenImageAdapter(Activity activity, ArrayList<Images> imagesArrayList, int pos) {
        this.activity = activity;
        this.images = imagesArrayList;
        this.pos = pos;
    }

    @Override
    public int getCount() {
        return this.images.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((RelativeLayout) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView imgDisplay;

        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View viewLayout = inflater.inflate(R.layout.layout_fullscreen_image, container, false);

        imgDisplay = (ImageView) viewLayout.findViewById(R.id.imgDisplay);
        imgDisplay.setOnTouchListener(new ImageMatrixTouchHandler(activity));

        Picasso.with(activity).load(images.get(pos).getCloudLink()).placeholder(R.drawable.heart).into(imgDisplay);

        ((ViewPager) container).addView(viewLayout);

        return viewLayout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager) container).removeView((RelativeLayout) object);

    }
}