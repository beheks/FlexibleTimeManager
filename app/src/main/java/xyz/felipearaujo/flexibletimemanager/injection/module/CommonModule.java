package xyz.felipearaujo.flexibletimemanager.injection.module;

import android.app.Application;

import com.hannesdorfmann.sqlbrite.dao.DaoManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.DbDataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.dao.LocationDao;
import xyz.felipearaujo.flexibletimemanager.datasource.dao.TaskDao;

@Module
public class CommonModule {
    private static Application sApplication;
    private static LocationDao sLocationDao;
    private static TaskDao sTaskDao;

    public CommonModule(Application app) {
        sTaskDao = new TaskDao();
        sLocationDao = new LocationDao();

        DaoManager
                .with(app.getApplicationContext())
                .databaseName("FlexibleTimeManager.db")
                .add(sTaskDao)
                .add(sLocationDao)
                .logging(true)
                .build();

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
        return new DbDataSource();
    }

    @Provides
    @Singleton
    LocationDao provideLocationDao() {
        return sLocationDao;
    }

    @Provides
    @Singleton
    TaskDao provideTaskDao() {
        return sTaskDao;
    }

}
