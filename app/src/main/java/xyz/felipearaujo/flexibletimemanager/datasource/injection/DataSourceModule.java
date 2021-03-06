package xyz.felipearaujo.flexibletimemanager.datasource.injection;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.FileDataSource;

@Module
public class DataSourceModule {

    @Provides
    @Singleton
    DataSource provideDataSource(Application application) {
        return new FileDataSource(application.getApplicationContext());
    }
}
