package com.example.myapplication;
//listView列表项类
public class Item {
    private String itemname;
    private int itemimg;
    //构造函数
    public Item(String itemname, int itemimg) {
        this.itemname = itemname;
        this.itemimg = itemimg;
    }

    public String getItemname() {
        return itemname;
    }
    public int getItemimg() {
        return itemimg;
    }

};
