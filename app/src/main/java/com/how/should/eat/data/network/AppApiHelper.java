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

package com.how.should.eat.data.network;

import com.how.should.eat.data.network.model.BlogResponse;
import com.how.should.eat.data.network.model.LogoutResponse;
import com.how.should.eat.data.network.model.OpenSourceResponse;
import com.how.should.eat.data.network.model.LoginRequest;
import com.how.should.eat.data.network.model.LoginResponse;
import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

@Singleton
public class AppApiHelper implements ApiHelper {

    private ApiHeader mApiHeader;

    @Inject
    public AppApiHelper(ApiHeader apiHeader) {
        mApiHeader = apiHeader;
    }

    @Override
    public ApiHeader getApiHeader() {
        return mApiHeader;
    }

    @Override
    public Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest
                                                                  request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_GOOGLE_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest
                                                                    request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_FACEBOOK_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest
                                                                  request) {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
                .addHeaders(mApiHeader.getPublicApiHeader())
                .addBodyParameter(request)
                .build()
                .getObjectObservable(LoginResponse.class);
    }

    @Override
    public Observable<LogoutResponse> doLogoutApiCall() {
        return Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_LOGOUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(LogoutResponse.class);
    }

    @Override
    public Observable<BlogResponse> getBlogApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_BLOG)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(BlogResponse.class);
    }

    @Override
    public Observable<OpenSourceResponse> getOpenSourceApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_OPEN_SOURCE)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(OpenSourceResponse.class);
    }

    @Override
    public Observable<FoodResponse> getNewFruitsApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_FRUIT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(FoodResponse.class);
    }

    @Override
    public Observable<FoodResponse> getNewVegetablesApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_VEGETABLES)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(FoodResponse.class);
    }

    @Override
    public Observable<FoodResponse> getNewMeatApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MEAT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(FoodResponse.class);
    }

    @Override
    public Observable<FoodResponse> getNewsFishApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_FISH)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(FoodResponse.class);
    }

    @Override
    public Observable<FoodResponse> getNewsNutsApiCall() {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_NUT)
                .addHeaders(mApiHeader.getProtectedApiHeader())
                .build()
                .getObjectObservable(FoodResponse.class);
    }
}

