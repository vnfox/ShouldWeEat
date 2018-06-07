/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package com.how.should.eat.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.how.should.eat.data.network.model.BlogResponse;
import com.how.should.eat.data.network.model.OpenSourceResponse;
import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.di.ActivityContext;
import com.how.should.eat.ui.about.AboutMvpView;
import com.how.should.eat.ui.details.DetailsPresenter;
import com.how.should.eat.ui.details.DetailsPresenterImpl;
import com.how.should.eat.ui.details.DetailsView;
import com.how.should.eat.ui.feed.FeedMvpPresenter;
import com.how.should.eat.ui.feed.FeedPagerAdapter;
import com.how.should.eat.ui.feed.blogs.BlogMvpPresenter;
import com.how.should.eat.ui.feed.opensource.OpenSourceAdapter;
import com.how.should.eat.ui.feed.opensource.OpenSourceMvpPresenter;
import com.how.should.eat.ui.feed.opensource.OpenSourceMvpView;
import com.how.should.eat.ui.mainfeeds.MainPagerAdapter;
import com.how.should.eat.ui.mainfeeds.fish.FishAdapter;
import com.how.should.eat.ui.mainfeeds.fish.FishMvpPresenter;
import com.how.should.eat.ui.mainfeeds.fish.FishPresenter;
import com.how.should.eat.ui.mainfeeds.fish.FishView;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsAdapter;
import com.how.should.eat.ui.mainfeeds.MainFeedPresenter;
import com.how.should.eat.ui.mainfeeds.MainFeedPresenterImpl;
import com.how.should.eat.ui.mainfeeds.MainFeedView;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsMvpPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsPresenter;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsView;
import com.how.should.eat.ui.mainfeeds.meat.MeatAdapter;
import com.how.should.eat.ui.mainfeeds.meat.MeatMvpPresenter;
import com.how.should.eat.ui.mainfeeds.meat.MeatPresenter;
import com.how.should.eat.ui.mainfeeds.meat.MeatView;
import com.how.should.eat.ui.mainfeeds.nuts.NutsAdapter;
import com.how.should.eat.ui.mainfeeds.nuts.NutsMvpPresenter;
import com.how.should.eat.ui.mainfeeds.nuts.NutsPresenter;
import com.how.should.eat.ui.mainfeeds.nuts.NutsView;
import com.how.should.eat.ui.mainfeeds.vegetables.VegetablesAdapter;
import com.how.should.eat.ui.mainfeeds.vegetables.VegetablesMvpPresenter;
import com.how.should.eat.ui.mainfeeds.vegetables.VegetablesPresenter;
import com.how.should.eat.ui.mainfeeds.vegetables.VegetablesView;
import com.how.should.eat.ui.menu.MainMenuPresenterImpl;
import com.how.should.eat.ui.menu.MainMenuView;
import com.how.should.eat.ui.menu.MainMenuPresenter;
import com.how.should.eat.ui.menu.rating.RatingDialogMvpPresenter;
import com.how.should.eat.di.PerActivity;
import com.how.should.eat.ui.about.AboutMvpPresenter;
import com.how.should.eat.ui.about.AboutPresenter;
import com.how.should.eat.ui.feed.FeedMvpView;
import com.how.should.eat.ui.feed.FeedPresenter;
import com.how.should.eat.ui.feed.blogs.BlogAdapter;
import com.how.should.eat.ui.feed.blogs.BlogMvpView;
import com.how.should.eat.ui.feed.blogs.BlogPresenter;
import com.how.should.eat.ui.feed.opensource.OpenSourcePresenter;
import com.how.should.eat.ui.login.LoginMvpPresenter;
import com.how.should.eat.ui.login.LoginMvpView;
import com.how.should.eat.ui.login.LoginPresenter;
import com.how.should.eat.ui.menu.rating.RatingDialogMvpView;
import com.how.should.eat.ui.menu.rating.RatingDialogPresenter;
import com.how.should.eat.ui.splash.SplashMvpPresenter;
import com.how.should.eat.ui.splash.SplashMvpView;
import com.how.should.eat.ui.splash.SplashPresenter;
import com.how.should.eat.utils.rx.AppSchedulerProvider;
import com.how.should.eat.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    SplashMvpPresenter<SplashMvpView> provideSplashPresenter(
            SplashPresenter<SplashMvpView> presenter) {
        return presenter;
    }

    @Provides
    AboutMvpPresenter<AboutMvpView> provideAboutPresenter(
            AboutPresenter<AboutMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    LoginMvpPresenter<LoginMvpView> provideLoginPresenter(
            LoginPresenter<LoginMvpView> presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainMenuPresenter<MainMenuView> provideMainPresenter(
            MainMenuPresenterImpl<MainMenuView> presenter) {
        return presenter;
    }

    @Provides
    RatingDialogMvpPresenter<RatingDialogMvpView> provideRateUsPresenter(
            RatingDialogPresenter<RatingDialogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedMvpPresenter<FeedMvpView> provideFeedPresenter(
            FeedPresenter<FeedMvpView> presenter) {
        return presenter;
    }

    @Provides
    OpenSourceMvpPresenter<OpenSourceMvpView> provideOpenSourcePresenter(
            OpenSourcePresenter<OpenSourceMvpView> presenter) {
        return presenter;
    }

    @Provides
    BlogMvpPresenter<BlogMvpView> provideBlogMvpPresenter(
            BlogPresenter<BlogMvpView> presenter) {
        return presenter;
    }

    @Provides
    FeedPagerAdapter provideFeedPagerAdapter(AppCompatActivity activity) {
        return new FeedPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    OpenSourceAdapter provideOpenSourceAdapter() {
        return new OpenSourceAdapter(new ArrayList<OpenSourceResponse.Repo>());
    }

    @Provides
    BlogAdapter provideBlogAdapter() {
        return new BlogAdapter(new ArrayList<BlogResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }

    //Main Feeds
    @Provides
    MainPagerAdapter provideMainPagerAdapter(AppCompatActivity activity) {
        return new MainPagerAdapter(activity.getSupportFragmentManager());
    }

    @Provides
    MainFeedPresenter<MainFeedView> provideMainFeedPresenter(
            MainFeedPresenterImpl<MainFeedView> presenter) {
        return presenter;
    }

    @Provides
    FruitsAdapter provideMainFeedAdapter() {
        return new FruitsAdapter(new ArrayList<FoodResponse.Food>());
    }

    @Provides
    VegetablesMvpPresenter<VegetablesView> provideVegetablesPresenter(
            VegetablesPresenter<VegetablesView> presenter) {
        return presenter;
    }

    @Provides
    VegetablesAdapter provideVegetablesAdapter() {
        return new VegetablesAdapter(new ArrayList<FoodResponse.Food>());
    }

    @Provides
    FruitsMvpPresenter<FruitsView> provideFruitsPresenter(
            FruitsPresenter<FruitsView> presenter) {
        return presenter;
    }

    @Provides
    MeatAdapter provideMeatAdapter() {
        return new MeatAdapter(new ArrayList<FoodResponse.Food>());
    }

    @Provides
    MeatMvpPresenter<MeatView> provideMeatPresenter(
            MeatPresenter<MeatView> presenter) {
        return presenter;
    }

    @Provides
    FishAdapter provideFishAdapter() {
        return new FishAdapter(new ArrayList<FoodResponse.Food>());
    }

    @Provides
    FishMvpPresenter<FishView> provideFishPresenter(
            FishPresenter<FishView> presenter) {
        return presenter;
    }

    @Provides
    NutsAdapter provideNutsAdapter() {
        return new NutsAdapter(new ArrayList<FoodResponse.Food>());
    }

    @Provides
    NutsMvpPresenter<NutsView> provideNutsPresenter(
            NutsPresenter<NutsView> presenter) {
        return presenter;
    }

    //Details
    @Provides
    DetailsPresenter<DetailsView> provideDetailsPresenter(
            DetailsPresenterImpl<DetailsView> presenter) {
        return presenter;
    }
}