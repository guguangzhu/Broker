package com.toda.broker.util;

import com.toda.broker.R;
import com.toda.broker.fragment.ClientListFragment;
import com.toda.broker.fragment.MessageFragment;
import com.toda.broker.fragment.MineFragment;
import com.toda.broker.fragment.SecondHouseListFragment;


public class TabDb {
	public static String[] getTabsTxt(){
		String[] tabs={"消息","二手房源","客户","我的"};
		return tabs;
	}
	public static int[] getTabsImg(){
		int[] ids={R.mipmap.ic_message_nor,R.mipmap.ic_house_nor,R.mipmap.ic_client_nor,R.mipmap.ic_mine_nor};
		return ids;
	}
	public static int[] getTabsImgLight(){
		int[] ids={R.mipmap.ic_message_selected,R.mipmap.ic_house_selected,R.mipmap.ic_client_selected, R.mipmap.ic_mine_selected};
		return ids;
	}
	public static Class[] getFragments(){
		Class[] clz={MessageFragment.class,SecondHouseListFragment.class,ClientListFragment.class,MineFragment.class};
		return clz;
	}
}
