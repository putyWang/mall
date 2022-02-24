package com.ego.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
    @GetMapping("/item-add")
    public String itemAdd(){
        return "item-add";
    }
    @GetMapping("/item-list")
    public String itemList(){
        return "item-list";
    }
//    @GetMapping("/item-param-list")
//    public String itemParamList(){
//        return "item-param-list";
//    }
    @GetMapping("/index")
    public String index(){
        return "index";
    }
    @GetMapping("/content-category")
    public String contentCategory(){
        return "content-category";
    }
    @GetMapping("/content")
    public String content(){
        return "content";
    }
}
