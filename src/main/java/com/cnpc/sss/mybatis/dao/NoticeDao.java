package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Notice;

public interface NoticeDao {
    int deleteByPrimaryKey(String id);

    int insert(Notice record);

    int insertSelective(Notice record);

    Notice selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Notice record);

    int updateByPrimaryKey(Notice record);
}