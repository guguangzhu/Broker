package com.toda.broker;

import android.os.Bundle;

/**
 * 验房周边
 * Created by guugangzhu on 2016/12/29.
 */

public class CheckSurroundingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_house_info);
        initView();
    }

    @Override
    public void initView() {
        setTitle("周边配套");
    }
}
