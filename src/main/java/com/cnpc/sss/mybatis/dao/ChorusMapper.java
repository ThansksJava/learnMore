package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Chorus;

public interface ChorusMapper {
    int deleteByPrimaryKey(String id);

    int insert(Chorus record);

    int insertSelective(Chorus record);

    Chorus selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Chorus record);

    int updateByPrimaryKey(Chorus record);
}