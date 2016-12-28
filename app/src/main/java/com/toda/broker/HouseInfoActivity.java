package com.toda.broker;

import android.os.Bundle;

/**
 * 房源资料
 * Created by guugangzhu on 2016/12/28.
 */

public class HouseInfoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_house_info);
        initView();
    }

    @Override
    public void initView() {
        setTitle("房源资料");
        setTopBarRightText("核验");
    }
}
