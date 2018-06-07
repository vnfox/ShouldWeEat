package com.how.should.eat.ui.mainfeeds.nuts;

import com.how.should.eat.ui.base.MvpPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsView;

public interface NutsMvpPresenter<V extends NutsView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}