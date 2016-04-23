package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import com.hannesdorfmann.sqlbrite.objectmapper.annotation.ObjectMappable;

import java.util.List;

@ObjectMappable
public class User {
    public static final String TABLE_NAME = "User";
    public static final String COL_NAME = "name";

    long id;
    String name;

    List<Location> locationList;
}
