package com.winer.broker.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by guugangzhu on 2016/11/1.
 */

public abstract class BaseFragment extends Fragment {

    public abstract void initView(View view);
}
