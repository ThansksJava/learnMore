package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Rehearse;

public interface RehearseDao {
    int deleteByPrimaryKey(String id);

    int insert(Rehearse record);

    int insertSelective(Rehearse record);

    Rehearse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Rehearse record);

    int updateByPrimaryKey(Rehearse record);
}