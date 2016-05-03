package xyz.felipearaujo.flexibletimemanager.datasource;

import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

public final class FileDataSource implements DataSource {
    private Gson mSerializer;
    private BufferedWriter mWriter;
    private BufferedReader mReader;

    List<Location> mLocations;

    /**
     * CONSIDER REPLACING LIST BY RX.SUBJECT
     */
    @Inject
    public FileDataSource(Context context) {
        mSerializer = new GsonBuilder().create();

        try {
            mWriter = new BufferedWriter(new OutputStreamWriter(context
                    .openFileOutput("locations", Context.MODE_PRIVATE)));

            mReader = new BufferedReader(new InputStreamReader(
                    context.openFileInput("locations"), "UTF-8"));
        } catch (FileNotFoundException|UnsupportedEncodingException e) {
            e.printStackTrace();
            System.exit(1);
        }

        mLocations = mSerializer.fromJson(mReader, new TypeToken<ArrayList<Location>>(){}.getType());
    }

    @Override
    public Observable<Task> getTask(String id) {
        return null;
    }

    @Override
    public Observable<List<Task>> getTasks(@NonNull String[] ids) {
        return null;
    }

    @Override
    public Observable<List<Task>> getAllTasks() {
        return null;
    }

    @Override
    public Observable<Boolean> updateTask(@NonNull Task task) {
        return null;
    }

    @Override
    public Observable<Boolean> updateTasks(@NonNull List<Task> tasks) {
        return null;
    }

    @Override
    public Observable<Task> addTask(@NonNull Task task) {
        return null;
    }

    @Override
    public Observable<List<Task>> addTasks(@NonNull List<Task> tasks) {
        return null;
    }

    @Override
    public Observable<Task> deleteTask(String id) {
        return null;
    }

    @Override
    public Observable<List<Task>> deleteTasks(@NonNull String[] ids) {
        return null;
    }

    @Override
    public Observable<List<Task>> deleteAllTasks() {
        return null;
    }

    @Override
    public Observable<Location> getLocation(String id) {
        return null;
    }

    @Override
    public Observable<List<Location>> getLocations() {
        return Observable.just(mLocations);
    }

    @Override
    public Observable<Boolean> updateLocation(@NonNull Task task) {
        return null;
    }

    @Override
    public Observable<Boolean> updateLocations(@NonNull List<Task> tasks) {
        return null;
    }

    @Override
    public Observable<Location> createLocation(@NonNull String name, @NonNull LatLng position) {
        Location newLocation = new Location(name, position);
        mLocations.add(newLocation);

        return Observable.just(newLocation);
    }

    @Override
    public Observable<Location> deleteLocation(String id) {
        return null;
    }

    @Override
    public Observable<List<Location>> deleteLocations(@NonNull String[] ids) {
        return null;
    }

    @Override
    public Observable<List<Location>> deleteAllLocations() {
        return null;
    }
}
