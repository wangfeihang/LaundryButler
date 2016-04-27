package cn.edu.swjtu.laundrybutler.entity;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Shop {
    private int ID;
    private String shopName;
    private String shopBriefIntroduction;
    private String shopBitmapURL;
    private int sales;
    private int star;

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getSales() {
        return sales;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public int getStar() {
        return star;
    }

    public String getShopBitmapURL() {
        return shopBitmapURL;
    }

    public String getShopBriefIntroduction() {
        return shopBriefIntroduction;
    }

    public String getShopName() {
        return shopName;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public void setShopBriefIntroduction(String shopBriefIntroduction) {
        this.shopBriefIntroduction = shopBriefIntroduction;
    }

    public void setShopBitmapURL(String shopBitmapURL) {
        this.shopBitmapURL = shopBitmapURL;
    }
}
