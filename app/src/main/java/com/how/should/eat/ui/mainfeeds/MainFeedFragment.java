package com.how.should.eat.ui.mainfeeds;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.how.should.eat.R;
import com.how.should.eat.di.component.ActivityComponent;
import com.how.should.eat.ui.base.BaseFragment;
import com.how.should.eat.ui.details.DetailsActivity;
import com.how.should.eat.ui.mainfeeds.fruit.FruitsAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFeedFragment extends BaseFragment implements
        MainFeedView, FruitsAdapter.Callback, FruitsAdapter.onItemListener {

    public static final String TAG = MainFeedFragment.class.getSimpleName();

    @Inject
    MainFeedPresenter<MainFeedView> mPresenter;

    @Inject
    MainPagerAdapter mPagerAdapter;

    @BindView(R.id.feed_view_pager)
    ViewPager mViewPager;

    @BindView(R.id.tab_layout)
    TabLayout mTabLayout;

    public static MainFeedFragment newInstance() {
        Bundle args = new Bundle();
        MainFeedFragment fragment = new MainFeedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main_feed, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        //Tab layout
        mPagerAdapter.setCount(5);
        mViewPager.setAdapter(mPagerAdapter);

        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tab_fruit)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tab_vegetables)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tab_meat)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tab_fish)));
        mTabLayout.addTab(mTabLayout.newTab().setText(getString(R.string.tab_nut)));

        mViewPager.setOffscreenPageLimit(mTabLayout.getTabCount());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));

        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onBlogEmptyViewRetryClick() {

    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onItemClick() {
        //Show details screen
        startActivity(DetailsActivity.getStartIntent(getActivity()));
    }
}
