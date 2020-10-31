package com.zxn.easypopup.easypop

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.blankj.utilcode.util.SizeUtils
import com.zxn.easypopup.R
import com.zxn.popup.BasePopup
import java.util.*

//import androidx.recyclerview.widget.GridLayoutManager;
/**
 * Created by zyyoona7 on 2017/8/7.
 */
class GiftPopup : BasePopup<GiftPopup>() {
    private lateinit var mRecyclerView: RecyclerView
    override fun initAttributes() {
        setContentView(R.layout.layout_gift)
        height = SizeUtils.dp2px(200f)
        width = ViewGroup.LayoutParams.MATCH_PARENT
        setFocusAndOutsideEnable(true)
    }

    protected override fun initViews(view: View, basePopup: GiftPopup) {
        mRecyclerView = findViewById(R.id.rv_gift)
        mRecyclerView.layoutManager = GridLayoutManager(mRecyclerView.getContext(), 4, GridLayoutManager.VERTICAL, false)
        val list = createList()
        val adapter = GiftAdapter()
        //adapter.setNewData(list)
        adapter.setList(list)
        mRecyclerView.setAdapter(adapter)
    }

    private fun createList(): List<String> {
        val list: MutableList<String> = ArrayList(1)
        for (i in 0..14) {
            list.add("")
        }
        return list
    }

    companion object {
        fun create(): GiftPopup {
            return GiftPopup()
        }
    }
}