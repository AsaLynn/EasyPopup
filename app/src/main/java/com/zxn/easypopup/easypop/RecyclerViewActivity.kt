package com.zxn.easypopup.easypop

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.LogUtils
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.chad.library.adapter.base.listener.OnItemLongClickListener
import com.zxn.easypopup.R
import com.zxn.popup.BasePopup
import com.zxn.popup.BasePopup.OnRealWHAlreadyListener
import com.zxn.popup.EasyPopup
import com.zxn.popup.XGravity
import com.zxn.popup.YGravity
import java.util.*

class RecyclerViewActivity : AppCompatActivity() {
    private var mPopAdapter: RecyclerPopAdapter? = null
    private var mRecyclerView: RecyclerView? = null
    private lateinit var mRvPop: EasyPopup
    private var mLastX = 0f
    private var mLastY = 0f
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        mRecyclerView = findViewById<View>(R.id.rv_pop) as RecyclerView
        mRecyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        val list: MutableList<String> = ArrayList()
        for (i in 0..9) {
            list.add("")
        }
        mPopAdapter = RecyclerPopAdapter()
        //mPopAdapter!!.setNewData(list)
        mPopAdapter!!.setList(list)
        mRecyclerView!!.adapter = mPopAdapter
        initPop()
        initEvents()
    }

    private fun initPop() {
        mRvPop = EasyPopup.create()
                .setContext(this)
                .setContentView(R.layout.layout_right_pop)
                .setAnimationStyle(R.style.RightTopPopAnim) //                .setHeight(700)
                //                .setWidth(600)
                .setFocusAndOutsideEnable(true) //                .setBackgroundDimEnable(true)
                //                .setDimValue(0.5f)
                //                .setDimColor(Color.RED)
                //                .setDimView(mTitleBar)
                .apply()

        //回调在所有Show方法之后updateLocation方法之前执行
        //只有调用showAtAnchorView方法才会执行updateLocation方法
        mRvPop.setOnRealWHAlreadyListener(object :OnRealWHAlreadyListener{
            override fun onRealWHAlready(basePopup: BasePopup<*>?, popWidth: Int, popHeight: Int, anchorW: Int, anchorH: Int) {
                Log.i(TAG, "onMeasureFinished: width=$popWidth")
                val offsetX = ((resources.displayMetrics.widthPixels - popWidth) / 2
                        - resources.getDimensionPixelSize(R.dimen.dp_30))
                //重新设置偏移量
                mRvPop.setOffsetX(-offsetX)
            }
        })
    }

    private fun initEvents() {
        mPopAdapter!!.setOnItemChildClickListener(object : OnItemChildClickListener {

            override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                val locations = IntArray(2)
                view.getLocationOnScreen(locations)
                Log.i(TAG, Arrays.toString(locations))
                if (locations[1] > resources.displayMetrics.heightPixels / 2) {
                    mRvPop!!.showAtAnchorView(view, YGravity.ABOVE, XGravity.LEFT)
                } else {
                    mRvPop!!.showAtAnchorView(view, YGravity.BELOW, XGravity.LEFT)
                }
            }
        })
        mPopAdapter!!.setOnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                mLastX = event.rawX
                mLastY = event.rawY
                LogUtils.i("onTouch x=$mLastX,y=$mLastY")
            }
            false
        }
        mPopAdapter!!.setOnItemLongClickListener(object : OnItemLongClickListener {

            override fun onItemLongClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int): Boolean {
                LogUtils.i("onLongClick")
                // TODO: 2018/5/10 判断屏幕上下左右的边界来选择弹出方向
                mRvPop!!.showAtLocation(view, Gravity.NO_GRAVITY, mLastX.toInt(), mLastY.toInt())
                return true
            }
        })
    }

    companion object {
        private const val TAG = "RecyclerViewActivity"
    }
}