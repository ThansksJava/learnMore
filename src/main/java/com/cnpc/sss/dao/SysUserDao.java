package com.cnpc.sss.dao;

import com.cnpc.sss.domain.auth.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/9
 * @Time 14:56
 */
public interface SysUserDao extends JpaRepository<SysUser,String> {
    SysUser  findByUsername(String username);
}
