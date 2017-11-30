package com.how.should.eat.ui.mainfeeds.fruit;

import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.ui.base.MvpView;

import java.util.List;

public interface FruitsView extends MvpView {

    void updateData(List<FoodResponse.Food> blogList);
}