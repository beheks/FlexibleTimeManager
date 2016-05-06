package xyz.felipearaujo.flexibletimemanager.datasource.entities;

import com.google.android.gms.maps.model.LatLng;

import java.util.UUID;

public class Location {
    private String mId;
    private String mName;
    private LatLng mPosition;

    private int mFenceRadiusMeters;
    private long mTimeSpent;
    private long mLatestEntryTime;

    private boolean mIsActive;

    public Location() {
        this("New Location", new LatLng(0.0, 0.0));
    }

    public Location(String name, LatLng position) {
        this(name, position, 100);
    }

    public Location(String name, LatLng position, int fenceRadiusMeters) {
        this(UUID.randomUUID().toString(), name, position, fenceRadiusMeters, 0, 0);
    }

    public Location(String id,
                    String name,
                    LatLng position,
                    int fenceRadiusMeters,
                    int timeSpent,
                    int latestEntryTime) {
        mId = id;
        mName = name;
        mPosition = position;
        mFenceRadiusMeters = fenceRadiusMeters;
        mTimeSpent = timeSpent;
        mLatestEntryTime = latestEntryTime;
    }

    public String getName() {
        return mName;
    }

    public int getFenceRadiusMeters() {
        return mFenceRadiusMeters;
    }

    public void setFenceRadiusMeters(int fenceRadiusMeters) {
        mFenceRadiusMeters = fenceRadiusMeters;
    }

    public long getTimeSpent() {
        return mTimeSpent;
    }

    public void setTimeSpent(long timeSpent) {
        mTimeSpent = timeSpent;
    }

    public long getLatestEntryTime() {
        return mLatestEntryTime;
    }

    public void setLatestEntryTime(long latestEntryTime) {
        mLatestEntryTime = latestEntryTime;
    }

    public LatLng getPosition() {
        return mPosition;
    }

    public void setPosition(LatLng position) {
        mPosition = position;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public boolean isActive() {
        return mIsActive;
    }

    public void setActive(boolean active) {
        mIsActive = active;
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
