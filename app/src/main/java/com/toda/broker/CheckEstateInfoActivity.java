package com.toda.broker;

import android.os.Bundle;

/**
 * 小区户型资料
 * Created by guugangzhu on 2016/12/29.
 */

public class CheckEstateInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_house_info);
        initView();
    }

    @Override
    public void initView() {
        setTitle("小区资料");
    }
}
