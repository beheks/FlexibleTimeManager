package xyz.felipearaujo.flexibletimemanager.datasource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

public final class DbOpenHelper extends SQLiteOpenHelper {
    public static final int VERSION = 1;

    public static final String CREATE_LOCATION = ""
            + "CREATE TABLE " + Location.TABLE_NAME + "("
            + Location.COL_ID + " INTEGER NOT NULL PRIMARY KEY,"
            + Location.COL_NAME + " TEXT NOT NULL"
            + ")";

    public static final String CREATE_TASK = ""
            + "CREATE TABLE " + Task.TABLE_NAME
            + Task.COL_ID + " INTEGER NOT NULL PRIMARY KEY,"
            + Task.COL_TARGET_TIME + " INTEGER NOT NULL DEFAULT 0,"
            + Task.COL_ELAPSED_TIME + " INTEGER NOT NULL DEFAULT 0,"
            + Task.COL_NAME + " TEXT NOT NULL"
            + ")";

    public DbOpenHelper(Context context) {
        super(context, "xyz.felipearaujo.flexibletimemanager.db", null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* add mock */
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
