package com.zxn.popup

import androidx.annotation.IntDef
import com.zxn.popup.XGravity
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

//import androidx.annotation.IntDef;
/**
 * Created by zyyoona7 on 2017/8/3.
 */
@IntDef(XGravity.CENTER, XGravity.LEFT, XGravity.RIGHT, XGravity.ALIGN_LEFT, XGravity.ALIGN_RIGHT)
@Retention(RetentionPolicy.SOURCE)
annotation class XGravity {
    companion object {
        const val CENTER = 0
        const val LEFT = 1
        const val RIGHT = 2
        const val ALIGN_LEFT = 3
        const val ALIGN_RIGHT = 4
    }
}