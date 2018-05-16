package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Images;

public interface ImagesMapper {
    int deleteByPrimaryKey(String id);

    int insert(Images record);

    int insertSelective(Images record);

    Images selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Images record);

    int updateByPrimaryKey(Images record);
}