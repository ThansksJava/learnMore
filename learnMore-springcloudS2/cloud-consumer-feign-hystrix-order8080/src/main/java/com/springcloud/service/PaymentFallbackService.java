package com.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @author Feng Jie
 * @date 2021/11/16 16:03
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_OK(Integer id) {
        return "paymentInfo_OK 调用失败";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "paymentInfo_TimeOut 调用失败";
    }
}
