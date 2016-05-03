package xyz.felipearaujo.flexibletimemanager.usecase.injection;

import com.google.android.gms.maps.model.LatLng;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import xyz.felipearaujo.flexibletimemanager.usecase.GetLocation;
import xyz.felipearaujo.flexibletimemanager.usecase.UseCase;

@Module
public class UseCaseModule {
    private String mId;
    private LatLng mPosition;
    private String mName;

    public UseCaseModule() {
    }

    public UseCaseModule(String id) {
        this.mId = id;
    }

    public UseCaseModule(String name, LatLng position) {
        this.mName = name;
        this.mPosition = position;
    }

    @Named("getLocation")
    @PerActivity
    @Provides
    public UseCase provideGetLocation(GetLocation getLocation) {
        return getLocation;
    }
}
