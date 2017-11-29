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

package com.how.should.eat.ui.details;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.graphics.Palette;
import android.widget.ImageView;

import com.how.should.eat.R;
import com.how.should.eat.ui.base.BaseActionBarActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsActivity extends BaseActionBarActivity implements DetailsView {

    @Inject
    DetailsPresenter<DetailsView> mPresenter;

    @BindView(R.id.moviePoster)
    ImageView mImgPoster;

    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        setUp();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        super.setUp();

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle("Details");

        //Set Color Toolbar
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
                R.mipmap.img_detail);

        Palette.from(bitmap).generate(new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                mCollapsingToolbarLayout.setContentScrimColor(palette.getMutedColor(R.attr.colorPrimary));
                mCollapsingToolbarLayout.setStatusBarScrimColor(palette.getMutedColor(R.attr.colorPrimaryDark));
            }
        });

        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }
}
