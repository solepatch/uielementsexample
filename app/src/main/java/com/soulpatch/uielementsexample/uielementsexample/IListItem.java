package com.soulpatch.uielementsexample.uielementsexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * Interface for items in a list
 *
 * @author Akshay Viswanathan
 */
public interface IListItem<T> {
	enum RowType {
		TEXT_ITEM,
	}

	/**
	 * Interface to listen for changes to the item
	 */
	interface OnClickListener {
		/**
		 * Called whenever the item has been changed (i.e. for a edit text item this would correspond to the text changing)
		 *
		 * @param listItem The item that has changed its state
		 */
		void onItemClicked(IListItem listItem);
	}

	/**
	 * Creates a new view and then creates a new view holder tied to that view.
	 *
	 * @param inflater The layout inflater that the view will be inflated on.
	 * @param parent The parent that this view will eventually be attached to.
	 * @return A viewholder that has been initialized to point to the new view
	 */
	ViewHolder createViewHolder(final LayoutInflater inflater, final ViewGroup parent);

	/**
	 * Fully populates the view holder for the item.
	 *
	 * @param holder The view holder that is tied to the view to be shown.
	 */
	void bindViewHolder(final ViewHolder holder);

	/**
	 * get the current title of the item
	 *
	 * @return current title of the item
	 */
	String getTitle();

	/**
	 * Set the title of the item
	 *
	 * @param title text that will be the title of the item
	 */
	void setTitle(String title);

	/**
	 * Get the data model associated with the item
	 *
	 * @return the data model associated with the item
	 */
	T getData();

	/**
	 * Set the data model associated with the item
	 *
	 * @param data the data model associated with the item
	 */
	void setData(T data);

	/**
	 * Sets the adapter which contains the item. (*** SHOULD BE ONLY CALLED FROM THE ADAPTER CODE **)
	 *
	 * @param adapter the adapter to store on the list item
	 */
	void setAdapter(BaseAdapter adapter);

	int getViewType();

	/**
	 * A ViewHolder describes an item view. <p/> <p>List item implementations should subclass ViewHolder and add fields for caching potentially expensive {@link View#findViewById(int)} results.</p>
	 */
	class ViewHolder {
		public final View mRootView;

		public ViewHolder(final View root) {
			if (root == null) {
				throw new IllegalArgumentException("root view cannot be null");
			}

			mRootView = root;
		}
	}
}
