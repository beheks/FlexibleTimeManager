package xyz.felipearaujo.flexibletimemanager.injection.module;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DbOpenHelper;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.DbDataSource;
import xyz.felipearaujo.flexibletimemanager.injection.BackgroundThread;
import xyz.felipearaujo.flexibletimemanager.injection.ForegroundThread;
import xyz.felipearaujo.flexibletimemanager.usecase.GetTask;

@Module
public class CommonModule {
    private static Application sApplication;

    public CommonModule(Application app) {
        sApplication = app;
    }

    @Provides
    @Singleton
    BackgroundThread provideBackgroundTask() {
        return new BackgroundThread();
    }

    @Provides
    @Singleton
    ForegroundThread provideForegroundTask() {
        return new ForegroundThread();
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
    SQLiteOpenHelper provideOpenHelper(Application app) {
        return new DbOpenHelper(sApplication.getApplicationContext());
    }

    @Provides
    @Singleton
    BriteDatabase provideBriteDabase(SQLiteOpenHelper helper, BackgroundThread bgThread) {
        return SqlBrite.create().wrapDatabaseHelper(helper, bgThread.getScheduler());
    }
}
