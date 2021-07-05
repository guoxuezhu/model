package com.gxz.mymvp;

import android.app.Application;
import android.content.Context;

import com.gxz.mymvp.injection.component.ApplicationComponent;
import com.gxz.mymvp.injection.component.DaggerApplicationComponent;
import com.gxz.mymvp.injection.module.ApplicationModule;

public class MvpApplication extends Application {

    private ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setupComponent();

    }
    private void setupComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
    }

    public static MvpApplication get(Context context) {
        return (MvpApplication) context.getApplicationContext();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }


}
