package xyz.felipearaujo.flexibletimemanager.injection.module;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;

@Module
public class CommonModule {
    private static Application sApplication;

    public CommonModule(Application app) {
        sApplication = app;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return sApplication;
    }

    @Provides
    @Singleton
    DataSource provideDataSource() {
        return null;
    }
}
