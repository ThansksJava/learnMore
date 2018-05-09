package com.cnpc.sss.service.impl;

import com.cnpc.sss.dao.SysUserDao;
import com.cnpc.sss.domain.auth.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/9
 * @Time 14:59
 */
@Service
public class UserServiceImpl implements UserDetailsService{
    @Autowired
    private SysUserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser user = userDao.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("用户名不存在");
        }
        return user;
    }
}
