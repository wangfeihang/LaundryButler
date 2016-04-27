package cn.edu.swjtu.laundrybutler.entity;

/**
 * Created by Administrator on 2016/4/27.
 */
public class Comment {
    private int ID;
    private int userID;
    private int shopID;
    private int star;
    private String content;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public int getUserID() {
        return userID;
    }

    public int getShopID() {
        return shopID;
    }

    public int getStar() {
        return star;
    }

    public String getContent() {
        return content;
    }
}
