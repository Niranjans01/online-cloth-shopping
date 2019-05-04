package com.niranjan.onlinecloths;

public class ItemModel {

    private String itemname;
    private int itemimagename;
    private String itemdescription;
    private String itemprice;


    public ItemModel(String itemname, int itemimagename, String itemdescription, String itemprice) {
        this.itemname = itemname;
        this.itemimagename = itemimagename;
        this.itemdescription = itemdescription;
        this.itemprice = itemprice;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public int getItemimagename() {
        return itemimagename;
    }

    public void setItemimagename(int itemimagename) {
        this.itemimagename = itemimagename;
    }

    public String getItemdescription() {
        return itemdescription;
    }

    public void setItemdescription(String itemdescription) {
        this.itemdescription = itemdescription;
    }

    public String getItemprice() {
        return itemprice;
    }

    public void setItemprice(String itemprice) {
        this.itemprice = itemprice;
    }

}
