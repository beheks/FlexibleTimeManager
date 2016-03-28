package xyz.felipearaujo.flexibletimemanager.entities;

/**
 * Created by tatianaschmidt on 3/28/16.
 */
public class RuleGeolocation implements Rule{
    long latitude;
    long longitude;

    int radius;

    @Override
    public void obey() {

    }
}
