package net.rafaeltoledo.daggertest;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application {

    MainComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        if (component == null) component = DaggerMainComponent.create();
    }

    public static MainComponent getComponent(Context context) {
        return ((MainApplication) context.getApplicationContext()).getComponent();
    }

    public MainComponent getComponent() {
        return component;
    }

    public void setComponent(MainComponent component) {
        this.component = component;
    }
}
