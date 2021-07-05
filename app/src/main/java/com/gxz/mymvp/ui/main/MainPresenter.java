package com.gxz.mymvp.ui.main;

import com.gxz.mymvp.data.model.ZksDevice;
import com.gxz.mymvp.net.MvpClient;
import com.gxz.mymvp.ui.base.Presenter;
import com.gxz.mymvp.utils.ELog;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by guoxuezhu on 18-3-27.
 */
public class MainPresenter implements Presenter<MainMvpView> {

    private MainMvpView mMvpView;
    private MvpClient mvpClient;

    @Inject
    public MainPresenter(MvpClient client) {
        this.mvpClient = client;
    }

    @Override
    public void attachView(MainMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }


    public void getdevice() {
        mvpClient.deviceList()
                .map(listHttpResult -> listHttpResult.getData().getRows())
                .subscribe(new Observer<List<ZksDevice>>() {
                    @Override
                    public void onSubscribe(@NotNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NotNull List<ZksDevice> zksDevices) {
                        ELog.i("============列表======onNext=======" + zksDevices.toString());
                    }

                    @Override
                    public void onError(@NotNull Throwable e) {
                        ELog.i("============列表======onError=======" + e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
