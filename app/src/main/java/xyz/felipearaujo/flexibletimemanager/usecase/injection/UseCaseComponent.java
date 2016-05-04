package xyz.felipearaujo.flexibletimemanager.usecase.injection;

import dagger.Component;
import xyz.felipearaujo.flexibletimemanager.injection.ApplicationComponent;
import xyz.felipearaujo.flexibletimemanager.usecase.GetLocation;
import xyz.felipearaujo.flexibletimemanager.usecase.GetTask;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = UseCaseModule.class)
public interface UseCaseComponent {
    GetTask getTask();
    GetLocation getLocation();
}
