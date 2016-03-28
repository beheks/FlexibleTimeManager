package xyz.felipearaujo.flexibletimemanager.repository;

import java.util.List;

import rx.Observable;
import xyz.felipearaujo.flexibletimemanager.entities.Location;

public interface LocationRepository {
    public Observable<List<Location>> getLocations();
    public Observable<Location> getLocation(int id);
}

