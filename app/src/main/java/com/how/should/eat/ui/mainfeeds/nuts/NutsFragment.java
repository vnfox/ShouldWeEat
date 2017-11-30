package com.how.should.eat.ui.mainfeeds.nuts;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.how.should.eat.R;
import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.di.component.ActivityComponent;
import com.how.should.eat.ui.base.BaseFragment;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NutsFragment extends BaseFragment implements
        NutsView, NutsAdapter.Callback, NutsAdapter.onItemListener {

    public static final String TAG = NutsFragment.class.getSimpleName();

    @Inject
    NutsMvpPresenter<NutsView> mPresenter;

    @Inject
    NutsAdapter mNutsAdapter;

    @Inject
    LinearLayoutManager mLayoutManager;

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;

    public static NutsFragment newInstance() {
        Bundle args = new Bundle();
        NutsFragment fragment = new NutsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nut, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
            mNutsAdapter.setCallback(this);
            mNutsAdapter.setOnListener(this);
        }
        return view;
    }

    @Override
    protected void setUp(View view) {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mNutsAdapter);

        mPresenter.onViewPrepared();
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
    public void updateData(List<FoodResponse.Food> blogList) {
        mNutsAdapter.addItems(blogList);
    }

    @Override
    public void onItemClick() {
        Toast.makeText(getActivity(), "Item Click", Toast.LENGTH_LONG).show();
    }
}
