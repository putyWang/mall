package com.ego.cart.controller;

import com.ego.domain.Cart;
import com.ego.cart.service.CartService;
import com.ego.commons.ResponseData.StatusData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class CartController {

    @Resource
    private CartService cartService;
    /**
    *@Description: 向购物车中添加商品
    *@Param:
    *@return:
    */
    @RequestMapping("/cart/add/{itemId}.html")
    public String addCart(@PathVariable long itemId, @RequestParam int num, HttpServletRequest request, HttpServletResponse response){
        cartService.add(itemId, num, request, response);
        return "cartSuccess";
    }
    /**
     *@Description: 显示购物车页面
     *@Param:
     *@return:
     */
    @RequestMapping("/cart/cart.html")
    public String showCart(Model model, HttpServletRequest request){
        List<Cart> carts = cartService.showCart(request);
        model.addAttribute("cartList", carts);
        return "cart";
    }

    /**
     *@Description: 显示购物车页面
     *@Param:
     *@return:
     */
    @RequestMapping("/cart/update/num/{itemId}/{num}.action")
    @ResponseBody
    public StatusData updateChart(@PathVariable long itemId, @PathVariable int num, HttpServletRequest request){
        return cartService.updateChart(itemId, num, request);
    }

    @RequestMapping("/cart/delete/{itemId}.action")
    @ResponseBody
    public StatusData deleteChart(@PathVariable long itemId, HttpServletRequest request){
        return cartService.delete(itemId, request);
    }
}
