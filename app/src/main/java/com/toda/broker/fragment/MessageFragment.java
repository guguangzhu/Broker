package com.toda.broker.fragment;


import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.toda.broker.MainActivity;
import com.toda.broker.R;
import com.toda.broker.adapter.MessageAdapter;
import com.toda.broker.bean.UserBean;
import com.toda.broker.model.RequestParams;
import com.toda.broker.model.ResultData;
import com.toda.broker.statics.ErrorTips;
import com.toda.broker.statics.Task;
import com.toda.broker.util.DeviceUtils;
import com.toda.broker.util.Iconfig;
import com.toda.broker.util.UserUtils;
import com.toda.broker.view.CommonListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


/**
 * 消息列表
 */
public class MessageFragment extends BaseFragment implements AdapterView.OnItemClickListener {
    public static final int TYPE_COUNSELOR = 111;  //置业顾问
    public static final int TYPE_BROKER = 112;  //经纪人
    @BindView(R.id.lv_message)
    CommonListView lvMessage;

    private MessageAdapter adapter;

    public MessageFragment() {
        // Required empty public constructor
    }


    public static MessageFragment newInstance() {
        MessageFragment fragment = new MessageFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);
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
        lvMessage.getListView().setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.line_color)));
        lvMessage.getListView().setDividerHeight(DeviceUtils.dip2px(getContext(),1));
        List<String> list = new ArrayList<>();
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        list.add("");
        adapter = new MessageAdapter(getContext(), list);
        lvMessage.getListView().setOnItemClickListener(this);
        lvMessage.setAdapter(adapter);
    }




    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
