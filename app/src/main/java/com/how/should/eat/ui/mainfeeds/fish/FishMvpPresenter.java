package com.how.should.eat.ui.mainfeeds.fish;

import com.how.should.eat.ui.base.MvpPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsView;

public interface FishMvpPresenter<V extends FishView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


