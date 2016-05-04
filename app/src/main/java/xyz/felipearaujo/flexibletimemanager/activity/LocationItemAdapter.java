package xyz.felipearaujo.flexibletimemanager.activity;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import xyz.felipearaujo.flexibletimemanager.R;
import xyz.felipearaujo.flexibletimemanager.datasource.entities.Location;

public class LocationItemAdapter extends RecyclerView.Adapter<LocationItemAdapter.ViewHolder> {

    private final Location[] mLocations;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    public LocationItemAdapter(Location[] locations) {
        mLocations = locations;
    }

    @Override
    public LocationItemAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.location_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(LocationItemAdapter.ViewHolder holder, int position) {
        TextView locationTitle = (TextView) holder.mView.findViewById(R.id.location_title);
        locationTitle.setText(/*mLocations[position].getName()*/ "Oi");
    }

    @Override
    public int getItemCount() {
        return mLocations.length;
    }
}
