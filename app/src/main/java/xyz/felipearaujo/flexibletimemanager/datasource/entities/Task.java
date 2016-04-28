package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import android.database.Cursor;
import android.os.Parcelable;

import com.google.auto.value.AutoValue;

import java.util.ArrayList;
import java.util.List;

import rx.functions.Func1;
import xyz.felipearaujo.flexibletimemanager.datasource.DbInteractor;

@AutoValue
public abstract class Task implements Parcelable{
    public static final String TABLE_NAME = "Task";
    public static final String COL_NAME = "name";
    public static final String COL_ELAPSED_TIME = "elapsed_time";
    public static final String COL_TARGET_TIME = "target_time";
    public static final String COL_ID = "id";

    public static final Func1<Cursor, Task> MAPPER = new Func1<Cursor, Task>() {
        @Override public Task call(Cursor cursor) {
            long id = DbInteractor.getLong(cursor, COL_ID);
            String name = DbInteractor.getString(cursor, COL_NAME);
            long elapsedTime = DbInteractor.getLong(cursor, COL_ELAPSED_TIME);
            long targetTime = DbInteractor.getLong(cursor, COL_TARGET_TIME);
            List<Rule> rules = new ArrayList<>();

            return new AutoValue_Task(id, name, elapsedTime, targetTime, rules);
        }
    };

    public abstract long mId();
    public abstract String mName();
    public abstract long mElapsedTime();
    public abstract long mTargetTime();
    public abstract List<Rule> mRules();
}