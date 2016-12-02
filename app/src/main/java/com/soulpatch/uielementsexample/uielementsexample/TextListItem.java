package com.soulpatch.uielementsexample.uielementsexample;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * Item to allow the user show a label
 *
 * @author Akshay Viswanathan
 */
public class TextListItem<T> extends BaseListItem<T> {
    public TextListItem(final String title, @NonNull final T data) {
        super(title, data);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int getViewType() {
        return RowType.TEXT_ITEM.ordinal();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ViewHolder createViewHolder(final LayoutInflater layoutInflater, final ViewGroup parent) {
        final View view = layoutInflater.inflate(R.layout.text_item, parent, false);

        if (!(view instanceof TextView)) {
            throw new IllegalArgumentException("view passed in was not a TextView");
        }

        return new ViewHolder(view);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bindViewHolder(final IListItem.ViewHolder holder) {
        final ViewHolder viewHolder = (ViewHolder) holder;
        ((TextView) viewHolder.mRootView).setText(getTitle());

        super.bindViewHolder(viewHolder);
    }

    public static class ViewHolder extends IListItem.ViewHolder {
        final TextView mTextView;

        public ViewHolder(final View root) {
            super(root);
            mTextView = (TextView) root.findViewById(R.id.textview);

            if (mTextView == null) {
                throw new IllegalArgumentException("Viewholder failed to find all the views");
            }
        }
    }
}
