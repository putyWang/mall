package org.example.domain;

import java.util.Objects;

public class Sale {
    private Integer id;
    private String goodId;
    private Integer num;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodId() {
        return goodId;
    }

    public void setGoodId(String goodId) {
        this.goodId = goodId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sale)) return false;
        Sale order = (Sale) o;
        return Objects.equals(id, order.id) && Objects.equals(goodId, order.goodId) && Objects.equals(num, order.num);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, goodId, num);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", goodId='" + goodId + '\'' +
                ", num=" + num +
                '}';
    }
}
