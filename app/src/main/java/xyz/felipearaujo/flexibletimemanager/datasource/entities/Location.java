package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

public class Location {
    private String mId;
    private String mName;
    private LatLng mPosition;
    private int mFenceRadiusMeters;
    private int mTimeSpent;

    public Location() {
        this("New Location", new LatLng(0.0, 0.0));
    }

    public Location(String name, LatLng position) {
        this(name, position, 100);
    }

    public Location(String name, LatLng position, int fenceRadiusMeters) {
        this(UUID.randomUUID().toString(), name, position, fenceRadiusMeters, 0);
    }

    public Location(String id, String name, LatLng position, int fenceRadiusMeters, int timeSpent) {
        mId = id;
        mName = name;
        mPosition = position;
        mFenceRadiusMeters = fenceRadiusMeters;
        mTimeSpent = timeSpent;
    }

    public String getName() {
        return mName;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o.getClass().equals(this.getClass()))) return false;

        Location l = (Location) o;
        return (

            (l.mTimeSpent == this.mTimeSpent) &&
            (l.mFenceRadiusMeters == this.mFenceRadiusMeters) &&
            (l.mPosition.equals(this.mPosition)) &&
            (l.mId.equals(this.mId)) &&
            (l.mName.equals(this.mName))

        );
    }
}
