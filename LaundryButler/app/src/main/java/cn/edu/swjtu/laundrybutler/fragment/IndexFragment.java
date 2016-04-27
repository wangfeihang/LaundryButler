package cn.edu.swjtu.laundrybutler.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.edu.swjtu.laundrybutler.R;
import cn.edu.swjtu.laundrybutler.adapter.FragmentAdapter;

public class IndexFragment extends Fragment {

	Context context;
	ShopListFragment shopListFragment1=new ShopListFragment(context);
	ShopListFragment shopListFragment2=new ShopListFragment(context);
	ShopListFragment shopListFragment3=new ShopListFragment(context);


	public IndexFragment(Context context){this.context=context;}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view=inflater.inflate(R.layout.fragment_index, container, false);
		init(view);
		return view;
	}

	private void init(View view) {
		ViewPager mPageVp = (ViewPager) view.findViewById(R.id.id_page_vp);



		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(shopListFragment1);
		fragmentList.add(shopListFragment2);
		fragmentList.add(shopListFragment3);
		List<String> fragmentTitles = new ArrayList<>();
		fragmentTitles.add("距离");
		fragmentTitles.add("星级");
		fragmentTitles.add("销量");
		FragmentAdapter mFragmentAdapter = new FragmentAdapter(getChildFragmentManager(), fragmentList,fragmentTitles);
		mPageVp.setAdapter(mFragmentAdapter);
		mPageVp.setCurrentItem(1);

		TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabs);
		tabLayout.setupWithViewPager(mPageVp);
		tabLayout.setTabMode(TabLayout.MODE_FIXED);

	}
}
