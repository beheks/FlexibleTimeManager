package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import java.util.List;

public class Location {
    public static final String TABLE_NAME = "Location";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";

    long mId;
    String mName;

    private List<Rule> mRules;
    private List<Task> mTasks;
}
