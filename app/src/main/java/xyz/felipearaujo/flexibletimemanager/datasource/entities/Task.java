package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import android.os.Parcelable;

import java.util.List;


public abstract class Task implements Parcelable{
    public abstract long mId();
    public abstract String mName();
    public abstract long mElapsedTime();
    public abstract long mTargetTime();
    public abstract List<Rule> mRules();
}