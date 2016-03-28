package xyz.felipearaujo.flexibletimemanager.usecase;

import rx.Observable;
import rx.Scheduler;
import rx.Subscriber;
import rx.Subscription;

public abstract class UseCase {
    /**
     * Thread in which the {@link rx.Observable} will be executed
     */
    private Scheduler executionThread;

    /**
     * Thread in which the {@link rx.Subscriber} will be executed
     */
    private Scheduler resultThread;

    private Subscription subscription;

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
        this.subscription = this.buildUseCase()
                .subscribeOn(executionThread)
                .observeOn(resultThread)
                .subscribe(subscriber);
    }

    /**
     * Stop listening to the current usecase
     */
    public void unsubscribe() {
        if(!this.subscription.isUnsubscribed()) {
            this.subscription.unsubscribe();
        }
    }
}