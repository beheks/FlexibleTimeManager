package xyz.felipearaujo.flexibletimemanager;

import android.app.Application;

import xyz.felipearaujo.flexibletimemanager.injection.component.CommonComponent;
import xyz.felipearaujo.flexibletimemanager.injection.component.DaggerCommonComponent;
import xyz.felipearaujo.flexibletimemanager.injection.module.CommonModule;

public class FlexibleTimeManager extends Application {
    private static CommonComponent sCommonComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        sCommonComponent = DaggerCommonComponent.builder()
                .commonModule(new CommonModule(this))
                .build();
    }

    public static CommonComponent getsCommonComponent() {
        return sCommonComponent;
    }
}
