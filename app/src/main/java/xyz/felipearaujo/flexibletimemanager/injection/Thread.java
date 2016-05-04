package xyz.felipearaujo.flexibletimemanager.injection;

import rx.Scheduler;

interface Thread {
    Scheduler getScheduler();
}
