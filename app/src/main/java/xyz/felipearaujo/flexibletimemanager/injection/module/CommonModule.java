package xyz.felipearaujo.flexibletimemanager.injection.module;

import android.app.Application;
import android.database.sqlite.SQLiteOpenHelper;

import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import xyz.felipearaujo.flexibletimemanager.datasource.DbOpenHelper;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.DbDataSource;

@Module
public class CommonModule {
    private static Application sApplication;
    private static Scheduler sBackgroundTask;
    private static Scheduler sForegroundTask;

    public CommonModule(Application app, Scheduler backgroundTask, Scheduler foregroundTask) {
        sApplication = app;
        sBackgroundTask = backgroundTask;
        sForegroundTask = foregroundTask;
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
    BriteDatabase provideBriteDabase(SQLiteOpenHelper helper) {
        return SqlBrite.create().wrapDatabaseHelper(helper, sBackgroundTask);
    }
}
