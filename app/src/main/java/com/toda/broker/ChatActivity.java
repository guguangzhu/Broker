package com.toda.broker;

import android.os.Bundle;

import io.rong.imlib.model.Conversation;

/**
 * Created by guugangzhu on 2016/11/15.
 */

public class ChatActivity extends BaseActivity {
    /**
     * 目标 Id
     */
    private String mTargetId;

    /**
     * 刚刚创建完讨论组后获得讨论组的id 为targetIds，需要根据 为targetIds 获取 targetId
     */
    private String mTargetIds;

    /**
     * 会话类型
     */
    private Conversation.ConversationType mConversationType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
    }


    @Override
    public void initView() {

    }
}
