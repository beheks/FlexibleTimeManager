package xyz.felipearaujo.flexibletimemanager.datasource;

import android.support.annotation.NonNull;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.entities.Location;
import xyz.felipearaujo.flexibletimemanager.entities.Task;

public interface DataSource {
    /* Tasks */
    Observable<Task> getTask(int id);
    Observable<List<Task>> getTasks(int[] ids);
    Observable<List<Task>> getAllTasks();

    Observable<Boolean> updateTask(@NonNull Task task);
    Observable<Boolean> updateTasks(@NonNull List<Task> tasks);

    Observable<Task> addTask(@NonNull Task task);
    Observable<List<Task>> addTasks(@NonNull List<Task> tasks);

    Observable<Task> deleteTask(int id);
    Observable<List<Task>> deleteTasks(@NonNull int[] ids);
    Observable<List<Task>> deleteAllTasks();

    /* Locations */
    Observable<Task> getLocation(int id);
    Observable<List<Task>> getLocations();

    Observable<Boolean> updateLocation(@NonNull Task task);
    Observable<Boolean> updateLocations(@NonNull List<Task> tasks);

    Observable<Task> addLocation(@NonNull Task task);
    Observable<List<Task>> addLocations(@NonNull List<Task> tasks);

    Observable<Task> deleteLocation(int id);
    Observable<List<Task>> deleteLocations(@NonNull int[] ids);
    Observable<List<Task>> deleteAllLocations();
}
