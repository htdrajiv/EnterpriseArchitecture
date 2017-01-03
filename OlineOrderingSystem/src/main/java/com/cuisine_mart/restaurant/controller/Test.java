package com.cuisine_mart.restaurant.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Rajiv on 8/25/2016.
 */
@Controller
public class Test {
    @RequestMapping("/user/testUrl")
    public String testView(ModelMap modelMap){
        modelMap.addAttribute("message", "from user");
        return "demo";
    }


    @RequestMapping("/admin/testUrl")
    public String testView1(ModelMap modelMap){
        modelMap.addAttribute("message", "from admin");
        return "demo";
    }

}
