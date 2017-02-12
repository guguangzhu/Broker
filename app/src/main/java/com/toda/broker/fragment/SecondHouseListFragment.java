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
import com.toda.broker.bean.SecondHouseListBean;
import com.toda.broker.bean.UserBean;
import com.toda.broker.model.RequestParams;
import com.toda.broker.model.ResultData;
import com.toda.broker.statics.ErrorTips;
import com.toda.broker.statics.Task;
import com.toda.broker.util.DeviceUtils;
import com.toda.broker.util.HandlerRequestErr;
import com.toda.broker.util.Iconfig;
import com.toda.broker.view.CommonListView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.Call;


/**
 * 二手房源
 */
public class SecondHouseListFragment extends BaseFragment implements AdapterView.OnItemClickListener ,CommonListView.OnRefreshListener {
    @BindView(R.id.lv_list)
    CommonListView lvList;

    private HouseListAdapter adapter;
    List<SecondHouseListBean.ListBean> mList=new ArrayList<>();
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
        lvList.refresh(false);
        return view;
    }


    /***
     * 二手房源列表
     */
    private void getHouseList(int pageNum) {
        RequestParams params = new RequestParams(Iconfig.URL_SECOND_HOUSE_LIST);
        params.add("pageNum",pageNum+"");
        params.add("numPerPage",pageSize+"");
        startRequest(Task.SECOND_HOUSE_LIST, params, SecondHouseListBean.class);
    }

    @Override
    public void onRefresh(Call call, int tag, ResultData data) {
        super.onRefresh(call, tag, data);
        switch (tag) {
            case Task.SECOND_HOUSE_LIST:
                if (HandlerRequestErr.handlerListViewErr(getContext(),lvList,data)) {
                    SecondHouseListBean bean = (SecondHouseListBean) data.getData();
                    List<SecondHouseListBean.ListBean> list=bean.getList();
                    lvList.notifyDataSetChanged(list);
                }
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void initView(View view) {
        lvList.getListView().setDivider(new ColorDrawable(getContext().getResources().getColor(R.color.line_color)));
        lvList.getListView().setDividerHeight(DeviceUtils.dip2px(getContext(),1));
        lvList.setListener(this);
        lvList.setList(mList);
        adapter = new HouseListAdapter(getContext(), mList);
        lvList.getListView().setOnItemClickListener(this);
        lvList.setAdapter(adapter);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(mList.get(position).getIsChecked()==1){  //已核验

        }else { //待核验
            goPage(HouseInfoActivity.class);
        }

    }

    @Override
    public void onPullDownToRefresh(int currentPage) {
        getHouseList(currentPage);
    }

    @Override
    public void onPullUpToRefresh(int currentPage) {
        getHouseList(currentPage);
    }
}
