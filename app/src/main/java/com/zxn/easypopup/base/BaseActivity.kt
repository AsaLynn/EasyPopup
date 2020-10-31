package com.zxn.easypopup.base

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (setLayoutId() != 0) {
            setContentView(setLayoutId())
        }
        initVariables()
        initViews()
        initEvents()
    }

    protected abstract fun setLayoutId(): Int
    protected abstract fun initVariables()
    protected abstract fun initViews()
    protected abstract fun initEvents()
    protected fun goTo(clazz: Class<*>?) {
        val intent = Intent(this, clazz)
        startActivity(intent)
    }
}