package xyz.felipearaujo.flexibletimemanager.injection;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import xyz.felipearaujo.flexibletimemanager.FlexibleTimeManager;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.injection.DataSourceModule;

@Singleton
@Component(modules = {ApplicationModule.class, DataSourceModule.class})
public interface ApplicationComponent {
    void inject(FlexibleTimeManager flexibleTimeManger);

    DataSource dataSource();
    Application application();
}
