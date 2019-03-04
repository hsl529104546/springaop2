package com.hsl.controller;

import com.hsl.annotation.MyAspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@EnableAspectJAutoProxy
public class HelloController {
    @MyAspect
    @RequestMapping("/hello")
    @ResponseBody
    public String toHello(Model model){
//        modelAndView.addObject("hello","helloworld");
//
//        modelAndView.setViewName("hello");
//        model.addAttribute("hello","helloworld");
        return  "hello";
    }
}
