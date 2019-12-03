package com.zxn.easypopup;

import android.view.View;
import android.widget.Button;

import com.zxn.easypopup.base.BaseActivity;
import com.zxn.easypopup.basic.BasicActivity;
import com.zxn.easypopup.easypop.EasyPopActivity;
import com.zxn.easypopup.easypop.RecyclerViewActivity;

public class MainActivity extends BaseActivity {

    //使用场景 QQ+号，直播礼物弹窗，微信朋友圈评论

    private Button mBasicBtn;

    private Button mEasyBtn;

    private Button mRvBtn;

    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables() {

    }

    @Override
    protected void initViews() {
        mBasicBtn = (Button) findViewById(R.id.btn_basic);
        mEasyBtn = (Button) findViewById(R.id.btn_easy);
        mRvBtn = (Button) findViewById(R.id.btn_recycler);
    }

    @Override
    protected void initEvents() {
        mBasicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(BasicActivity.class);
            }
        });

        mEasyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(EasyPopActivity.class);
            }
        });

        mRvBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goTo(RecyclerViewActivity.class);
            }
        });
    }
}
