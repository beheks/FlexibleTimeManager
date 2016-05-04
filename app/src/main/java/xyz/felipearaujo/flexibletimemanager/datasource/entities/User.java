package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import java.util.List;

public class User {
    public static final String TABLE_NAME = "User";
    public static final String COL_NAME = "name";

    long id;
    String name;

    List<Location> locationList;
}
