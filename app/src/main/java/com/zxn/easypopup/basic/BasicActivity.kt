package com.zxn.easypopup.basic

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.PopupWindow
import com.blankj.utilcode.util.SizeUtils
import com.zxn.easypopup.R
import com.zxn.easypopup.base.BaseActivity
import com.zxn.easypopup.views.TitleBar
import com.zxn.easypopup.views.TitleBar.OnTitleListener

class BasicActivity : BaseActivity() {
    private var mTitleBar: TitleBar? = null
    private var mCiclePop: PopupWindow? = null
    private var mQQPop: PopupWindow? = null
    private var mWeiboPop: PopupWindow? = null
    private var mCommentBtn: Button? = null
    override fun setLayoutId(): Int {
        return R.layout.activity_basic
    }

    override fun initVariables() {}
    override fun initViews() {
        mTitleBar = findViewById<View>(R.id.tb_basic) as TitleBar
        mTitleBar!!.setTile("传统使用")
        mCommentBtn = findViewById<View>(R.id.btn_comment) as Button
        initCirclePop()
        initQQPop()
        initWeiboPop()
    }

    override fun initEvents() {
        mTitleBar!!.setOnTitleListener(object : OnTitleListener {

            override fun onLeftClick(view: View) {

            }

            override fun onRightClick(view: View) {
                if (mQQPop != null) {
                    mQQPop!!.showAsDropDown(view, -mQQPop!!.contentView.width + SizeUtils.dp2px(30f), 0)
                }
            }

            override fun onTitleClick(view: View) {
                if (mWeiboPop != null) {
                    Log.e(TAG, "onTitleClick: " + view.width)
                    mWeiboPop!!.showAsDropDown(view, view.width / 2 - mWeiboPop!!.contentView.width / 2, 0)
                }
            }
        })
        mCommentBtn!!.setOnClickListener { v ->
            if (mCiclePop != null) {
                mCiclePop!!.showAsDropDown(v, -mCiclePop!!.contentView.width, -(mCommentBtn!!.height / 2 + mCiclePop!!.contentView.height / 2))
            }
        }
    }

    private fun initCirclePop() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_circle_comment, null)
        mCiclePop = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mCiclePop!!.animationStyle = R.style.RightPopAnim
        mCiclePop!!.isFocusable = true
        mCiclePop!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mCiclePop!!.isOutsideTouchable = true
    }

    private fun initQQPop() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_right_pop, null)
        mQQPop = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mQQPop!!.animationStyle = R.style.RightTopPopAnim
        mQQPop!!.isFocusable = true
        mQQPop!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mQQPop!!.isOutsideTouchable = true
    }

    private fun initWeiboPop() {
        val view = LayoutInflater.from(this).inflate(R.layout.layout_center_pop, null)
        mWeiboPop = PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        mWeiboPop!!.animationStyle = R.style.TopPopAnim
        mWeiboPop!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        mWeiboPop!!.isFocusable = true
        mWeiboPop!!.isOutsideTouchable = false
    }

    companion object {
        private const val TAG = "BasicActivity"
    }
}