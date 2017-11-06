package com.katerina.tasos.ourmoments;

import android.content.Context;
import android.util.Log;

import com.katerina.tasos.ourmoments.Objects.Images;

import java.util.List;

/**
 * Created by tasos on 18/10/2017.
 */

public class CreateList {

    DatabaseHandler db;
    private String image_title;
    private Integer image_id;
    private Images image;

    public String getImage_title() {
        return image_title;
    }

    public void setImage_title(String android_version_name) {
        this.image_title = android_version_name;
    }

    public Integer getImage_ID() {
        return image_id;
    }

    public void setImage_ID(Integer android_image_url) {
        this.image_id = android_image_url;
    }

    /**
     * CRUD Operations
     */
    // Inserting images
    public void insertImagesToDatabase(Context context) {
        db = new DatabaseHandler(context);
        Log.d("Insert: ", "Inserting ..");
        db.addImage(new Images("img1", "path1"));
        db.addImage(new Images("img2", "path2"));
        db.addImage(new Images("img3", "path3"));
    }

    // Reading all contacts
    public void readImagesToConsole(Context context) {
        Log.d("Reading: ", "Reading all contacts..");
        db = new DatabaseHandler(context);
        List<Images> imagesList = db.getAllImages();

        for (Images image : imagesList) {
            String log = "Id: " + image.getId() + " ,Name: " + image.getName() + " ,Phone: " + image.getCloudLink();
            // Writing Contacts to log
            Log.d("Name: ", log);
        }

    }
}