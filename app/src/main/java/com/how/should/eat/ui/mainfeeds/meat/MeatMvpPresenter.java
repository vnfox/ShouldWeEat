package com.how.should.eat.ui.mainfeeds.meat;

import com.how.should.eat.ui.base.MvpPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsView;

public interface MeatMvpPresenter<V extends MeatView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


