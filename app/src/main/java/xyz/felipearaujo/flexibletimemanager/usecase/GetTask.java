package xyz.felipearaujo.flexibletimemanager.usecase;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.injection.BackgroundThread;
import xyz.felipearaujo.flexibletimemanager.injection.ForegroundThread;

public final class GetTask extends UseCase {
    DataSource mDataSource;
    private String mId;

    @Inject
    public GetTask(BackgroundThread bgThread,
                   ForegroundThread fgThread,
                   DataSource dataSource,
                   String id) {
        super(bgThread, fgThread);
        mDataSource = dataSource;
        this.mId = id;
    }

    protected Observable buildUseCase() {
        return mDataSource.getTask(this.mId);
    }
}
