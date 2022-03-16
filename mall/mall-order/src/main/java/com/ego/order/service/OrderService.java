package com.ego.order.service;

import com.ego.commons.ResponseData.StatusData;
import com.ego.domain.Cart;
import com.ego.order.domain.MyOrderParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @description：order服务接口
 * @modified By：
 * @version: $
 */
public interface OrderService {

    List<Cart> getCartList(List<Long> ids, HttpServletRequest request);

    StatusData creatOrder(MyOrderParam myOrderParam, HttpServletRequest request);

}
