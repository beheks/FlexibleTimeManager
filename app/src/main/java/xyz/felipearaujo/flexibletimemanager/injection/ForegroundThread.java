package xyz.felipearaujo.flexibletimemanager.injection;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

public final class ForegroundThread implements Thread {
    public ForegroundThread() {
    }

    @Override
    public Scheduler getScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
