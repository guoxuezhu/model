package com.gxz.mymvp.injection.component;

import com.gxz.mymvp.injection.PerActivity;
import com.gxz.mymvp.injection.module.ActivityModule;
import com.gxz.mymvp.ui.main.MainActivity;
import com.gxz.mymvp.ui.splash.SplashActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(SplashActivity splashActivity);

    void inject(MainActivity mainActivity);
}

