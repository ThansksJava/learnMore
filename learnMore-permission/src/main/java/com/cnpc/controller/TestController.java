package com.cnpc.controller;

import com.cnpc.common.ApplicationContextHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private Logger logger = LoggerFactory.getLogger(TestController.class);
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
        TestController tes = applicationContextHelper.getBean(TestController.class);
        logger.info(tes.toString());
    }

}
