package com.katerina.tasos.ourmoments.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.katerina.tasos.ourmoments.DatabaseHandler;
import com.katerina.tasos.ourmoments.R;

public class MainActivity extends AppCompatActivity {

    DatabaseHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DatabaseHandler(this);
        initializeDatabase();
        dbHandler.close();

    }

    public void ChangeActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, ImagesActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

    public void initializeDatabase() {
        this.deleteDatabase("imagesManager");

    }
}