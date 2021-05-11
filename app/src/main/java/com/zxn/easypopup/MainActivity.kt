package com.zxn.easypopup

import android.view.View
import android.widget.Button
import com.zxn.easypopup.base.BaseActivity
import com.zxn.easypopup.basic.BasicActivity
import com.zxn.easypopup.easypop.EasyPopActivity
import com.zxn.easypopup.easypop.RecyclerViewActivity
//使用场景 QQ+号，直播礼物弹窗，微信朋友圈评论
class MainActivity : BaseActivity() {

    override fun setLayoutId(): Int = R.layout.activity_main

    override fun initVariables() {}

    override fun initViews() {
        findViewById<View>(R.id.btn_basic).setOnClickListener { goTo(BasicActivity::class.java) }
        findViewById<View>(R.id.btn_easy).setOnClickListener { goTo(EasyPopActivity::class.java) }
        findViewById<View>(R.id.btn_recycler).setOnClickListener { goTo(RecyclerViewActivity::class.java) }
    }

    override fun initEvents() {}

}