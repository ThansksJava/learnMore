package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Vedio;

public interface VedioDao {
    int deleteByPrimaryKey(String id);

    int insert(Vedio record);

    int insertSelective(Vedio record);

    Vedio selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Vedio record);

    int updateByPrimaryKey(Vedio record);
}