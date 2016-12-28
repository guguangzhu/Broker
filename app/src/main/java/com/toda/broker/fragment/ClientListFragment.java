package com.toda.broker.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.toda.broker.ClientDetailActivity;
import com.toda.broker.R;
import com.toda.broker.adapter.CounselorAdapter;
import com.toda.broker.util.DeviceUtils;
import com.toda.broker.view.CommonListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 客户列表
 * Created by guugangzhu on 2016/12/21.
 */

public class ClientListFragment extends BaseFragment implements AdapterView.OnItemClickListener,CounselorAdapter.OnMessageClickListener{

    @BindView(R.id.lv_message)
    CommonListView lvMessage;

    List<String> mList=new ArrayList<>();

    CounselorAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_client_list, container, false);
        ButterKnife.bind(this, view);
        initView(view);
        return view;
    }

    @Override
    public void initView(View view) {
        lvMessage.getListView().setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.line_color)));
        lvMessage.getListView().setDividerHeight(DeviceUtils.dip2px(getContext(),1));
        lvMessage.getListView().setOnItemClickListener(this);
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter=new CounselorAdapter(getContext(),mList);
        adapter.setOnMessageClickListener(this);
        lvMessage.setList(mList);
        lvMessage.setAdapter(adapter);
        lvMessage.notifyDataSetChanged(list);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        goPage(ClientDetailActivity.class);
    }

    @Override
    public void onMessageClick(int position) {
        toast("message"+position);
    }
}
