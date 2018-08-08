package com.katerina.tasos.ourmoments;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.katerina.tasos.ourmoments.Objects.Images;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tilsakos on 6/11/2017.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "imagesManager";

    // Contacts table name
    private static final String TABLE_IMAGES = "images";

    // Contacts Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String KEY_LINK = "link";
    private static final String KEY_THUMB = "thumb";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_IMAGES + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
                + KEY_LINK + " TEXT," + KEY_THUMB + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_IMAGES);

        // Create tables again
        onCreate(db);
    }

    // Adding new image
    public void addImage(Images image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, String.valueOf(image.getName())); // Image Name
        values.put(KEY_LINK, image.getCloudLink()); // Image Phone Number
        values.put(KEY_THUMB, image.getThumbLink());

        // Inserting Row
        db.insert(TABLE_IMAGES, null, values);
        db.close(); // Closing database connection
    }

    public void addImageWithoutThumb(Images image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, String.valueOf(image.getName())); // Image Name
        values.put(KEY_LINK, image.getCloudLink()); // Image Phone Number

        // Inserting Row
        db.insert(TABLE_IMAGES, null, values);
        db.close(); // Closing database connection
    }

    // Getting single image
    public Images getImage(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_IMAGES, new String[]{KEY_ID,
                        KEY_NAME, KEY_LINK}, KEY_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Images image = new Images(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2), cursor.getString(3));
        // return image
        return image;
    }

    // Getting All images
    public List<Images> getAllImages() {
        List<Images> imagesList = new ArrayList<Images>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_IMAGES;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Images image = new Images();
                image.setId(Integer.parseInt(cursor.getString(0)));
                image.setName(cursor.getString(1));
                image.setCloudLink(cursor.getString(2));
                image.setThumbLink(cursor.getString(3));
                // Adding contact to list
                imagesList.add(image);
            } while (cursor.moveToNext());
        }

        // return contact list
        return imagesList;
    }

    // Getting image Count
    public int getImagesCount() {
        String countQuery = "SELECT  * FROM " + TABLE_IMAGES;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }

    // Updating single image
    public int updateImage(Images image) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, image.getName());
        values.put(KEY_LINK, image.getCloudLink());
        values.put(KEY_THUMB, image.getThumbLink());

        // updating row
        return db.update(TABLE_IMAGES, values, KEY_ID + " = ?",
                new String[]{String.valueOf(image.getId())});
    }

    // Deleting single image
    public void deleteImage(Images image) {
        // Deleting single contact
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_IMAGES, KEY_ID + " = ?",
                new String[]{String.valueOf(image.getId())});
        db.close();
    }


}
