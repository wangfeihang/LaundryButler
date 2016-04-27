package cn.edu.swjtu.laundrybutler.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.edu.swjtu.laundrybutler.R;
import cn.edu.swjtu.laundrybutler.adapter.ShopListAdapter;

/**
 * Created by Administrator on 2016/4/26.
 */
@SuppressLint("ValidFragment")
public class ShopListFragment extends BaseFragment {

    Context mContext;


    public ShopListFragment(Context context){mContext=context;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view=inflater.inflate(R.layout.fragment_shoplist, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setStackFromEnd(true);
        ShopListAdapter shopListAdapter = new ShopListAdapter();
        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.rv_shop_list);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(shopListAdapter);
        recyclerView.scrollToPosition(shopListAdapter.getItemCount() - 1);

    }
}
