package xyz.felipearaujo.flexibletimemanager.datasource.dao;

import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;

import com.hannesdorfmann.sqlbrite.dao.Dao;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Task;

@SuppressWarnings("unchecked")
public class TaskDao extends Dao {
    @Override
    public void createTable(SQLiteDatabase db) {
        CREATE_TABLE(Location.TABLE_NAME,
                Location.COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT DEFAULT 1 NOT NULL",
                Location.COL_NAME + " TEXT"
        ).execute(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public Observable<Task> getTask(long id) {
        return null;
    }

    public Observable<List<Task>> getTasks(@NonNull long[] ids) {
        return null;
    }

    public Observable<List<Task>> getAllTasks() {
        return null;
    }


    public Observable<Boolean> updateTask(@NonNull Task task) {
        return null;
    }

    public Observable<Boolean> updateTasks(@NonNull List<Task> tasks) {
        return null;
    }


    public  Observable<Task> addTask(@NonNull Task task) {
        return null;
    }

    public Observable<List<Task>> addTasks(@NonNull List<Task> tasks) {
        return null;
    }


    public Observable<Task> deleteTask(long id) {
        return null;
    }

    public Observable<List<Task>> deleteTasks(@NonNull long[] ids) {
        return null;
    }

    public Observable<List<Task>> deleteAllTasks() {
        return null;
    }
}
