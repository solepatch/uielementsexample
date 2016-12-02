package com.soulpatch.uielementsexample.uielementsexample;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

/**
 * Base item for all list items to inherit from
 *
 * @author Akshay Viswanathan
 */
public class BaseListItem<T> implements IListItem<T> {
    private T mData;
    protected String mTitle;
    private BaseAdapter mArrayAdapter;
    private OnClickListener mOnClickListener;
    private boolean mClickable;

    public BaseListItem(final String title) {
        mTitle = title;
    }

    public BaseListItem(final String title, @NonNull final T data) {
        mTitle = title;
        mData = data;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewHolder createViewHolder(final LayoutInflater layoutInflater, final ViewGroup viewGroup) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bindViewHolder(final ViewHolder holder) {
        if (mOnClickListener != null) {
            holder.mRootView.setOnClickListener(new View.OnClickListener() {
                /**
                 * {@inheritDoc}
                 */
                @Override
                public void onClick(final View view) {
                    if (view instanceof ListView && ((ListView) view).getAdapter() instanceof ListArrayAdapter) {
                        mOnClickListener.onItemClicked(BaseListItem.this);
                    }
                }
            });
            holder.mRootView.setClickable(mClickable);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getTitle() {
        return mTitle;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setTitle(final String title) {
        mTitle = title;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAdapter(final BaseAdapter adapter) {
        mArrayAdapter = adapter;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getViewType() {
        return 0;
    }

    public BaseListItem<T> setOnClickListener(final OnClickListener onClickListener) {
        mOnClickListener = onClickListener;
        return this;
    }

    public BaseListItem<T> setClickable(final boolean clickable) {
        mClickable = clickable;
        return this;
    }

    public void invalidate() {
        mArrayAdapter.notifyDataSetChanged();
    }

    public T getData() {
        return mData;
    }

    public void setData(final T data) {
        mData = data;
    }
}
