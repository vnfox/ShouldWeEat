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

package com.how.should.eat.ui.mainfeeds.fruit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.how.should.eat.R;
import com.how.should.eat.data.network.model.feed.FoodResponse;
import com.how.should.eat.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FruitsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;
    public static final int VIEW_TYPE_NORMAL = 1;

    private onItemListener mListener;
    private Callback mCallback;
    private List<FoodResponse.Food> mBlogResponseList;

    public FruitsAdapter(List<FoodResponse.Food> blogResponseList) {
        mBlogResponseList = blogResponseList;
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    public void setOnListener(onItemListener listener) {
        mListener = listener;
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                return new ViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feed_view, parent, false));
            case VIEW_TYPE_EMPTY:
            default:
                return new EmptyViewHolder(
                        LayoutInflater.from(parent.getContext()).inflate(R.layout.item_empty_view, parent, false));
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public int getItemCount() {
        if (mBlogResponseList != null && mBlogResponseList.size() > 0) {
            return mBlogResponseList.size();
        } else {
            return 1;
        }
    }

    public void addItems(List<FoodResponse.Food> blogList) {
        mBlogResponseList.addAll(blogList);
        notifyDataSetChanged();
    }

    public interface Callback {
        void onBlogEmptyViewRetryClick();
    }

    public interface onItemListener {
        void onItemClick();
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.cover_image_view)
        ImageView coverImageView;

        @BindView(R.id.title_text_view)
        TextView titleTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        protected void clear() {
            coverImageView.setImageDrawable(null);
            titleTextView.setText("");
        }

        public void onBind(int position) {
            super.onBind(position);

            final FoodResponse.Food blog = mBlogResponseList.get(position);

                if (blog.getCoverImgUrl() != null) {
                    Glide.with(itemView.getContext())
                            .load(blog.getCoverImgUrl())
                        .asBitmap()
                        .centerCrop()
                        .into(coverImageView);
            }

            if (blog.getTitle() != null) {
                titleTextView.setText(blog.getTitle());
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClick();
                }
            });
        }
    }

    public class EmptyViewHolder extends BaseViewHolder {

        @BindView(R.id.btn_retry)
        Button retryButton;

        @BindView(R.id.tv_message)
        TextView messageTextView;

        public EmptyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        @OnClick(R.id.btn_retry)
        void onRetryClick() {
            if (mCallback != null)
                mCallback.onBlogEmptyViewRetryClick();
        }
    }
}
