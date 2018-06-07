package com.how.should.eat.ui.mainfeeds;

import com.how.should.eat.data.DataManager;
import com.how.should.eat.ui.base.BasePresenter;
import com.how.should.eat.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class MainFeedPresenterImpl<V extends MainFeedView> extends BasePresenter<V>
        implements MainFeedPresenter<V> {

    @Inject
    public MainFeedPresenterImpl(DataManager dataManager,
                                 SchedulerProvider schedulerProvider,
                                 CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }
}
