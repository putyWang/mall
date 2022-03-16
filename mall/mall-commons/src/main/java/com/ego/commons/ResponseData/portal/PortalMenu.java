package com.ego.commons.ResponseData.portal;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/*
 * portal最终需要的数据格式
 * */
public class PortalMenu implements Serializable {

    private List<Object> data;

    public Object getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "PortalMenu{" +
                "data=" + data +
                '}';
    }
}
