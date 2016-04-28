package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import android.database.Cursor;

import rx.functions.Func1;

public abstract class Rule {
    private long mId;

    public long mId() {
        return mId;
    }

    public Func1<Cursor, Rule> MAPPER;

    abstract void obey();
}
