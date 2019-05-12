package com.learn.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author fengjie
 * @version 1.0
 * @date Created in 2019/5/12 17:55
 */
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@Data
public class Dept implements Serializable {
    /**
     * 主键
     */
    private Long  deptno;
    /**
     * 部门名称
     */
    private String  dname;
    /**
     * 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
     */
    private String  db_source;
}
