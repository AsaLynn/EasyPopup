package com.zxn.easypopup.views

import android.graphics.*
import android.graphics.drawable.Drawable
import androidx.annotation.IntDef
import androidx.annotation.IntRange
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by jiang on 2017/5/19.
 */
class TriangleDrawable(@field:ARROWDIRECTION @param:ARROWDIRECTION private val arrowDirection: Int, bgColor: Int) : Drawable() {
    private var bgColor = Color.WHITE
    override fun draw(canvas: Canvas) {
        val paint = Paint()
        paint.isAntiAlias = true
        paint.color = bgColor
        paint.style = Paint.Style.FILL
        val path = createPath()
        canvas.drawPath(path, paint)
    }

    private fun createPath(): Path {
        val bound = bounds
        val path = Path()
        if (arrowDirection == TOP) {
            path.moveTo(bound.right / 2.toFloat(), 0f)
            path.lineTo(0f, bound.bottom.toFloat())
            path.lineTo(bound.right.toFloat(), bound.bottom.toFloat())
            path.close()
        } else if (arrowDirection == BOTTOM) {
            path.moveTo(bound.right / 2.toFloat(), bound.bottom.toFloat())
            path.lineTo(0f, 0f)
            path.lineTo(bound.right.toFloat(), 0f)
            path.close()
        } else if (arrowDirection == LEFT) {
            path.moveTo(0f, bound.bottom / 2.toFloat())
            path.lineTo(bound.right.toFloat(), 0f)
            path.lineTo(bound.right.toFloat(), bound.bottom.toFloat())
            path.close()
        } else {
            path.moveTo(bound.right.toFloat(), bound.bottom / 2.toFloat())
            path.lineTo(0f, 0f)
            path.lineTo(0f, bound.bottom.toFloat())
            path.close()
        }
        return path
    }

    override fun setAlpha(@IntRange(from = 0, to = 255) alpha: Int) {}
    override fun setColorFilter(colorFilter: ColorFilter?) {}
    override fun getOpacity(): Int {
        return PixelFormat.TRANSPARENT
    }

    @IntDef(TOP, BOTTOM, LEFT, RIGHT)
    @Retention(RetentionPolicy.SOURCE)
    annotation class ARROWDIRECTION
    companion object {
        const val TOP = 12
        const val BOTTOM = 13
        const val LEFT = 14
        const val RIGHT = 15
    }

    init {
        this.bgColor = bgColor
    }
}