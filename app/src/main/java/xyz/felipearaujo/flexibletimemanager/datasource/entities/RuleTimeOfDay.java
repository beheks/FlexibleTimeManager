package xyz.felipearaujo.flexibletimemanager.datasource.entities;

public class RuleTimeOfDay extends Rule {
    // TODO: melhorar representacao de hora do dia.
    int afterHour;
    int afterMinute;
    int beforeHour;
    int beforeMinute;

    @Override
    public void obey() {

    }
}
