package com.ego.portal.controller;

import com.ego.portal.service.TbContentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

@Controller
public class JspController {
    @Resource
    private TbContentService tbContentServiceImpl;

    @GetMapping("/index")
    public String index(){
        return "forward:/showBigPic";
    }

    @GetMapping("/showBigPic")
    public String showBigPic(Model model){
        model.addAttribute("ad1", tbContentServiceImpl.showBigPic());
        return "index";
    }
}
