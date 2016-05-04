package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import android.database.Cursor;

import rx.functions.Func1;

public abstract class Rule {

    public enum RuleType {
        LOCATION(0),
        START(1),
        END(2);

        private final int value;

        RuleType(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private long mId;

    public long mId() {
        return mId;
    }

    public Func1<Cursor, Rule> MAPPER;

    abstract void obey();
}
