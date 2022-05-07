package com.zxn.easypopup.easypop

import android.graphics.Color
import android.util.Log
import android.view.Gravity
import android.view.MotionEvent
import android.view.View
import android.view.View.OnLongClickListener
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.LinearLayout
import android.widget.PopupWindow
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import com.blankj.utilcode.util.KeyboardUtils
import com.blankj.utilcode.util.LogUtils
import com.blankj.utilcode.util.SizeUtils
import com.blankj.utilcode.util.ToastUtils
import com.zxn.easypopup.R
import com.zxn.easypopup.base.BaseActivity
import com.zxn.easypopup.easypop.EasyPopActivity
import com.zxn.easypopup.views.TitleBar
import com.zxn.easypopup.views.TitleBar.OnTitleListener
import com.zxn.easypopup.views.TriangleDrawable
import com.zxn.popup.EasyPopup
import com.zxn.popup.XGravity
import com.zxn.popup.YGravity

class EasyPopActivity : BaseActivity(), View.OnClickListener {
    private lateinit var mTitleBar: TitleBar
    private var mCircleBtn: Button? = null
    private var mAboveBtn: Button? = null
    private var mBottomBtn: Button? = null
    private var mRightBtn: Button? = null
    private var mBgDimBtn: Button? = null
    private var mAnyBgDimBtn: Button? = null
    private var mGiftBtn: Button? = null
    private var mCmmtBtn: Button? = null
    private var mComplexBtn: Button? = null
    private lateinit var mEverywhereTv: AppCompatTextView
    private var mComplexBgDimView: LinearLayout? = null
    private var mWeiboPop: EasyPopup? = null
    private var mQQPop: EasyPopup? = null
    private lateinit var mCirclePop: EasyPopup
    private lateinit var mAbovePop: EasyPopup
    private var mBottomPop: EasyPopup? = null
    private var mBgDimPop: EasyPopup? = null
    private var mAnyBgDimPop: EasyPopup? = null
    private var mGiftPopup: GiftPopup? = null
    private lateinit var mCmmtPopup: CmmtPopup
    private var mComplexPopup: ComplexPopup? = null
    private var mEverywherePopup: EverywherePopup? = null
    private var mLastX = 0f
    private var mLastY = 0f

    override fun setLayoutId(): Int = R.layout.activity_easy_pop

    override fun initVariables() {}

    override fun initViews() {
        mTitleBar = findViewById(R.id.tb_easy)
        mTitleBar.setTile("Easy Pop")
        mCircleBtn = findViewById(R.id.btn_circle_comment)
        mAboveBtn = findViewById(R.id.btn_above)
        mBottomBtn = findViewById(R.id.btn_bottom) //mBottomBtn
        mRightBtn = findViewById(R.id.btn_right)
        mBgDimBtn = findViewById(R.id.btn_bg_dim)
        mAnyBgDimBtn = findViewById(R.id.btn_bg_dim_any)
        mGiftBtn = findViewById(R.id.btn_gift)
        mCmmtBtn = findViewById(R.id.btn_pop_cmmt)
        mComplexBtn = findViewById(R.id.btn_complex)
        mComplexBgDimView = findViewById(R.id.ll_complex_bg_dim)
        mEverywhereTv = findViewById(R.id.tv_pop_everywhere)
        initQQPop()
        initWeiboPop()
        initCirclePop()
        initBottomPop()
        initAbovePop()
        initBgDimPop()
        initAnyBgDimPop()
        initGiftPop()
        initCmmtPop()
        initComplexPop()
        mEverywherePopup = EverywherePopup.create(this)
                .apply()
        mEverywhereTv.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                mLastX = event.rawX
                mLastY = event.rawY
                LogUtils.i("onTouch x=$mLastX,y=$mLastY")
            }
            false
        })
        mEverywhereTv.setOnLongClickListener(OnLongClickListener { v ->
            mEverywherePopup!!.showEverywhere(v, mLastX.toInt(), mLastY.toInt())
            true
        })
    }

    override fun initEvents() {
        mTitleBar!!.setOnTitleListener(object : OnTitleListener {
            override fun onLeftClick(view: View) {
                finish()
            }

            override fun onRightClick(view: View) {
                showQQPop(view)
            }

            override fun onTitleClick(view: View) {
                showWeiboPop(view)
            }
        })
        mCircleBtn!!.setOnClickListener(this)
        mAboveBtn!!.setOnClickListener(this)
        mBottomBtn!!.setOnClickListener(this)
        mRightBtn!!.setOnClickListener(this)
        mBgDimBtn!!.setOnClickListener(this)
        mAnyBgDimBtn!!.setOnClickListener(this)
        mGiftBtn!!.setOnClickListener(this)
        mCmmtBtn!!.setOnClickListener(this)
        mComplexBtn!!.setOnClickListener(this)
    }

    private fun initQQPop() {
        mQQPop = EasyPopup.create()
                .setContext(this)
                .setContentView(R.layout.layout_right_pop)
                .setAnimationStyle(R.style.RightTop2PopAnim)
                .setOnViewListener(object : EasyPopup.OnViewListener{
                    override fun initViews(view: View?, popup: EasyPopup?) {
                        val arrowView = view?.findViewById<View>(R.id.v_arrow)
                        if (arrowView != null) {
                            arrowView.background = TriangleDrawable(TriangleDrawable.TOP, Color.parseColor("#88FF88"))
                        }
                    }

                })
                .setFocusAndOutsideEnable(true) //                .setBackgroundDimEnable(true)
                //                .setDimValue(0.5f)
                //                .setDimColor(Color.RED)
                //                .setDimView(mTitleBar)
                .apply()
    }

    private fun showQQPop(view: View) {
        val offsetX = SizeUtils.dp2px(20f) - view.width / 2
        val offsetY = (mTitleBar!!.height - view.height) / 2
        mQQPop!!.showAtAnchorView(view, YGravity.BELOW, XGravity.ALIGN_RIGHT, offsetX, offsetY)
    }

    private fun initWeiboPop() {
        mWeiboPop = EasyPopup.create()
                .setContentView(this, R.layout.layout_center_pop)
                .setAnimationStyle(R.style.TopPopAnim)
                .setOnViewListener(object : EasyPopup.OnViewListener{
                    override fun initViews(view: View?, popup: EasyPopup?) {
                        val arrowView = view!!.findViewById<View>(R.id.v_arrow_weibo)
                        arrowView.background = TriangleDrawable(TriangleDrawable.TOP, Color.WHITE)
                    }
                })
                .setFocusAndOutsideEnable(true)
                .apply()
    }

    private fun showWeiboPop(view: View) {
        val offsetY = (mTitleBar!!.height - view.height) / 2
        mWeiboPop!!.showAtAnchorView(view, YGravity.BELOW, XGravity.CENTER, 0, offsetY)
    }

    private fun initCirclePop() {
        mCirclePop = EasyPopup.create()
                .setContentView(this, R.layout.layout_circle_comment)
                .setAnimationStyle(R.style.RightPopAnim)
                .setFocusAndOutsideEnable(true)
                .setOnViewListener(object : EasyPopup.OnViewListener{
                    override fun initViews(view: View?, popup: EasyPopup?) {
                        view!!.findViewById<View>(R.id.tv_zan).setOnClickListener {
                            ToastUtils.showShort("赞")
                            popup!!.dismiss()
                        }
                        view.findViewById<View>(R.id.tv_comment).setOnClickListener {
                            ToastUtils.showShort("评论")
                            popup!!.dismiss()
                        }
                    }

                })
                .apply()
        mCirclePop.setOnDismissListener(PopupWindow.OnDismissListener { Log.e(TAG, "onDismiss: mCirclePop") })
    }

    private fun showCirclePop(view: View) {
        mCirclePop!!.showAtAnchorView(view, YGravity.CENTER, XGravity.LEFT, 0, 0)
        //        mCirclePop.getPopupWindow().setAnimationStyle(R.style.QQPopAnim);
    }

    private fun initAbovePop() {
        mAbovePop = EasyPopup.create()
                .setContentView(this, R.layout.layout_any)
                .setFocusAndOutsideEnable(true)
                .setOnDismissListener { Log.e(TAG, "onDismiss: mAbovePop") }
                .apply()
        mAbovePop.findViewById<View>(R.id.tv_copy)!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                Log.i(TAG, "onClick: 复制")
                Toast.makeText(this@EasyPopActivity, "fuzhi", Toast.LENGTH_SHORT).show()
                mAbovePop.dismiss()
            }
        })
    }

    private fun initBottomPop() {
        mBottomPop = EasyPopup.create()
                .setContentView(this, R.layout.layout_any)
                .setFocusAndOutsideEnable(true)
                .apply()
    }

    private fun showAbovePop(view: View) {
        mAbovePop.showAtAnchorView(view, YGravity.ABOVE, XGravity.CENTER)
    }

    private fun showBottomPop(view: View) {
        mBottomPop!!.showAtAnchorView(view, YGravity.BELOW, XGravity.CENTER)
    }

    private fun showRightPop(view: View) {
        mAbovePop.showAtAnchorView(view, YGravity.CENTER, XGravity.RIGHT)
    }

    private fun initBgDimPop() {
        mBgDimPop = EasyPopup.create()
                .setContentView(this, R.layout.layout_any)
                .setFocusAndOutsideEnable(true)
                .setBackgroundDimEnable(true)
                .setDimValue(0.4f)
                .apply()
    }

    private fun showBgDimPop(view: View) {
        mBgDimPop!!.showAtAnchorView(view, YGravity.ALIGN_TOP, XGravity.ALIGN_LEFT)
    }

    private fun initAnyBgDimPop() {
        mAnyBgDimPop = EasyPopup.create()
                .setContentView(this, R.layout.layout_any)
                .setFocusAndOutsideEnable(true)
                .setBackgroundDimEnable(true)
                .setDimValue(0.4f)
                .setDimView(mTitleBar!!)
                .setDimColor(Color.YELLOW)
                .apply()
    }

    private fun showAnyBgDimPop(view: View) {
        mAnyBgDimPop!!.showAtAnchorView(view, YGravity.ALIGN_BOTTOM, XGravity.ALIGN_RIGHT)
    }

    private fun initGiftPop() {
        mGiftPopup = GiftPopup.Companion.create()
                .setContext(this)
                ?.apply()
    }

    private fun showGiftPop(view: View) {
        mGiftPopup!!.showAtLocation(view, Gravity.BOTTOM, 0, 0)
    }

    private fun initComplexPop() {
        mComplexPopup = ComplexPopup.Companion.create(this)
                .setDimView(mComplexBgDimView!!)
                .apply()
    }

    private fun showComplexPop(view: View) {
//        mComplexPopup.showAtAnchorView(view, YGravity.ABOVE, XGravity.LEFT);
        mComplexPopup!!.showAtLocation(view, Gravity.BOTTOM, 0, 0)
    }

    private fun initCmmtPop() {
        mCmmtPopup = CmmtPopup.Companion.create(this)
                .setOnCancelClickListener(View.OnClickListener {
                    if (mCmmtPopup!!.isShowing) {
                        //无法隐藏输入法。只有toggle方法起作用...
                        KeyboardUtils.hideSoftInput(this@EasyPopActivity)
                        mCmmtPopup!!.hideSoftInput()
                                .dismiss()
                    }
                })
                .setOnOkClickListener(View.OnClickListener {
                    if (mCmmtPopup!!.isShowing) {
                        //无法隐藏输入法。只有toggle方法起作用...
                        KeyboardUtils.hideSoftInput(this@EasyPopActivity)
                        mCmmtPopup.dismiss()
                    }
                })
                .apply()
    }

    private fun showCmmtPop(view: View) {
        mCmmtPopup!!.showSoftInput()
                .showAtLocation(view, Gravity.BOTTOM, 0, 0)
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btn_circle_comment -> showCirclePop(v)
            R.id.btn_above -> showAbovePop(v)
            R.id.btn_bottom -> showBottomPop(v)
            R.id.btn_right -> showRightPop(v)
            R.id.btn_bg_dim -> showBgDimPop(v)
            R.id.btn_bg_dim_any -> showAnyBgDimPop(v)
            R.id.btn_gift -> showGiftPop(v)
            R.id.btn_pop_cmmt -> showCmmtPop(v)
            R.id.btn_complex -> showComplexPop(v)
        }
    }

    companion object {
        private const val TAG = "EasyPopActivity"
    }
}