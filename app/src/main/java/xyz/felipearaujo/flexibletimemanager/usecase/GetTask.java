package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;

public class GetTask extends UseCase {
    @Inject private final DataStore dataStore;
    private int id;

    public GetTask(int id) {
        this.id = id;
    }

    protected Observable buildUseCase() {
        return dataStore.getTask(this.id);
    }
}
