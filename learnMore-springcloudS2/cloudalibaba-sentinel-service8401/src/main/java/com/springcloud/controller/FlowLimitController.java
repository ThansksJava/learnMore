package com.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Feng Jie
 * @date 2021/11/24 14:49
 */
@RestController
@Slf4j
public class FlowLimitController {
    @GetMapping("/testA")
    public String testA() {
        return "------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        log.info("------testB");
        return "------testB";
    }

    /**
     * blockHandler = "dealHandler_testHotKey",不写会导致使用默认的报错处理
     * <p>
     * Whitelabel Error Page
     * This application has no explicit mapping for /error, so you are seeing this as a fallback.
     * Mon Nov 29 11:10:46 CST 2021
     * There was an unexpected error (type=Internal Server Error, status=500).
     * </p>
     *
     * @param p1
     * @param p2
     * @return
     */
    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey", blockHandler = "dealHandler_testHotKey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2) {
        return "------testHotKey";
    }

    public String dealHandler_testHotKey(String p1, String p2, BlockException exception) {
        return "-----dealHandler_testHotKey o(╥﹏╥)o";
    }


}
