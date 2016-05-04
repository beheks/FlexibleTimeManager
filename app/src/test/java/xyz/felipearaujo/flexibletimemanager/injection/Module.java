package xyz.felipearaujo.flexibletimemanager.injection;

import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.sqlbrite.BriteDatabase;
import com.squareup.sqlbrite.SqlBrite;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javax.inject.Singleton;

import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.FileDataSource;

@dagger.Module
public class Module {

    public Module() {
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
    DataSource provideDataSource(Gson gson, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        return new FileDataSource(gson, bufferedWriter, bufferedReader);
    }


    @Provides
    @Singleton
    BriteDatabase provideBriteDabase(SQLiteOpenHelper helper, BackgroundThread bgThread) {
        return SqlBrite.create().wrapDatabaseHelper(helper, bgThread.getScheduler());
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder().create();
    }

    @Provides
    @Singleton
    BufferedWriter provideStreamWriter() {
        try {
            return new BufferedWriter(new FileWriter(new File("location")));
        }
        catch (Exception f) {
            f.printStackTrace();
        }

        return null;
    }

    @Provides
    @Singleton
    BufferedReader provideStreamReader() {
        try {
            return new BufferedReader(new FileReader(new File("location")));
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
