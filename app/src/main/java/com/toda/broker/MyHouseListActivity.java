package com.toda.broker;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import com.toda.broker.adapter.MyHouseListAdapter;
import com.toda.broker.util.DeviceUtils;
import com.toda.broker.view.CommonListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by guugangzhu on 2016/12/28.
 */

public class MyHouseListActivity extends BaseActivity implements MyHouseListAdapter.OnDeleteClickListener {
    private MyHouseListAdapter adapter;
    List<String> mList=new ArrayList<>();

    @BindView(R.id.lv_list)
    CommonListView lvList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_house_list);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        setTitle("我的房源");
        lvList.getListView().setDivider(new ColorDrawable(this.getResources().getColor(R.color.line_color)));
        lvList.getListView().setDividerHeight(DeviceUtils.dip2px(this,1));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lvList.setList(mList);
        adapter = new MyHouseListAdapter(this, list);
        adapter.setOnDeleteClickListener(this);
//        lvList.getListView().setOnItemClickListener(this);
        lvList.setAdapter(adapter);
        lvList.notifyDataSetChanged(list);
    }

    @Override
    public void onDeleteClick(int position) {
        toast("onDeleteClick");
    }
}
