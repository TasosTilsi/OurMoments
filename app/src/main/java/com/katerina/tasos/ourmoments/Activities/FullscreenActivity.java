package com.katerina.tasos.ourmoments.Activities;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.katerina.tasos.ourmoments.Adapters.FullScreenImageAdapter;
import com.katerina.tasos.ourmoments.DatabaseHandler;
import com.katerina.tasos.ourmoments.Objects.Images;
import com.katerina.tasos.ourmoments.R;

import java.util.ArrayList;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class FullscreenActivity extends AppCompatActivity {
    ViewPager pager;
    FullScreenImageAdapter adapter;
    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);
        pager = (ViewPager) findViewById(R.id.pager);

        dbHandler = new DatabaseHandler(this);
        ArrayList<Images> imagesArrayList = new ArrayList<>();
        imagesArrayList.addAll(dbHandler.getAllImages());
        dbHandler.close();

        adapter = new FullScreenImageAdapter(this, imagesArrayList, getIntent().getIntExtra("position", 0));
        pager.setAdapter(adapter);
    }


}
