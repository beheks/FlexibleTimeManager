package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;

public class GetTask extends UseCase {
    @Inject DataSource dataSource;
    private int id;

    public GetTask(int id) {
        this.id = id;
    }

    protected Observable buildUseCase() {
        return dataSource.getTask(this.id);
    }
}
