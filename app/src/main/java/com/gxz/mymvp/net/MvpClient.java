package com.gxz.mymvp.net;


import com.gxz.mymvp.data.model.ZksDevice;
import com.gxz.mymvp.utils.ELog;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;


@Singleton
public class MvpClient {


    @SuppressWarnings("unchecked")
    private static ObservableTransformer schedulersTransformer = new ObservableTransformer() {
        @Override
        public ObservableSource apply(@NonNull Observable upstream) {
            return ((Observable<HttpResult>) upstream).subscribeOn(Schedulers.io())
                    .timeout(30, TimeUnit.SECONDS)
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext(httpResult -> {
                        if (!httpResult.flag.equals("1")) {
                            throw new RuntimeException(httpResult.msg);
                        }
                    });
        }
    };

    private MvpService mvpService;

    @Inject
    public MvpClient(MvpService mMvpService) {
        this.mvpService = mMvpService;
    }

    @SuppressWarnings("unchecked")
    private static <T> ObservableTransformer<T, T> applySchedulers() {
        return (ObservableTransformer<T, T>) schedulersTransformer;
    }

//
//    public void setLoginUser(User user) {
//        Gson gson = new Gson();
//        String str = gson.toJson(user, User.class);
//        MvpApplication.prefs.setUserString(str);
//        MvpService.Factory.setUser(user);
//    }
//
//    public boolean loadUserIfAvailble() {
//        String str = MvpApplication.prefs.getUserString();
//        Gson gson = new Gson();
//        User u = TextUtils.isEmpty(str) ? null : gson.fromJson(str, User.class);
//        if (null != u && u.isValid()) {
//            setLoginUser(u);
//            return true;
//        }
//        return false;
//    }


    public Observable<HttpResult<DatasResult<List<ZksDevice>>>> deviceList() {
        return mvpService.getDeviceData()
                .compose(this.<HttpResult<DatasResult<List<ZksDevice>>>>applySchedulers());
    }
}
