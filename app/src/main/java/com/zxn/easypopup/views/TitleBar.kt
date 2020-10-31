package com.zxn.easypopup.views

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView
import androidx.annotation.AttrRes
import com.zxn.easypopup.R

//import androidx.annotation.AttrRes;
//import android.support.annotation.NonNull;
//import android.support.annotation.Nullable;
/**
 * Created by zyyoona7 on 2017/8/2.
 */
class TitleBar @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, @AttrRes defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr), View.OnClickListener {
    private var mTitleText: TextView? = null
    var leftView: TextView? = null
        private set
    var rightView: TextView? = null
        private set
    private var mOnTitleListener: OnTitleListener? = null
    private fun init(context: Context) {
        LayoutInflater.from(context).inflate(R.layout.layout_title, this)
        mTitleText = findViewById<View>(R.id.tv_title_center) as TextView
        leftView = findViewById<View>(R.id.tv_title_left) as TextView
        rightView = findViewById<View>(R.id.tv_title_right) as TextView
        mTitleText!!.setOnClickListener(this)
        leftView!!.setOnClickListener(this)
        rightView!!.setOnClickListener(this)
    }

    fun setTile(text: String?) {
        mTitleText!!.text = text
    }

    fun showLeftText(isShow: Boolean) {
        if (isShow) {
            leftView!!.visibility = VISIBLE
        } else {
            leftView!!.visibility = GONE
        }
    }

    fun showRightText(isShow: Boolean) {
        if (isShow) {
            rightView!!.visibility = VISIBLE
        } else {
            rightView!!.visibility = GONE
        }
    }

    fun setOnTitleListener(listener: OnTitleListener?) {
        mOnTitleListener = listener
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_title_left -> if (mOnTitleListener != null) {
                mOnTitleListener!!.onLeftClick(v)
            }
            R.id.tv_title_center -> if (mOnTitleListener != null) {
                mOnTitleListener!!.onTitleClick(v)
            }
            R.id.tv_title_right -> if (mOnTitleListener != null) {
                mOnTitleListener!!.onRightClick(v)
            }
        }
    }

    interface OnTitleListener {
        /**
         * 左侧点击
         *
         * @param view
         */
        fun onLeftClick(view: View)

        /**
         * 右侧点击
         *
         * @param view
         */
        fun onRightClick(view: View)

        /**
         * title点击
         *
         * @param view
         */
        fun onTitleClick(view: View)
    }

    init {
        init(context)
    }
}