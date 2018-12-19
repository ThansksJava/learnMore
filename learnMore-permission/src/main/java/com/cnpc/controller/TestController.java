package com.cnpc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/19 14:57
 */
@Controller
public class TestController {
    @RequestMapping("/test")
    public String test(){
        return "hello,permission";
    }
}
