package xyz.felipearaujo.flexibletimemanager.datasource.entities;

public class RuleGeolocation implements Rule {
    long latitude;
    long longitude;

    int radius;

    @Override
    public void obey() {

    }
}
