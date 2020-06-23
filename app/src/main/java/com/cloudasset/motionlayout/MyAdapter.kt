package com.cloudasset.motionlayout

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeAdapter

class MyAdapter(dataSet: List<String> = emptyList())
    : DragDropSwipeAdapter<String, MyAdapter.ViewHolder>(dataSet) {

    class ViewHolder(itemView: View) : DragDropSwipeAdapter.ViewHolder(itemView) {
        val itemText: TextView = itemView.findViewById(R.id.item_text)
        val dragIcon: ImageView = itemView.findViewById(R.id.drag_icon)
    }

    override fun getViewHolder(itemLayout: View) = MyAdapter.ViewHolder(itemLayout)

    override fun onBindViewHolder(item: String, viewHolder: MyAdapter.ViewHolder, position: Int) {
        // Here we update the contents of the view holder's views to reflect the item's data
        viewHolder.itemText.text = item
    }

    override fun getViewToTouchToStartDraggingItem(item: String, viewHolder: MyAdapter.ViewHolder, position: Int): View? {
        // We return the view holder's view on which the user has to touch to drag the item
        return viewHolder.itemView
    }
}