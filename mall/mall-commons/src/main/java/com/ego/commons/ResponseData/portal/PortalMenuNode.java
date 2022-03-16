package com.ego.commons.ResponseData.portal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/*
* 每个节点类型
* */
public class PortalMenuNode implements Serializable {

    private String u;
    private String n;
    private List<Object> i;

    public String getU() {
        return u;
    }

    public void setU(String u) {
        this.u = u;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List<Object> getI() {
        return i;
    }

    public void setI(List<Object> i) {
        this.i = i;
    }

    @Override
    public String toString() {
        return "PortalMenuNode{" +
                "u=" + u +
                ", n=" + n +
                ", i=" + i +
                '}';
    }
}
