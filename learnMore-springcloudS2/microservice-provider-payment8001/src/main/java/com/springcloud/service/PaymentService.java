package com.springcloud.service;

import com.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @auther fengjie
 */
public interface PaymentService {
    int create(Payment payment);

    Payment getPaymentById(@Param("id") Long id);

}
 
 

