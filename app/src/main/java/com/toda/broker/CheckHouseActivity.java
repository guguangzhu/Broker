package com.toda.broker;

import android.os.Bundle;

/**
 * Created by guugangzhu on 2016/12/29.
 */

public class CheckHouseActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_house);
        initView();
    }

    @Override
    public void initView() {
        setTitle("核验房源");
    }
}
