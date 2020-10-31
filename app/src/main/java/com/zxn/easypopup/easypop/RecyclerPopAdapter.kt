package com.zxn.easypopup.easypop

import android.view.View.OnTouchListener
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zxn.easypopup.R

/**
 * Created by zyyoona7 on 2017/9/14.
 */
class RecyclerPopAdapter : BaseQuickAdapter<String?, BaseViewHolder>(R.layout.layout_item_pop, null) {
    private var mOnTouchListener: OnTouchListener? = null

    init {
        addChildClickViewIds(R.id.iv_close)
    }

    override fun convert(baseViewHolder: BaseViewHolder, s: String?) {
        //baseViewHolder.addOnClickListener(R.id.iv_close)
        baseViewHolder.itemView.setOnTouchListener(mOnTouchListener)
    }

    fun setOnTouchListener(onTouchListener: OnTouchListener?) {
        mOnTouchListener = onTouchListener
    }
}