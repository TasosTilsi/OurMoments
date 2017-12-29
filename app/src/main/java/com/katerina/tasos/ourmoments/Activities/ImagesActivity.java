package com.katerina.tasos.ourmoments.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.katerina.tasos.ourmoments.Adapters.CustomAdapter;
import com.katerina.tasos.ourmoments.DatabaseHandler;
import com.katerina.tasos.ourmoments.Objects.Images;
import com.katerina.tasos.ourmoments.R;

import java.util.ArrayList;

/**
 * Created by tasos on 20/10/2017.
 */

public class ImagesActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        dbHandler = new DatabaseHandler(this);
        ArrayList<Images> imagesArrayList = new ArrayList<>();
        imagesArrayList.addAll(dbHandler.getAllImages());

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.imageGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);


        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), imagesArrayList /*list here */);
        recyclerView.setAdapter(adapter);


    }


}
