package com.akexorcist.recyclerbackgroundsupportview

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

internal class ScrollSupportImageView : AppCompatImageView {
    companion object {
        private const val STATE_SHOW = "state_show"
        private const val STATE_HIDE = "state_hide"
        private const val STATE_IDLE = "state_idle"

        const val DIRECTION_TOP = 0
        const val DIRECTION_BOTTOM = 1
    }

    private var offset = -1
    private var range = -1
    private var extent = -1
    private var direction = DIRECTION_TOP
    private var state = updateState()

    private var recyclerView: RecyclerView? = null

    constructor(context: Context?) : super(context)

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        canvas?.let {
            if (shouldShow()) {
                canvas.translate(0f, getTranslateY())
            } else if (!shouldShow() && state == STATE_HIDE) {
                state = STATE_IDLE
                if (isValueAssigned()) {
                    canvas.translate(0f, extent.toFloat())
                } else {
                    canvas.translate(0f, measuredHeight.toFloat())
                }
            }
        }
        super.onDraw(canvas)
    }

    private val onScrollChangedListener = object : RecyclerView.OnScrollListener() {
        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            range = recyclerView.computeVerticalScrollRange()
            extent = recyclerView.computeVerticalScrollExtent()
            offset = recyclerView.computeVerticalScrollOffset()
            if (shouldShow()) {
                state = STATE_SHOW
                invalidate()
            } else {
                if (state == STATE_SHOW) {
                    state = STATE_HIDE
                    invalidate()
                }
            }
        }
    }

    private fun getTranslateY(): Float = if (direction == DIRECTION_BOTTOM) {
        (range - (offset + extent)).toFloat()
    } else {
        -offset.toFloat()
    }

    private fun shouldShow(): Boolean = if (direction == DIRECTION_BOTTOM) {
        shouldShowForBottom()
    } else {
        shouldShowForTop()
    }

    private fun shouldShowForBottom(): Boolean = offset >= range - extent * 2 && isValueAssigned()

    private fun shouldShowForTop(): Boolean = offset <= extent * 2 && isValueAssigned()

    private fun isValueAssigned(): Boolean = offset != -1 && range != -1 && extent != -1

    private fun updateState() =
            if (direction == DIRECTION_TOP) {
                STATE_SHOW
            } else {
                STATE_HIDE
            }

    fun setRecyclerView(recyclerView: RecyclerView) {
        this.recyclerView = recyclerView
        recyclerView.doOnGlobalLayout {
            recyclerView.addOnScrollListener(onScrollChangedListener)
        }
    }

    fun setDirection(direction: Int) {
        this.direction = direction
        this.state = updateState()
        invalidate()
    }
}