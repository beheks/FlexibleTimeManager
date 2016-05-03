package xyz.felipearaujo.flexibletimemanager;

import android.app.Application;

import xyz.felipearaujo.flexibletimemanager.datasource.injection.DataSourceModule;
import xyz.felipearaujo.flexibletimemanager.injection.ApplicationModule;
import xyz.felipearaujo.flexibletimemanager.injection.ApplicationComponent;
import xyz.felipearaujo.flexibletimemanager.injection.DaggerApplicationComponent;

public class FlexibleTimeManager extends Application {
    private static ApplicationComponent sApplicationComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        sApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataSourceModule(new DataSourceModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
