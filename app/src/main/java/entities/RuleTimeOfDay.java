package entities;

/**
 * Created by tatianaschmidt on 3/28/16.
 */
public class RuleTimeOfDay implements Rule {
    // TODO: melhorar representacao de hora do dia.
    int afterHour;
    int afterMinute;
    int beforeHour;
    int beforeMinute;

    @Override
    public void obey() {

    }
}
