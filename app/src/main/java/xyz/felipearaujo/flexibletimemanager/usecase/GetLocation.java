package xyz.felipearaujo.flexibletimemanager.usecase;

import rx.Observable;

public class GetLocation extends UseCase {
    private DataStore dataStore;
    private int id;

    public GetLocation(int id) {
        this.id = id;
    }

    @Override
    protected Observable buildUseCase() {
        return dataStore.getLocation(this.id);
    }
}
