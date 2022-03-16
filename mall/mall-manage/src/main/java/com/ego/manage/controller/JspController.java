package com.ego.manage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JspController {
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
    @GetMapping("/content-add")
    public String contentAdd(){
        return "content-add";
    }
    @GetMapping("/content-edit")
    public String contentEdit(){
        return "content-edit";
    }
    @GetMapping("/file-upload")
    public String contentUpload(){
        return "file-upload";
    }
    @GetMapping("/item-add")
    public String itemAdd(){
        return "item-add";
    }
    @GetMapping("/item-edit")
    public String itemEdit(){
        return "item-edit";
    }
    @GetMapping("/item-list")
    public String itemList(){
        return "item-list";
    }
    @GetMapping("/item-param-add")
    public String itemParamAdd(){return "item-param-add";}
    @GetMapping("/item-param-list")
    public String itemParamList(){return "item-param-list";}
    @GetMapping("/login")
    public String login(){return "login";}
}
