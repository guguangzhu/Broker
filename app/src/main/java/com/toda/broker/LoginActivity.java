package com.toda.broker;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.toda.broker.model.RequestParams;
import com.toda.broker.model.ResultData;
import com.toda.broker.statics.Task;
import com.toda.broker.util.Iconfig;
import com.toda.broker.util.StringUtils;
import com.toda.broker.view.ClearableEditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.Call;

/**
 * Created by guugangzhu on 2016/12/20.
 */

public class LoginActivity extends BaseActivity {

    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.et_pwd)
    ClearableEditText etPwd;
    @BindView(R.id.ll_pwd)
    LinearLayout llPwd;
    @BindView(R.id.et_phone)
    ClearableEditText etPhone;
    @BindView(R.id.ll_username)
    LinearLayout llUsername;
    @BindView(R.id.sv_login)
    ScrollView svLogin;

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    public void initView() {
        etPhone.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                changeScrollView();
                return false;
            }
        });
    }

    /**
     * 使ScrollView指向底部
     */
    private void changeScrollView(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                svLogin.scrollTo(0, svLogin.getHeight());
            }
        }, 300);
    }
    /***
     * 登录
     */
    private void login() {
        RequestParams params = new RequestParams(Iconfig.URL_LOGIN);
        params.add("username", etPhone.getText().toString());
        params.add("password", etPwd.getText().toString());
        startRequest(Task.LOGIN, params, null);
    }

    @Override
    public void onRefresh(Call call, int tag, ResultData data) {
        super.onRefresh(call, tag, data);
        switch (tag) {
            case Task.LOGIN:
                if (handlerRequestErr(data)) {
//                    UserBean userBean = (UserBean) data.getData();
//                    if (userBean == null) {
//                        toast(ErrorTips.DATA_ERR);
//                        return;
//                    }
//                    UserUtils.saveLoginData(userBean.getToken(), userBean.getUserId() + "", userBean.getNickname(), userBean.getRealname());
//                    goPage(MainActivity.class);
//                    finish();
                }
        }
    }

    @OnClick(R.id.btn_login)
    public void onClick() {
            login();
            if(checkDate()){
        }
    }

    private boolean checkDate() {
        String phone = etPhone.getText().toString();
        if (StringUtils.isEmpty(phone)) {
            toast("请输入账号");
            return false;
        }
        String pwd = etPwd.getText().toString();
        if (StringUtils.isEmpty(phone)) {
            toast("请输入密码");
            return false;
        }
        return true;
    }
}
