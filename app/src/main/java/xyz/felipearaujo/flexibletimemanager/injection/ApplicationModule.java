package xyz.felipearaujo.flexibletimemanager.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.FileDataSource;

@Module
public class ApplicationModule {
    private static Context sContext;

    public ApplicationModule(Application app) {
        sContext = app.getApplicationContext();
    }

    @Provides
    @Singleton
    BackgroundThread provideBackgroundTask(BackgroundThread backgroundThread) {
        return backgroundThread;
    }

    @Provides
    @Singleton
    ForegroundThread provideForegroundTask(ForegroundThread foregroundThread) {
        return foregroundThread;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return sContext;
    }
}
