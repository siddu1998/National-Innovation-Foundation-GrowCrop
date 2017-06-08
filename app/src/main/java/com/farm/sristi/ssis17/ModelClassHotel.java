package com.farm.sristi.ssis17;

/**
 * Created by pc on 6/1/2017.
 */

public class ModelClassHotel {
    String price,image,title,phone,image1,image2,image3,image4,image5;

    public ModelClassHotel(String price,String title, String phone) {
        this.price = price;
        this.title = title;
        this.phone = phone;
    }
    public ModelClassHotel()
    {}

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}


