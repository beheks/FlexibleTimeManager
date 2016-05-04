package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.injection.BackgroundThread;
import xyz.felipearaujo.flexibletimemanager.injection.ForegroundThread;

public abstract class UseCase {
    /**
     * Thread in which the {@link rx.Observable} will be executed
     */
    BackgroundThread mBackgroundThread;

    /**
     * Thread in which the {@link rx.Subscriber} will be executed
     */
    ForegroundThread mForegroundThread;

    /**
     * Subscriber that's requesting the data
     */
    private Subscription mSubscription;

    protected UseCase(BackgroundThread bgThread, ForegroundThread fgThread) {
        mBackgroundThread = bgThread;
        mForegroundThread = fgThread;
    }

    /**
     * Build the {@link rx.Observable} to be executed when the {@link UseCase} runs
     * @return Observable that will be executed
     */
    protected abstract Observable buildUseCase();

    /**
     * Execute the usecase built in {@link #buildUseCase()}}
     * @param subscriber listener of the result
     */
    @SuppressWarnings("unchecked")
    public void execute(Subscriber subscriber) {
        this.mSubscription = this.buildUseCase()
                .subscribeOn(mBackgroundThread.getScheduler())
                .observeOn(mForegroundThread.getScheduler())
                .subscribe(subscriber);
    }

    /**
     * Stop listening to the current usecase
     */
    public void unsubscribe() {
        if(!this.mSubscription.isUnsubscribed()) {
            this.mSubscription.unsubscribe();
        }
    }
}