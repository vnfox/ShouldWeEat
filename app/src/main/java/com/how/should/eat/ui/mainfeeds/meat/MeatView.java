package com.how.should.eat.ui.mainfeeds.meat;

import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.ui.base.MvpView;

import java.util.List;

public interface MeatView extends MvpView {

    void updateData(List<FoodResponse.Food> blogList);
}