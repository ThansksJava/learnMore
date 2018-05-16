package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Music;

public interface MusicMapper {
    int deleteByPrimaryKey(String id);

    int insert(Music record);

    int insertSelective(Music record);

    Music selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Music record);

    int updateByPrimaryKey(Music record);
}