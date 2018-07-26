package com.cnpc.ehcache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/7/18
 * @Time 15:17
 */
@RestController
public class LogController {
    private final static Logger log = LoggerFactory.getLogger(LogController.class);
    @RequestMapping("/log")
    public String testLog(){
        log.info("工作前打印1--------------------------");
        log.info("工作前打印2--------------------------");
        log.info("工作前打印3--------------------------");
        log.info("工作前打印4--------------------------");
        log.info("工作前打印5--------------------------");
        log.info("工作前打印6--------------------------");
        log.info("工作前打印7--------------------------");
        System.out.println("工作中。。。。。。。。。。");
        log.info("工作后打印1--------------------------");
        log.info("工作后打印2--------------------------");
        log.info("工作后打印3--------------------------");
        log.info("工作后打印4--------------------------");
        log.info("工作后打印5--------------------------");
        log.info("工作后打印6--------------------------");
        log.info("工作后打印7--------------------------");
        return "success";
    }
}
