package com.gxz.mymvp.ui.splash;

import com.gxz.mymvp.ui.base.Presenter;

public class SplashPresenter implements Presenter<SplashMvpView> {
    private SplashMvpView sMvpView;

//    private MvpClient mvpClient;
//
//    @Inject
//    public SplashPresenter(MvpClient client) {
//        this.mvpClient = client;
//    }

    @Override
    public void attachView(SplashMvpView mvpView) {
        sMvpView = mvpView;
    }

    @Override
    public void detachView() {
        sMvpView = null;
    }

    public boolean hasValidUserStored() {
        return true;
    }
}
