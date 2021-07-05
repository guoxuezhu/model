package com.gxz.mymvp.injection.component;

import android.app.Application;
import android.content.Context;

import com.gxz.mymvp.net.MvpClient;
import com.gxz.mymvp.injection.ApplicationContext;
import com.gxz.mymvp.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    void inject(Application application);

    @ApplicationContext
    Context context();

    Application application();

    MvpClient mvpClient();

}
