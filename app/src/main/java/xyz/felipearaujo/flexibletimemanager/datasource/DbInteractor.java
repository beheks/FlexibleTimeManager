package xyz.felipearaujo.flexibletimemanager.datasource;

import android.database.Cursor;

public final class DbInteractor {
    public static long getLong(Cursor cursor, String columnName) {
        return cursor.getLong(cursor.getColumnIndexOrThrow(columnName));
    }

    public static String getString(Cursor cursor, String columnName) {
        return cursor.getString(cursor.getColumnIndexOrThrow(columnName));
    }
}
