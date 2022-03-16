package com.ego.service;

import com.ego.domain.TbOrder;
import com.ego.domain.TbOrderItem;
import com.ego.domain.TbOrderShipping;

import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 22:49
 * @description：订单dubbo服务接口
 * @modified By：
 * @version: $
 */
public interface DubboOrderService {

    int creatOrder(List<TbOrderItem> items, TbOrderShipping shipping, TbOrder tbOrder) throws RuntimeException;
}
