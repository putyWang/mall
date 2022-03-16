package com.ego.cart.service.serviceImpl;

import com.ego.domain.Cart;
import com.ego.cart.service.CartService;
import com.ego.commons.ResponseData.StatusData;
import com.ego.commons.utils.CookieUtils;
import com.ego.commons.utils.JsonUtils;
import com.ego.domain.TbItem;
import com.ego.domain.TbUser;
import com.ego.service.DubboRedisManageService;
import com.ego.service.ListService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2022/3/9 14:49
 * @description：
 * @modified By：
 * @version: $
 */
@Service
public class CartServiceImpl implements CartService {

    @DubboReference(interfaceClass = DubboRedisManageService.class, version = "1.0")
    private DubboRedisManageService dubboRedisManageService;

    @DubboReference(interfaceClass = ListService.class, version = "1.0")
    private ListService listService;

    @Value("${cart.key}")
    private String cartKey;

    @Override
    public void add(long itemId, int num, HttpServletRequest request, HttpServletResponse response) {
        List<Cart> cartList = new ArrayList<>();
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        String username = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        String cartKeyRedis = cartKey + ":" + username;
        if(dubboRedisManageService.redisExist(cartKeyRedis)){
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);
            if(cartListString != null && cartListString != ""){
                boolean itemIsExit = false;
                cartList = JsonUtils.jsonToList(cartListString, Cart.class);
                for (Cart cart: cartList) {
                    if(cart.getId() == itemId){
                        cart.setNum(cart.getNum() + num);
                        itemIsExit = true;
                        break;
                    }
                }
                if(itemIsExit){
                    JsonUtils.objectToJson(cartList);
                    dubboRedisManageService.redisSetTbContent(cartKeyRedis, JsonUtils.objectToJson(cartList));
                    return;
                }
            }
        }
        TbItem tb = listService.findTbItemById(itemId);
        Cart cart = new Cart();
        cart.setId(itemId);
        cart.setNum(num);
        cart.setPrice(tb.getPrice());
        cart.setTitle(tb.getTitle());

        if(tb.getImage() != null && tb.getImage() != "")
            cart.setImages(tb.getImage().split(","));
        else
            cart.setImages(new String[]{});

        cartList.add(cart);
        dubboRedisManageService.redisSetTbContent(cartKeyRedis, JsonUtils.objectToJson(cartList));
    }

    @Override
    public List<Cart> showCart(HttpServletRequest request) {
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        String username = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        String cartKeyRedis = cartKey + ":" + username;
        if(dubboRedisManageService.redisExist(cartKeyRedis)){
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);
            if(cartListString != null && cartListString != "") {
                List<Cart> cartList = JsonUtils.jsonToList(cartListString, Cart.class);
                return cartList;
            }
        }
        return null;
    }

    @Override
    public StatusData updateChart(long itemId, int num, HttpServletRequest request) {
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        StatusData data = new StatusData();
        String username = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        String cartKeyRedis = cartKey + ":" + username;
        boolean success = false;
        if(dubboRedisManageService.redisExist(cartKeyRedis)){
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);
            List<Cart> cartList = JsonUtils.jsonToList(cartListString, Cart.class);
            if(cartListString != null && cartListString != "") {
                for (Cart cart: cartList) {
                    if(cart.getId() == itemId){
                        cart.setNum(num);
                        success = true;
                    }
                }
                JsonUtils.objectToJson(cartList);
                dubboRedisManageService.redisSetTbContent(cartKeyRedis, JsonUtils.objectToJson(cartList));
            }
        }
        if(success){
            data.setStatus(200);
        }
        return data;
    }

    @Override
    public StatusData delete(long itemId, HttpServletRequest request) {
        String userKey = CookieUtils.getCookieValue(request, "TT_TOKEN");
        StatusData data = new StatusData();
        String username = JsonUtils.jsonToPojo(dubboRedisManageService.redisGetTbContentByKey(userKey), TbUser.class).getUsername();
        String cartKeyRedis = cartKey + ":" + username;
        boolean success = false;
        if(dubboRedisManageService.redisExist(cartKeyRedis)){
            String cartListString = dubboRedisManageService.redisGetTbContentByKey(cartKeyRedis);
            List<Cart> cartList = JsonUtils.jsonToList(cartListString, Cart.class);
            if(cartListString != null && cartListString != "") {
                for (int i = 0; i < cartList.size(); i++) {
                    if (cartList.get(i).getId() == itemId){
                        cartList.remove(i);
                        success = true;
                    }
                }
                JsonUtils.objectToJson(cartList);
                dubboRedisManageService.redisSetTbContent(cartKeyRedis, JsonUtils.objectToJson(cartList));
            }
        }
        if(success)
            data.setStatus(200);
        return data;
    }
}
