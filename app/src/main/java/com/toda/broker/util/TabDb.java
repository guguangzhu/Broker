package com.toda.broker.util;

import com.toda.broker.R;
import com.toda.broker.fragment.ClientListFragment;
import com.toda.broker.fragment.MessageFragment;


public class TabDb {
	public static String[] getTabsTxt(){
		String[] tabs={"消息","二手房源","客户","我的"};
		return tabs;
	}
	public static int[] getTabsImg(){
		int[] ids={R.mipmap.foot_news_normal,R.mipmap.foot_read_normal,R.mipmap.foot_vdio_normal,R.mipmap.foot_out_normal};
		return ids;
	}
	public static int[] getTabsImgLight(){
		int[] ids={R.mipmap.foot_news_light,R.mipmap.foot_read_light,R.mipmap.foot_vdio_light, R.mipmap.foot_out_light};
		return ids;
	}
	public static Class[] getFragments(){
		Class[] clz={MessageFragment.class,MessageFragment.class,ClientListFragment.class,MessageFragment.class};
		return clz;
	}
}
