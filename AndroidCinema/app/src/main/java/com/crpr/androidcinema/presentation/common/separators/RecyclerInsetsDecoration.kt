package com.crpr.androidcinema.presentation.common.separators

import android.content.Context
import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

import com.crpr.androidcinema.R

/**
 * ItemDecoration implementation that applies an inset margin
 * around each child of the RecyclerView. The inset value is controlled
 * by a dimension resource.

 * by Dave Smith at: https://github.com/devunwired/recyclerview-playground
 */
class RecyclerInsetsDecoration(context: Context) : RecyclerView.ItemDecoration() {

    private val mInsets: Int = context.resources.getDimensionPixelSize(R.dimen.insets)

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {

        //We can supply forced insets for each item view here in the Rect
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(mInsets, mInsets, mInsets, mInsets)
    }
}