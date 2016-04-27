package cn.edu.swjtu.laundrybutler.entity;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Commodity {
    private int ID;
    private String commodityName;
    private float commodityPrice;
    private String commodityBriefIntroduction;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setCommodityName(String commodityName) {
        this.commodityName = commodityName;
    }

    public void setCommodityPrice(float commodityPrice) {
        this.commodityPrice = commodityPrice;
    }

    public void setCommodityBriefIntroduction(String commodityBriefIntroduction) {
        this.commodityBriefIntroduction = commodityBriefIntroduction;
    }

    public int getID() {
        return ID;
    }

    public String getCommodityName() {
        return commodityName;
    }

    public float getCommodityPrice() {
        return commodityPrice;
    }

    public String getCommodityBriefIntroduction() {
        return commodityBriefIntroduction;
    }
}
