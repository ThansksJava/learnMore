package com.learn.miaosha.dao;

import com.learn.miaosha.entity.Customer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author fengjie
 * @version 1.0
 * @date 2019/7/6
 */
@Mapper
public interface CustomerDao {
    @Insert("insert into customer(customer_id,customer_name) values('${customerId}','${customerName}')")
    void add(Customer customer);
}
