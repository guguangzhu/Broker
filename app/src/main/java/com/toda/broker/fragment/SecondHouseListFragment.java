package com.toda.broker.fragment;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.toda.broker.HouseInfoActivity;
import com.toda.broker.R;
import com.toda.broker.adapter.HouseListAdapter;
import com.toda.broker.adapter.MessageAdapter;
import com.toda.broker.util.DeviceUtils;
import com.toda.broker.view.CommonListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * 二手房源
 */
public class SecondHouseListFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    @BindView(R.id.lv_list)
    CommonListView lvList;

    private HouseListAdapter adapter;
    List<String> mList=new ArrayList<>();
    public SecondHouseListFragment() {
        // Required empty public constructor
    }


    public static SecondHouseListFragment newInstance() {
        SecondHouseListFragment fragment = new SecondHouseListFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second_list, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initView(View view) {
        lvList.getListView().setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.line_color)));
        lvList.getListView().setDividerHeight(DeviceUtils.dip2px(getContext(),1));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        lvList.setList(mList);
        adapter = new HouseListAdapter(getContext(), list);
        lvList.getListView().setOnItemClickListener(this);
        lvList.setAdapter(adapter);
        lvList.notifyDataSetChanged(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goPage(HouseInfoActivity.class);
    }
}
