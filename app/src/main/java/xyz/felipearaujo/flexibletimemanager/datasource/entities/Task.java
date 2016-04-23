package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

@ObjectMappable
public class Task {
    public static final String TABLE_NAME = "Task";
    public static final String COL_NAME = "name";
    public static final String COL_ELAPSED_TIME = "elapsed_time";
    public static final String COL_TARGET_TIME = "target_time";
    public static final String COL_ID = "id";

    @Column(COL_ID) long id;
    @Column(COL_NAME) String name;
    @Column(COL_ELAPSED_TIME) long elapsedTime;
    @Column(COL_TARGET_TIME) long targetTime;

    public Task() {
    }

    public Task(long id, String name, long elapsedTime, long targetTime) {
        this.id = id;
        this.name = name;
        this.elapsedTime = elapsedTime;
        this.targetTime = targetTime;
    }

}