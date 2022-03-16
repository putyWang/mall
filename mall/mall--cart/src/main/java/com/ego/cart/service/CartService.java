package com.ego.cart.service;

import com.ego.domain.Cart;
import com.ego.commons.ResponseData.StatusData;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @description：购物车服务类
 * @modified By：
 * @version: $
 */
public interface CartService {

    void add(long itemId, int num, HttpServletRequest request, HttpServletResponse response);

    List<Cart> showCart(HttpServletRequest request);

    StatusData updateChart(long itemId, int num, HttpServletRequest request);

    StatusData delete(long itemId, HttpServletRequest request);
}
