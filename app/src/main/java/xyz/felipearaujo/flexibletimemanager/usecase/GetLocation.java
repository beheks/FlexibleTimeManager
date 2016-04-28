package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;
import rx.Scheduler;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;

public class GetLocation extends UseCase {
    @Inject DataSource dataSource;
    private int id;

    public GetLocation(int id) {
        super();
        this.id = id;
    }

    @Override
    protected Observable buildUseCase() {
        return dataSource.getLocation(this.id);
    }
}