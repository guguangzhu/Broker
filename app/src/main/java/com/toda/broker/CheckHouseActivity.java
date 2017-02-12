package com.toda.broker;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by guugangzhu on 2016/12/29.
 */

public class CheckHouseActivity extends BaseActivity {

    @BindView(R.id.ll_house_info)
    LinearLayout llHouseInfo;
    @BindView(R.id.ll_estate_info)
    LinearLayout llEstateInfo;
    @BindView(R.id.ll_surrounding)
    LinearLayout llSurrounding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_house_main);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("核验房源");
    }

    @OnClick({R.id.ll_house_info, R.id.ll_estate_info, R.id.ll_surrounding})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_house_info:
                goPage(CheckHouseInfoActivity.class);
                break;
            case R.id.ll_estate_info:
                goPage(CheckEstateInfoActivity.class);
                break;
            case R.id.ll_surrounding:
                goPage(CheckSurroundingActivity.class);
                break;
        }
    }
}
