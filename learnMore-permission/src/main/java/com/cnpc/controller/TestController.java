package com.cnpc.controller;

import com.cnpc.common.ApplicationContextHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2018/12/19 14:57
 */
@Controller
public class TestController {
    @Autowired
    private ApplicationContextHelper applicationContextHelper;

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        return "hello,permission";
    }

    @RequestMapping("/testActH")
    @ResponseBody
    public void testActH(){
//        applicationContextHelper.
    }

}
