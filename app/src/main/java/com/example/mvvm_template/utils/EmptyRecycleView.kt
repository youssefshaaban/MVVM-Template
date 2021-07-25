package com.example.mvvm_template.utils

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class EmptyRecycleView : RecyclerView {
   private var mEmptyView: View? = null

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )

    private fun initEmptyView() {
        mEmptyView?.visibility =
            if (adapter == null || adapter!!.itemCount == 0) View.VISIBLE else View.GONE
        this@EmptyRecycleView.visibility =
            if (adapter == null || adapter!!.itemCount == 0) View.GONE else View.VISIBLE
    }

    internal val observer: RecyclerView.AdapterDataObserver =
        object : RecyclerView.AdapterDataObserver() {
            override fun onChanged() {
                super.onChanged()
                initEmptyView()
            }

            override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
                super.onItemRangeInserted(positionStart, itemCount)
                initEmptyView()
            }

            override fun onItemRangeRemoved(positionStart: Int, itemCount: Int) {
                super.onItemRangeRemoved(positionStart, itemCount)
                initEmptyView()
            }
        }

    override fun setAdapter(adapter: RecyclerView.Adapter<*>?) {
        val oldAdapter = getAdapter()
        super.setAdapter(adapter)
        oldAdapter?.unregisterAdapterDataObserver(observer)
        adapter?.registerAdapterDataObserver(observer)
        initEmptyView()
    }

    fun setEmptyView(view: View) {
        this.mEmptyView = view
        //initEmptyView();
    }
}