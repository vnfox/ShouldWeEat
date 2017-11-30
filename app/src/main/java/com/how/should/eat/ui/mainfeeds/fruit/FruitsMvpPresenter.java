package com.how.should.eat.ui.mainfeeds.fruit;

import com.how.should.eat.ui.base.MvpPresenter;
import com.how.should.eat.ui.feed.blogs.BlogMvpView;

public interface FruitsMvpPresenter<V extends FruitsView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}