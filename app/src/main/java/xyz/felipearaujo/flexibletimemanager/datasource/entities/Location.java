package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.Column;
import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

import java.util.List;

@ObjectMappable
public class Location {
    public static final String TABLE_NAME = "Location";
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_RULE_GEOLOCATION = "rule_geolocation";

    @Column(COL_ID) long mId;
    @Column(COL_NAME) String mName;

    public String getName() {
        return mName;
    }

    public void setName(String mName) {
        this.mName = mName;
    }

    private List<Rule> mRules;
    private List<Task> mTasks;
}
