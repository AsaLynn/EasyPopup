package com.zxn.popup

import androidx.annotation.IntDef
import com.zxn.popup.YGravity
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

/**
 * Created by zyyoona7 on 2017/8/3.
 */
@IntDef(YGravity.CENTER, YGravity.ABOVE, YGravity.BELOW, YGravity.ALIGN_TOP, YGravity.ALIGN_BOTTOM)
@Retention(RetentionPolicy.SOURCE)
annotation class YGravity {
    companion object {
        const val CENTER = 0
        const val ABOVE = 1
        const val BELOW = 2
        const val ALIGN_TOP = 3
        const val ALIGN_BOTTOM = 4
    }
}