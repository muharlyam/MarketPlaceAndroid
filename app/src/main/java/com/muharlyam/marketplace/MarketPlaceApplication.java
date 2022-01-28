package com.muharlyam.marketplace;

import android.app.Application;

import com.muharlyam.marketplace.dagger.component.ApplicationComponent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.inject.Inject;

public class MarketPlaceApplication extends Application {
    private static ApplicationComponent applicationComponent;

    private static final ExecutorService executorService = Executors.newCachedThreadPool();

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = buildComponent();

        applicationComponent.inject(this);
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    public ApplicationComponent buildComponent() {
        return ApplicationComponent.Initializer.init();
    }

    public static ExecutorService getExecutorService() {
        return executorService;
    }
}
