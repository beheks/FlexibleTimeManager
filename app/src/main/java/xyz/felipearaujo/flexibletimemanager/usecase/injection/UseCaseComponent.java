package xyz.felipearaujo.flexibletimemanager.usecase.injection;

import javax.inject.Named;

import dagger.Component;
import xyz.felipearaujo.flexibletimemanager.injection.ApplicationComponent;
import xyz.felipearaujo.flexibletimemanager.usecase.CreateLocation;
import xyz.felipearaujo.flexibletimemanager.usecase.GetLocation;
import xyz.felipearaujo.flexibletimemanager.usecase.GetTask;
import xyz.felipearaujo.flexibletimemanager.usecase.UseCase;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = UseCaseModule.class)
public interface UseCaseComponent {

}
