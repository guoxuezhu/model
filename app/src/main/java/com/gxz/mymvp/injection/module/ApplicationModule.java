package com.gxz.mymvp.injection.module;

import android.accounts.AccountManager;
import android.app.Application;
import android.content.Context;

import com.gxz.mymvp.net.MvpService;
import com.gxz.mymvp.injection.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Provide application-level dependencies. Mainly singleton object that can be injected from
 * anywhere in the app.
 */
@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }


    @Provides
    @Singleton
    MvpService provideWiscService() {
        return MvpService.Factory.makeRibotService(mApplication);
    }

    @Provides
    AccountManager provideAccountManager() {
        return AccountManager.get(mApplication);
    }

}
