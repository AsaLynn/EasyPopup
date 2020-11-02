package com.zxn.easypopup.easypop

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemChildClickListener
import com.zxn.easypopup.R
import com.zxn.popup.BasePopup
import java.util.*

/**
 * Created by zyyoona7 on 2017/8/4.
 */
class ComplexPopup protected constructor(private val mContext: Context?) : BasePopup<ComplexPopup>() {
    private lateinit var mOkBtn: Button
    private lateinit var mCancelBtn: Button
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mComplexAdapter: ComplexAdapter
    override fun initAttributes() {
        setContentView(R.layout.layout_complex, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        setFocusAndOutsideEnable(false)
                .setBackgroundDimEnable(true)
                .setDimValue(0.5f)
    }

    override fun initViews(view: View?, basePopup: ComplexPopup) {
        mOkBtn = findViewById(R.id.btn_ok)!!
        mCancelBtn = findViewById(R.id.btn_cancel)!!
        mRecyclerView = findViewById(R.id.rv_complex)!!
        mComplexAdapter = ComplexAdapter()
        mRecyclerView.layoutManager = LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL, false)
        mRecyclerView.adapter = mComplexAdapter
        val list: MutableList<String> = mutableListOf()
        for (i in 0..4) {
            list.add("烤肉盖饭")
        }
        //mComplexAdapter!!.setNewData(list)
        mComplexAdapter.setList(list)
        mOkBtn.setOnClickListener({ dismiss() })
        mCancelBtn.setOnClickListener({ dismiss() })
        mComplexAdapter.setOnItemChildClickListener(object : OnItemChildClickListener {

            override fun onItemChildClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
                when (view.id) {
                    R.id.btn_complex_delete -> mComplexAdapter!!.remove(position)
                    else -> {
                    }
                }
            }
        })
    }

    fun setAbc() {}

    companion object {
        private const val TAG = "ComplexPopup"
        fun create(context: Context?): ComplexPopup {
            return ComplexPopup(context)
        }
    }

    init {
        setContext(mContext)
    }

}