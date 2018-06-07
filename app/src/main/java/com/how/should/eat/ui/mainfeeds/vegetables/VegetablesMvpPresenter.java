package com.how.should.eat.ui.mainfeeds.vegetables;

import com.how.should.eat.ui.base.MvpPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsView;

public interface VegetablesMvpPresenter<V extends VegetablesView>
        extends MvpPresenter<V> {

    void onViewPrepared();
}


