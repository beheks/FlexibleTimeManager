package xyz.felipearaujo.flexibletimemanager.datasource.dao;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.hannesdorfmann.sqlbrite.dao.Dao;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

@SuppressWarnings("unchecked")
public class LocationDao extends Dao {
    @Override
    public void createTable(SQLiteDatabase db) {
        CREATE_TABLE(Location.TABLE_NAME,
                Location.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1",
                Location.COL_NAME + " TEXT"
        ).execute(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Observable<Location> getLocation(long id) {
        return null;
    }

    public Observable<List<Location>> getLocations() {
        return null;
    }

    public Observable<Boolean> updateLocation(@NonNull Task task) {
        return null;
    }

    public Observable<Boolean> updateLocations(@NonNull List<Task> tasks) {
        return null;
    }

    public Observable<Location> addLocation(@NonNull Task task) {
        return null;
    }

    public Observable<List<Location>> addLocations(@NonNull List<Task> tasks) {
        return null;
    }

    public Observable<Location> deleteLocation(long id) {
        return null;
    }

    public Observable<List<Location>> deleteLocations(@NonNull long[] ids) {
        return null;
    }

    public Observable<List<Location>> deleteAllLocations() {
        return null;
    }
}
