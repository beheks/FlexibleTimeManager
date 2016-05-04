package xyz.felipearaujo.flexibletimemanager.injection;

import android.app.Application;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import javax.inject.Singleton;

import xyz.felipearaujo.flexibletimemanager.DataSourceTest;
import xyz.felipearaujo.flexibletimemanager.ExampleUnitTest;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;

@Singleton
@dagger.Component(modules = {Module.class, ApplicationModule.class})
public interface Component {
    void inject(ExampleUnitTest test);
    void inject(DataSourceTest test);

    Application application();
}
