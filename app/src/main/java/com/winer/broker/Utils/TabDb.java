package com.winer.broker.Utils;

import com.winer.broker.R;
import com.winer.broker.fragment.BaseFragment;


public class TabDb {
	public static String[] getTabsTxt(){
		String[] tabs={"新闻","阅读","试听","发现"," 我"};
		return tabs;
	}
	public static int[] getTabsImg(){
		int[] ids={R.mipmap.foot_news_normal,R.mipmap.foot_read_normal,R.mipmap.foot_vdio_normal,R.mipmap.foot_fond_normal,R.mipmap.foot_out_normal};
		return ids;
	}
	public static int[] getTabsImgLight(){
		int[] ids={R.mipmap.foot_news_light,R.mipmap.foot_read_light,R.mipmap.foot_vdio_light,R.mipmap.foot_found_light, R.mipmap.foot_out_light};
		return ids;
	}
	public static Class[] getFragments(){
		Class[] clz={BaseFragment.class,BaseFragment.class,BaseFragment.class,BaseFragment.class,BaseFragment.class};
		return clz;
	}
}
