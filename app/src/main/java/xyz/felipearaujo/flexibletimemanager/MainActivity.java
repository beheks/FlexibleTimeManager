package xyz.felipearaujo.flexibletimemanager;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.android.gms.maps.model.LatLng;

import xyz.felipearaujo.flexibletimemanager.activity.LocationItemAdapter;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View contentView = (View) findViewById(R.id.content_view);

        // Set up Location view
        mRecyclerView = (RecyclerView) contentView.findViewById(R.id.locations_grid);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // set adapter
        Location[] locations = generateFakeLocations();
        mAdapter = new LocationItemAdapter(locations);
        mRecyclerView.setAdapter(mAdapter);

        // Action to add a new Location
        FloatingActionButton addLocationfab = (FloatingActionButton) findViewById(R.id.fab);
        addLocationfab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Create Location", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private Location[] generateFakeLocations() {
        Location[] locations = new Location[5];
        for (int i = 0; i < 5; i++) {
            Location temp = new Location("Localidade 1", new LatLng(123.2, -123.2), 5);
            locations[i] = temp;
        }
        return locations;
    }
}
