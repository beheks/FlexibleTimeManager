package xyz.felipearaujo.flexibletimemanager.usecase;

import com.google.android.gms.maps.model.LatLng;

import javax.inject.Inject;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.injection.BackgroundThread;
import xyz.felipearaujo.flexibletimemanager.injection.ForegroundThread;

public final class CreateLocation extends UseCase {
    private String mName;
    private LatLng mPosition;
    private DataSource mDataSource;

    public CreateLocation(String name,
                          LatLng position,
                          DataSource dataSource,
                          BackgroundThread bgThread,
                          ForegroundThread fgThread) {
        super(bgThread, fgThread);
        mName = name;
        mPosition = position;
        mDataSource = dataSource;
    }

    @Override
    protected Observable buildUseCase() {
        return mDataSource.createLocation(mName, mPosition);
    }
}
