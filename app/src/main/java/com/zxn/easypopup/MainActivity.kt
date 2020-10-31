package com.zxn.easypopup

import android.view.View
import android.widget.Button
import com.zxn.easypopup.base.BaseActivity
import com.zxn.easypopup.basic.BasicActivity
import com.zxn.easypopup.easypop.EasyPopActivity
import com.zxn.easypopup.easypop.RecyclerViewActivity

class MainActivity : BaseActivity() {
    //使用场景 QQ+号，直播礼物弹窗，微信朋友圈评论
    private var mBasicBtn: Button? = null
    private var mEasyBtn: Button? = null
    private var mRvBtn: Button? = null
    override fun setLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initVariables() {}
    override fun initViews() {
        mBasicBtn = findViewById<View>(R.id.btn_basic) as Button
        mEasyBtn = findViewById<View>(R.id.btn_easy) as Button
        mRvBtn = findViewById<View>(R.id.btn_recycler) as Button
    }

    override fun initEvents() {
        mBasicBtn!!.setOnClickListener { goTo(BasicActivity::class.java) }
        mEasyBtn!!.setOnClickListener { goTo(EasyPopActivity::class.java) }
        mRvBtn!!.setOnClickListener { goTo(RecyclerViewActivity::class.java) }
    }
}