package xyz.felipearaujo.flexibletimemanager.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.FileDataSource;

@Module
public final class ApplicationModule {
    private static Application sApplication;

    public ApplicationModule(Application app) {
        sApplication = app;
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
    Application provideApplication() {
        return sApplication;
    }
}
