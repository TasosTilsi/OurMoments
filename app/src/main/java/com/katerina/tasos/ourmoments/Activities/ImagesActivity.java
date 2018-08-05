package com.katerina.tasos.ourmoments.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

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
    CustomAdapter adapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);

        gridView = (GridView) findViewById(R.id.imageGallery);

        dbHandler = new DatabaseHandler(this);
        ArrayList<Images> imagesArrayList = new ArrayList<>();
        imagesArrayList.addAll(dbHandler.getAllImages());
        dbHandler.close();

        /*RecyclerView recyclerView = (RecyclerView) findViewById(R.id.imageGallery);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 3);
        recyclerView.setLayoutManager(layoutManager);

        CustomAdapter adapter = new CustomAdapter(getApplicationContext(), imagesArrayList *//*list here *//*);
        recyclerView.setAdapter(adapter);*/


        adapter = new CustomAdapter(this, imagesArrayList);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(ImagesActivity.this, FullscreenActivity.class);
                i.putExtra("position", position);
                ImagesActivity.this.startActivity(i);
            }
        });

    }


}
