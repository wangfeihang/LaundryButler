package cn.edu.swjtu.laundrybutler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.swjtu.laundrybutler.adapter.FragmentAdapter;
import cn.edu.swjtu.laundrybutler.fragment.IndexFragment;
import cn.edu.swjtu.laundrybutler.fragment.ShoppingCarFragment;
import cn.edu.swjtu.laundrybutler.fragment.OrderFragment;

/**
 * Created by Administrator on 2016/4/5.
 */
public class MainActivity extends FragmentActivity {



    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private ViewPager mPageVp;
    /**
     * Tab显示内容
     */
    private TextView tvHome,tvOrder,tvShoppingCar;
    private ImageView imHome,imOrder,imShoppingCar;
    private LinearLayout llayoutHome,llayoutOrder,llayoutShoppingCar;
    /**
     * Fragment
     */
    private IndexFragment mFragment1;
    private OrderFragment mFragment2;
    private ShoppingCarFragment mFragment3;
    /**
     * ViewPager的当前选中页
     */
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }


    private void init() {


        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.dl_main_drawer);
        NavigationView navigationView =
                (NavigationView) findViewById(R.id.nv_main_navigation);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(
                    new NavigationView.OnNavigationItemSelectedListener() {
                        @Override
                        public boolean onNavigationItemSelected(MenuItem menuItem) {
                            switch (menuItem.getItemId()) {
                                case R.id.nav_information:
                                    menuItem.setChecked(true);
                                    drawerLayout.closeDrawers();
                                    LoginActivity.launch(MainActivity.this);
                                 //   finish();
                                    break;
                            }
                            return true;
                        }
                    });
        }
        tvHome = (TextView) this.findViewById(R.id.tv_home);
        tvOrder = (TextView) this.findViewById(R.id.tv_order);
        tvShoppingCar = (TextView) this.findViewById(R.id.tv_shopping_car);
        imHome = (ImageView) this.findViewById(R.id.im_home);
        imOrder = (ImageView) this.findViewById(R.id.im_order);
        imShoppingCar = (ImageView) this.findViewById(R.id.im_shopping_car);
        llayoutHome=(LinearLayout)this.findViewById(R.id.llayout_home);
        llayoutOrder=(LinearLayout)this.findViewById(R.id.llayout_order);
        llayoutShoppingCar=(LinearLayout)this.findViewById(R.id.llayout_shopping_car);
        mPageVp = (ViewPager) this.findViewById(R.id.id_page_vp);
        mFragment1=new IndexFragment(MainActivity.this);
        mFragment2=new OrderFragment();
        mFragment3=new ShoppingCarFragment();
        mFragmentList.add(mFragment1);
        mFragmentList.add(mFragment2);
        mFragmentList.add(mFragment3);
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList,null);
        mPageVp.setAdapter(mFragmentAdapter);
        mPageVp.setCurrentItem(0);
        setPressed(0);
        setClickListener(llayoutHome, 0);
        setClickListener(llayoutOrder,1);
        setClickListener(llayoutShoppingCar,2);
    }

    private void setClickListener(LinearLayout linearlayout,final int i)
    {
        linearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPageVp.getCurrentItem() != i) {
                    reset();
                    setPressed(i);
                    mPageVp.setCurrentItem(i);
                }
            }
        });
    }

    /**
     * 重置颜色
     */

    private void reset() {
        tvHome.setTextColor(getResources().getColor(R.color.gray));
        tvOrder.setTextColor(getResources().getColor(R.color.gray));
        tvShoppingCar.setTextColor(getResources().getColor(R.color.gray));
        imHome.setBackgroundResource(R.drawable.tabbar_home_normal);
        imOrder.setBackgroundResource(R.drawable.tabbar_order_normal);
        imShoppingCar.setBackgroundResource(R.drawable.tabbar_shopping_car_normal);
    }
    private void setPressed(int i)
    {
        switch (i) {
            case 0:
                tvHome.setTextColor(getResources().getColor(R.color.midGreen));
                imHome.setBackgroundResource(R.drawable.tabbar_home_selected);
                break;
            case 1:
                tvOrder.setTextColor(getResources().getColor(R.color.midGreen));
                imOrder.setBackgroundResource(R.drawable.tabbar_order_selected);
                break;
            case 2:
                tvShoppingCar.setTextColor(getResources().getColor(R.color.midGreen));
                imShoppingCar.setBackgroundResource(R.drawable.tabbar_shopping_car_selected);
                break;

        }
    }
    public static void launch(Context context) {
        Intent intent = new Intent();
        intent.setClass(context, MainActivity.class);
        context.startActivity(intent);
    }








}
