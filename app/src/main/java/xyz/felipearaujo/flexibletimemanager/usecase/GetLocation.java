package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.injection.BackgroundThread;
import xyz.felipearaujo.flexibletimemanager.injection.ForegroundThread;

public final class GetLocation extends UseCase {

    private String id;
    private DataSource mDataSource;

    public GetLocation(String id,
                       DataSource dataSource,
                       BackgroundThread bgThread,
                       ForegroundThread fgThread) {
        super(bgThread, fgThread);
        this.id = id;
        this.mDataSource = dataSource;
    }

    @Override
    protected Observable buildUseCase() {
        return mDataSource.getLocation(this.id);
    }
}