package ru.stairenx.testappforsimaland;

import androidx.multidex.MultiDexApplication;

import ru.stairenx.testappforsimaland.di.components.ApplicationComponent;
import ru.stairenx.testappforsimaland.di.components.DaggerApplicationComponent;

public class AndroidApplication extends MultiDexApplication {

    private static ApplicationComponent instance;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        instance = DaggerApplicationComponent
                .builder()
                .application(this)
                .build();
        instance.inject(this);
    }

    public static ApplicationComponent getInstance() {
        return instance;
    }
}
