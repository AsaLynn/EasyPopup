package com.zxn.easypopup.easypop

import android.content.Context
import android.view.Gravity
import android.view.View
import com.blankj.utilcode.util.ScreenUtils
import com.zxn.easypopup.R
import com.zxn.popup.BasePopup

class EverywherePopup private constructor(context: Context) : BasePopup<EverywherePopup>() {
    override fun initAttributes() {
        setContentView(R.layout.layout_everywhere_pop)
                .setAnimationStyle(R.style.LeftTopPopAnim)
    }

    /**
     * 自适应触摸点 弹出
     * @param parent
     * @param touchX
     * @param touchY
     * @return
     */
    fun showEverywhere(parent: View?, touchX: Int, touchY: Int): EverywherePopup {
//        if (isRealWHAlready()) {
        val screenHeight = ScreenUtils.getScreenHeight()
        val screenWidth = ScreenUtils.getScreenWidth()
        var offsetX = touchX
        var offsetY = touchY
        if (touchX < width && screenHeight - touchY < height) {
            //左下弹出动画
            popupWindow!!.animationStyle = R.style.LeftBottomPopAnim
            offsetY = touchY - height
        } else if (touchX + width > screenWidth && touchY + height > screenHeight) {
            //右下弹出动画
            popupWindow!!.animationStyle = R.style.RightBottomPopAnim
            offsetX = touchX - width
            offsetY = touchY - height
        } else if (touchX + width > screenWidth) {
            popupWindow!!.animationStyle = R.style.RightTopPopAnim
            offsetX = touchX - width
        } else {
            popupWindow!!.animationStyle = R.style.LeftTopPopAnim
        }
        showAtLocation(parent, Gravity.NO_GRAVITY, offsetX, offsetY)
        //        }
        return this
    }

    companion object {
        fun create(context: Context): EverywherePopup {
            return EverywherePopup(context)
        }
    }

    init {
        setContext(context)
    }

    override fun initViews(view: View?, popup: EverywherePopup) {
        //        setOnRealWHAlreadyListener(new OnRealWHAlreadyListener() {
//            @Override
//            public void onRealWHAlready(BasePopup basePopup, int popWidth, int popHeight, int anchorW, int anchorH) {
//
//            }
//        });
    }
}