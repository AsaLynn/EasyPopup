package com.zxn.easypopup.easypop

import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.zxn.easypopup.R

class ComplexAdapter : BaseQuickAdapter<String?, BaseViewHolder>(R.layout.item_complex, null) {
    init {
        addChildClickViewIds(R.id.btn_complex_delete)
    }
    override fun convert(helper: BaseViewHolder, item: String?) {
        helper.setText(R.id.tv_complex_item, item)
        //helper.addOnClickListener(R.id.btn_complex_delete)
    }
}