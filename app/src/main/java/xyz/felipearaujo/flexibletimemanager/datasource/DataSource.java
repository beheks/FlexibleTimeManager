package xyz.felipearaujo.flexibletimemanager.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

public interface DataSource {
    /* Tasks */
    Observable<Task> getTask(long id);
    Observable<List<Task>> getTasks(@NonNull long[] ids);
    Observable<List<Task>> getAllTasks();

    Observable<Boolean> updateTask(@NonNull Task task);
    Observable<Boolean> updateTasks(@NonNull List<Task> tasks);

    Observable<Task> addTask(@NonNull Task task);
    Observable<List<Task>> addTasks(@NonNull List<Task> tasks);

    Observable<Task> deleteTask(long id);
    Observable<List<Task>> deleteTasks(@NonNull long[] ids);
    Observable<List<Task>> deleteAllTasks();

    /* Locations */
    Observable<Location> getLocation(long id);
    Observable<List<Location>> getLocations();

    Observable<Boolean> updateLocation(@NonNull Task task);
    Observable<Boolean> updateLocations(@NonNull List<Task> tasks);

    Observable<Location> addLocation(@NonNull Task task);
    Observable<List<Location>> addLocations(@NonNull List<Task> tasks);

    Observable<Location> deleteLocation(long id);
    Observable<List<Location>> deleteLocations(@NonNull long[] ids);
    Observable<List<Location>> deleteAllLocations();
}
