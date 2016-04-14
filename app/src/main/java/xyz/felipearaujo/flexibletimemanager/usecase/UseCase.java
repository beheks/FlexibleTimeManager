package xyz.felipearaujo.flexibletimemanager.usecase;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

public abstract class UseCase {
    /**
     * Thread in which the {@link rx.Observable} will be executed
     */
    private Scheduler mExecutionThread;

    /**
     * Thread in which the {@link rx.Subscriber} will be executed
     */
    private Scheduler mResultThread;

    /**
     * Subscriber that's requesting the data
     */
    private Subscription mSubscription;

    protected UseCase(Scheduler executionThread, Scheduler resultThread) {
        mExecutionThread = executionThread;
        mResultThread = resultThread;
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
                .subscribeOn(mExecutionThread)
                .observeOn(mResultThread)
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