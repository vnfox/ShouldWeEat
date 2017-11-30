package com.how.should.eat.data.network;

import com.how.should.eat.data.network.model.BlogResponse;
import com.how.should.eat.data.network.model.LoginResponse;
import com.how.should.eat.data.network.model.LogoutResponse;
import com.how.should.eat.data.network.model.OpenSourceResponse;
import com.how.should.eat.data.network.model.LoginRequest;
import com.how.should.eat.data.network.model.feed.FoodResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<LogoutResponse> doLogoutApiCall();

    Observable<BlogResponse> getBlogApiCall();

    Observable<OpenSourceResponse> getOpenSourceApiCall();

    Observable<FoodResponse> getNewFruitsApiCall();

    Observable<FoodResponse> getNewVegetablesApiCall();

    Observable<FoodResponse> getNewMeatApiCall();

    Observable<FoodResponse> getNewsFishApiCall();

    Observable<FoodResponse> getNewsNutsApiCall();
}
