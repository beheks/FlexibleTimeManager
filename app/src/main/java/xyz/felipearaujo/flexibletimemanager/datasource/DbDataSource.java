package xyz.felipearaujo.flexibletimemanager.datasource;

import android.support.annotation.NonNull;

import com.squareup.sqlbrite.BriteDatabase;

import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.dao.LocationDao;
import xyz.felipearaujo.flexibletimemanager.datasource.dao.TaskDao;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

public class DbDataSource implements DataSource {
    @Inject BriteDatabase db;

    public DbDataSource() {
    }

    @Override
    public Observable<Task> getTask(long id) {
        return null;
    }

    @Override
    public Observable<List<Task>> getTasks(@NonNull long[] ids) {
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
    public Observable<Task> deleteTask(long id) {
        return null;
    }

    @Override
    public Observable<List<Task>> deleteTasks(@NonNull long[] ids) {
        return null;
    }

    @Override
    public Observable<List<Task>> deleteAllTasks() {
        return null;
    }

    @Override
    public Observable<Location> getLocation(long id) {
        return null;
    }

    @Override
    public Observable<List<Location>> getLocations() {
        return null;
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
    public Observable<Location> addLocation(@NonNull Task task) {
        return null;
    }

    @Override
    public Observable<List<Location>> addLocations(@NonNull List<Task> tasks) {
        return null;
    }

    @Override
    public Observable<Location> deleteLocation(long id) {
        return null;
    }

    @Override
    public Observable<List<Location>> deleteLocations(@NonNull long[] ids) {
        return null;
    }

    @Override
    public Observable<List<Location>> deleteAllLocations() {
        return null;
    }
}
