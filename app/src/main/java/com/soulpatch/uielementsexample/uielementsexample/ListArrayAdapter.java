package com.soulpatch.uielementsexample.uielementsexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Class to create an adapter for ListView
 *
 * @author Akshay Viswanathan
 */
public class ListArrayAdapter extends ArrayAdapter<IListItem> {
    private final LayoutInflater mInflater;
    private boolean mStableIds;

    public ListArrayAdapter(final Context context, final List<? extends IListItem> listItems) {
        super(context, 0, (List<IListItem>) listItems);
        mInflater = LayoutInflater.from(context);
    }

    public void setStableIds() {
        mStableIds = true;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasStableIds() {
        return mStableIds;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getItemViewType(final int position) {
        return getItem(position).getViewType();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getViewTypeCount() {
        return IListItem.RowType.values().length;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        if (getCount() <= position) {
            return null;
        }

        final View view;
        if (convertView == null || convertView.getTag() == null) {
            final IListItem.ViewHolder viewHolder = getItem(position).createViewHolder(mInflater, parent);
            view = viewHolder.mRootView;
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }
        final IListItem listItem = getItem(position);
        listItem.setAdapter(this);
        listItem.bindViewHolder((IListItem.ViewHolder) view.getTag());

        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public View getDropDownView(final int position, final View convertView, @NonNull final ViewGroup parent) {
        if (getContext() == null) {
            return null;
        }

        final View view;
        if (convertView == null || convertView.getTag() == null) {
            final IListItem.ViewHolder viewHolder = getItem(position).createViewHolder(mInflater, parent);
            view = viewHolder.mRootView;
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        final IListItem listItem = getItem(position);
        listItem.setAdapter(this);
        listItem.bindViewHolder((IListItem.ViewHolder) view.getTag());

        return view;
    }
}