package com.how.should.eat.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.how.should.eat.R;
import com.how.should.eat.data.network.model.BlogResponse;
import com.how.should.eat.di.component.ActivityComponent;
import com.how.should.eat.ui.base.BaseFragment;
import com.how.should.eat.ui.details.DetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainFeedFragment extends BaseFragment implements
        MainFeedView, MainFeedAdapter.Callback, MainFeedAdapter.onItemListener {

    public static final String TAG = MainFeedFragment.class.getSimpleName();

    @Inject
    MainFeedPresenter<MainFeedView> mPresenter;

    @Inject
    MainFeedAdapter mBlogAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.blog_recycler_view)
    RecyclerView mRecyclerView;

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
        View view = inflater.inflate(R.layout.fragment_blog, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mBlogAdapter.setCallback(this);
            mBlogAdapter.setOnListener(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mBlogAdapter);

        mPresenter.onViewPrepared();
    }

    @Override
    public void onBlogEmptyViewRetryClick() {

    }

    @Override
    public void updateBlog(List<BlogResponse.Blog> blogList) {
        mBlogAdapter.addItems(blogList);
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

    @Override
    public void onItemClick() {
        //Shoe details screen
        startActivity(DetailsActivity.getStartIntent(getActivity()));
    }
}
