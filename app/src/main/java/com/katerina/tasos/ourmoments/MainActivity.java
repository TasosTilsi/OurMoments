package com.katerina.tasos.ourmoments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ChangeActivity(View view) {
        Intent myIntent = new Intent(MainActivity.this, ImagesActivity.class);
        MainActivity.this.startActivity(myIntent);
    }
}