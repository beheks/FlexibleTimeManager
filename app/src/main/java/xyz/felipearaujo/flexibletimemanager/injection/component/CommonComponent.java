package xyz.felipearaujo.flexibletimemanager.injection.component;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Component;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.injection.module.CommonModule;

@Singleton
@Component(modules = CommonModule.class)
public interface CommonComponent {
    Application getApplication();
    DataSource getDataSource();
}
