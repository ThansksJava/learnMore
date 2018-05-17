package com.cnpc.sss.mybatis.dao;

import com.cnpc.sss.mybatis.model.Attendance;

public interface AttendanceDao {
    int deleteByPrimaryKey(String id);

    int insert(Attendance record);

    int insertSelective(Attendance record);

    Attendance selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Attendance record);

    int updateByPrimaryKey(Attendance record);
}