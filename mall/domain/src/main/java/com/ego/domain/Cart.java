package com.ego.domain;

import java.util.Arrays;

/**
 * @description：购物车商品类
 * @modified By：
 * @version: $
 */
public class Cart {
    private long id;
    private String title;
    private long price;
    private int num;
    private String[] images;
    private boolean enough;

    public boolean isEnough() {
        return enough;
    }

    public void setEnough(boolean enough) {
        this.enough = enough;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", images=" + Arrays.toString(images) +
                ", enough=" + enough +
                '}';
    }
}
