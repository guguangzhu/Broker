package com.toda.broker.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.lzy.imagepicker.ImagePicker;
import com.lzy.imagepicker.bean.ImageItem;
import com.lzy.imagepicker.ui.ImageGridActivity;
import com.toda.broker.R;
import com.toda.broker.bean.UserBean;
import com.toda.broker.model.RequestParams;
import com.toda.broker.model.ResultData;
import com.toda.broker.statics.ErrorTips;
import com.toda.broker.statics.Task;
import com.toda.broker.util.HandlerRequestErr;
import com.toda.broker.util.Iconfig;
import com.toda.broker.view.ErrLayout;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import okhttp3.Call;

/**
 * Created by guugangzhu on 2016/12/21.
 */

public class MineFragment extends BaseFragment {
    UserBean userBean;
    public static final int CHOOSE_PIC=111;

    @BindView(R.id.lv_logo)
    CircleImageView lvLogo;
    @BindView(R.id.ll_my_logo)
    LinearLayout llMyLogo;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.ll_name)
    LinearLayout llName;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_age)
    TextView tvAge;
    @BindView(R.id.tv_level)
    ImageView tvLevel;
    @BindView(R.id.tv_company)
    TextView tvCompany;
    @BindView(R.id.tv_working_id)
    TextView tvWorkingId;
    @BindView(R.id.tv_start_year)
    TextView tvStartYear;
    @BindView(R.id.err_profile)
    ErrLayout errProfile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        getUserInfo();
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView(View view) {

    }

    @Override
    protected void onPreAndVisible() {
        super.onPreAndVisible();

    }

    /***
     * 获取信息
     */
    private void getUserInfo() {
        RequestParams params = new RequestParams(Iconfig.URL_GET_USER_INFO);
        startRequest(Task.USER_INFO, params, UserBean.class);
    }


    @Override
    public void onRefresh(Call call, int tag, ResultData data) {
        super.onRefresh(call, tag, data);
        switch (tag) {
            case Task.USER_INFO:
                if (HandlerRequestErr.handlerEmptyViewErr(getContext(),errProfile,data)) {
                    userBean = (UserBean) data.getData();
                    if (userBean == null) {
                        toast(ErrorTips.DATA_ERR);
                        return;
                    }
                    setUI();
                }
        }
    }

    /**
     *
     */
    private void setUI() {
        tvName.setText(userBean.getOperatorName());
        tvPhone.setText(userBean.getTel());
        tvAge.setText(userBean.getAge()+"");
        tvCompany.setText(userBean.getMediatorName());
        tvWorkingId.setText(userBean.getJobNumber());
        tvStartYear.setText(userBean.getJobYear());
//        Glide.with(getContext())
//                .load("http://inthecheesefactory.com/uploads/source/glidepicasso/cover.jpg")
//                .into(lvLogo);
        Glide.with(getContext())
                .load(userBean.getLogo())
                .into(lvLogo);
    }

    @OnClick({R.id.ll_my_logo, R.id.err_profile})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_my_logo:{
                ImagePicker.getInstance().setMultiMode(false);
                Intent intent = new Intent(getContext(), ImageGridActivity.class);
                startActivityForResult(intent, CHOOSE_PIC);
            }
                break;
            case R.id.err_profile:
                getUserInfo();
                break;
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == ImagePicker.RESULT_CODE_ITEMS) {
            if (data != null && requestCode == CHOOSE_PIC) {
                ArrayList<ImageItem> images = (ArrayList<ImageItem>) data.getSerializableExtra(ImagePicker.EXTRA_RESULT_ITEMS);
            } else {
                Toast.makeText(getContext(), "没有数据", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
