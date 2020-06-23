package com.cloudasset.motionlayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.ernestoyaquello.dragdropswiperecyclerview.DragDropSwipeRecyclerView
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemDragListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnItemSwipeListener
import com.ernestoyaquello.dragdropswiperecyclerview.listener.OnListScrollListener
import kotlinx.android.synthetic.main.activity_dragable_grid_view.*

class DraggableGridView : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dragable_grid_view)
        val dataSet = listOf("Item 1", "Item 2", "Item 3","Item 4", "Item 5", "Item 6")
        val mAdapter = MyAdapter(dataSet)
        list.layoutManager = LinearLayoutManager(this)
        list.adapter = mAdapter
        list.orientation = DragDropSwipeRecyclerView.ListOrientation.GRID_LIST_WITH_VERTICAL_SWIPING
        list.layoutManager = GridLayoutManager(this, 2)
        list.numOfColumnsPerRowInGridList = 2
    }

}