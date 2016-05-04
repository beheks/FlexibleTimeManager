package xyz.felipearaujo.flexibletimemanager;


import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import javax.inject.Inject;

import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;
import xyz.felipearaujo.flexibletimemanager.injection.DaggerComponent;
import xyz.felipearaujo.flexibletimemanager.injection.Module;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class ExampleUnitTest {
    @Inject
    BufferedWriter out;

    @Inject
    BufferedReader input;

    @Inject
    Gson gson;

    Location baseline;

    @Before
    public void setup() {
        /*DaggerComponent
            .builder()
            .module(new Module())
            .build()
            .inject(this);*/
        try {
            out.write(gson.toJson(new Location("0", "name", new LatLng(0.0, 0.0), 0, 0)));
            out.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

        baseline = new Location("0", "name", new LatLng(0.0, 0.0), 0, 0);
    }

    @Test
    public void input_and_output() throws Exception {
        out.write("ok");
        out.flush();

        assertTrue(input.readLine().equals("ok"));
    }
}