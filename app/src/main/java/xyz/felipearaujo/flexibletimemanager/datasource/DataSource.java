package xyz.felipearaujo.flexibletimemanager.datasource;

import android.support.annotation.NonNull;

import com.google.android.gms.maps.model.LatLng;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

public interface DataSource {
    /* Tasks */
    Observable<Task> getTask(String id);
    Observable<List<Task>> getTasks(@NonNull String[] ids);
    Observable<List<Task>> getAllTasks();

    Observable<Boolean> updateTask(@NonNull Task task);
    Observable<Boolean> updateTasks(@NonNull List<Task> tasks);

    Observable<Task> addTask(@NonNull Task task);
    Observable<List<Task>> addTasks(@NonNull List<Task> tasks);

    Observable<Task> deleteTask(String id);
    Observable<List<Task>> deleteTasks(@NonNull String[] ids);
    Observable<List<Task>> deleteAllTasks();

    /* Locations */
    Observable<Location> getLocation(String id);
    Observable<List<Location>> getLocations();

    Observable<Boolean> updateLocation(@NonNull Task task);
    Observable<Boolean> updateLocations(@NonNull List<Task> tasks);

    Observable<Location> createLocation(@NonNull String name, @NonNull LatLng position);

    Observable<Location> deleteLocation(String id);
    Observable<List<Location>> deleteLocations(@NonNull String[] ids);
    Observable<List<Location>> deleteAllLocations();
}
