package com.how.should.eat.ui.mainfeeds.nuts;

import com.androidnetworking.error.ANError;
import com.how.should.eat.data.DataManager;
import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.ui.base.BasePresenter;
import com.how.should.eat.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;

public class NutsPresenter<V extends NutsView> extends BasePresenter<V>
        implements NutsMvpPresenter<V> {

    @Inject
    public NutsPresenter(DataManager dataManager,
                         SchedulerProvider schedulerProvider,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onViewPrepared() {
        getMvpView().showLoading();
        getCompositeDisposable().add(getDataManager()
                .getNewsNutsApiCall()
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(new Consumer<FoodResponse>() {
                    @Override
                    public void accept(@NonNull FoodResponse foodResponse)
                            throws Exception {
                        if (foodResponse != null && foodResponse.getData() != null) {
                            getMvpView().updateData(foodResponse.getData());
                        }
                        getMvpView().hideLoading();
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable)
                            throws Exception {
                        if (!isViewAttached()) {
                            return;
                        }

                        getMvpView().hideLoading();

                        // handle the error here
                        if (throwable instanceof ANError) {
                            ANError anError = (ANError) throwable;
                            handleApiError(anError);
                        }
                    }
                }));
    }
}
