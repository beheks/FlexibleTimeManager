package xyz.felipearaujo.flexibletimemanager.injection;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public final class BackgroundThread implements Thread {
    public BackgroundThread() {
    }

    public Scheduler getScheduler() {
        return Schedulers.io();
    }
}
