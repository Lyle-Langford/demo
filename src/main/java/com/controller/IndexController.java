package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: Lyle
 * @date: 2020/12/9
 * @description:
 **/
@Controller
@RequestMapping
public class IndexController {

    @RequestMapping
    public String index(){
        return "index";
    }
}
