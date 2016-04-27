package cn.edu.swjtu.laundrybutler.adapter;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import cn.edu.swjtu.laundrybutler.R;
import cn.edu.swjtu.laundrybutler.entity.Shop;


public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.MyViewHolder> {

    private List<Shop> shopList;

    public void addData(List<Shop> shopList) {
        this.shopList.addAll(shopList);
        notifyDataSetChanged();
    }

    public void test() {
        for(int i=0;i<20;i++) {
            Shop shop=new Shop();
            shop.setShopName("hahahhhhhhhhhhh");
            shop.setShopBriefIntroduction("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
            shop.setStar(5);
            shop.setSales(100);
            shopList.add(shop);
        }

    }



    public ShopListAdapter() {
        shopList = new ArrayList<>();
        test();
    }

    static class MyViewHolder extends ViewHolder {

        TextView textViewShopName;
        TextView textViewSales;
        ImageView imageViewAvatar;
        RatingBar ratingBar;
        View itemView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView=itemView;
            textViewShopName = (TextView) itemView.findViewById(R.id.tv_shop_name);
            textViewSales = (TextView) itemView.findViewById(R.id.tv_shop_sales);
            ratingBar=(RatingBar)itemView.findViewById(R.id.rb_shop_stars);
            imageViewAvatar=(ImageView)itemView.findViewById(R.id.iv_avatar);
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_shop, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.textViewShopName.setText(shopList.get(position).getShopName());

        holder.ratingBar.setRating(shopList.get(position).getStar());
        holder.textViewSales.setText(shopList.get(position).getSales()+"");
    }

    @Override
    public int getItemCount() {
        return shopList.size();
    }

}

