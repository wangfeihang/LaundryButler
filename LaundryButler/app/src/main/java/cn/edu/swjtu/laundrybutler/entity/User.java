package cn.edu.swjtu.laundrybutler.entity;

/**
 * Created by Administrator on 2016/4/27.
 */
public class User {

    private int ID;
    private String userName;
    private String passWord;
    private String email;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public String getEmail() {
        return email;
    }
}
