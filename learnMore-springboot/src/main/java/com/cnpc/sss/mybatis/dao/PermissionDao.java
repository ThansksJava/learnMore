package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Permission;

public interface PermissionDao {
    int deleteByPrimaryKey(String id);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}