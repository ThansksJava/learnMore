package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.RolePermission;

public interface RolePermissionMapper {
    int insert(RolePermission record);

    int insertSelective(RolePermission record);
}