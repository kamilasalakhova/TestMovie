package com.example.movietestapp.screen.base.utils

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.annotation.DimenRes
import androidx.recyclerview.widget.RecyclerView

class NewWidthItemDecoration(
    context: Context,
    @DimenRes widthResId: Int
) :
    RecyclerView.ItemDecoration() {
    private val width: Int = context.resources.getDimensionPixelOffset(widthResId)

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        val lp = view.layoutParams
        lp.width = width
        view.layoutParams = lp
    }

}