package xyz.felipearaujo.flexibletimemanager;

import android.app.Application;

import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import xyz.felipearaujo.flexibletimemanager.injection.component.CommonComponent;
import xyz.felipearaujo.flexibletimemanager.injection.component.DaggerCommonComponent;
import xyz.felipearaujo.flexibletimemanager.injection.module.CommonModule;

public class FlexibleTimeManager extends Application {
    private static CommonComponent sCommonComponent;
    @Override
    public void onCreate() {
        super.onCreate();

        sCommonComponent = DaggerCommonComponent.builder()
                .commonModule(new CommonModule(
                        this,
                        Schedulers.io(),
                        AndroidSchedulers.mainThread()))
                .build();
    }

    public static CommonComponent getsCommonComponent() {
        return sCommonComponent;
    }
}
