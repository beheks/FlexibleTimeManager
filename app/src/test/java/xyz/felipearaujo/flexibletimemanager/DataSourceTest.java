package xyz.felipearaujo.flexibletimemanager;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;
import xyz.felipearaujo.flexibletimemanager.datasource.DataSource;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.injection.DaggerComponent;
import xyz.felipearaujo.flexibletimemanager.injection.Module;

import static org.junit.Assert.*;

public class DataSourceTest {
    @Inject
    DataSource mDataSource;

    @Inject
    BufferedWriter out;

    @Inject
    Gson gson;

    Location baseline;
    Location baseline2;

    @Before
    public void setup() {
        DaggerComponent
                .builder()
                .module(new Module())
                .build()
                .inject(this);
        try {
            List<Location> l = new ArrayList<>();
            l.add( new Location("0", "name", new LatLng(0.0, 0.0), 0, 0) );
            l.add( new Location("1", "name", new LatLng(0.0, 0.0), 0, 0) );

            out.write(gson.toJson(l));
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        baseline = new Location("0", "name", new LatLng(0.0, 0.0), 0, 0);
        baseline2 = new Location("1", "name", new LatLng(0.0, 0.0), 0, 0);
    }

    @Test
    public void getLocations() throws Exception {
        mDataSource.getLocations().subscribe(new Subscriber<List<Location>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Location> locations) {
                assertTrue(locations.get(0).equals(baseline) && locations.get(1).equals(baseline2));
            }
        });
    }
}
