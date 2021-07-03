package com.gxz.mymvp.ui.main;

import com.gxz.mymvp.ui.base.Presenter;

/**
 * Created by guoxuezhu on 18-3-27.
 */
public class MainPresenter implements Presenter<MainMvpView> {

    private MainMvpView mMvpView;
//    private MvpClient mvpClient;
//
//    @Inject
//    public MainPresenter(MvpClient client) {
//        this.mvpClient = client;
//    }

    @Override
    public void attachView(MainMvpView mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void detachView() {
        mMvpView = null;
    }

//
//    public void getchools() {//教室列表
//        mvpClient.schoolList()
//                .doOnNext(listHttpResult -> {
//                    if (!listHttpResult.code.equals("200")) {
//                        throw Exceptions.propagate(new ClientRuntimeException(listHttpResult.code, listHttpResult.msg));
//                    }
//                })
//                .map(listHttpResult -> listHttpResult.getData())
//                .subscribe(new Observer<List<School>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(List<School> schools) {
//                        ELog.i("============学校列表======onNext=======" + schools.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        ELog.i("============学校列表======onError=======" + e.toString());
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//    }

}