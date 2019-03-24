package com.example.nitish.myapplication.utils

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.StaggeredGridLayoutManager

abstract class EndlessRecyclerOnScrollListener : RecyclerView.OnScrollListener {
    var previousTotal = 0
    private var loading = true
    private var visibleThreshold = 2
    internal var firstVisibleItem: Int = 0
    internal var visibleItemCount: Int = 0
    internal var totalItemCount: Int = 0
    private var isHorizontal: Boolean = false
    private var current_page = 1
    private var mLinearLayoutManager: RecyclerView.LayoutManager? = null
    private var isReset: Boolean = false

    constructor(var1: RecyclerView.LayoutManager) {
        this.mLinearLayoutManager = var1
    }

    constructor(var1: RecyclerView.LayoutManager, var2: Boolean) {
        this.isHorizontal = var2
        this.mLinearLayoutManager = var1
    }

    override fun onScrolled(var1: RecyclerView, var2: Int, var3: Int) {
        super.onScrolled(var1, var2, var3)
        if (!this.isHorizontal || var3 >= 0) {
            if (this.isHorizontal || var3 > 0) {
                this.visibleItemCount = var1!!.childCount
                this.totalItemCount = this.mLinearLayoutManager!!.itemCount
                if (this.mLinearLayoutManager is LinearLayoutManager) {
                    this.firstVisibleItem = (this.mLinearLayoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
                } else if (this.mLinearLayoutManager is StaggeredGridLayoutManager) {
                    this.firstVisibleItem = (this.mLinearLayoutManager as StaggeredGridLayoutManager).findFirstVisibleItemPositions(IntArray(2))[0]
                }

                if (this.loading && this.totalItemCount > this.previousTotal) {
                    this.loading = false
                    this.previousTotal = this.totalItemCount
                }

                if (!this.loading && (this.totalItemCount - this.visibleItemCount <= this.firstVisibleItem + this.visibleThreshold || isReset)) {
                    isReset = false
                    ++this.current_page
                    this.onLoadMore(this.current_page)
                    this.loading = true
                }

            }
        }
    }

    abstract fun onLoadMore(currentPage: Int)

    fun resetListner() {
        isReset = true
        current_page = 1
        previousTotal = 0
        loading = false
        this.totalItemCount = this.mLinearLayoutManager!!.itemCount
    }

    companion object {

        var TAG = EndlessRecyclerOnScrollListener::class.java.simpleName
    }
}
