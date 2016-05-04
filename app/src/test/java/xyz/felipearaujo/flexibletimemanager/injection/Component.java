package xyz.felipearaujo.flexibletimemanager.injection;

import javax.inject.Singleton;

import xyz.felipearaujo.flexibletimemanager.DataSourceTest;
import xyz.felipearaujo.flexibletimemanager.ExampleUnitTest;

@Singleton
@dagger.Component(modules = {Module.class, ApplicationModule.class})
public interface Component {
}
