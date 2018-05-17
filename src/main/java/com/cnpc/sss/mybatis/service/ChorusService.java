package com.cnpc.sss.mybatis.service;

import com.cnpc.sss.mybatis.dao.ChorusDao;
import com.cnpc.sss.mybatis.model.Chorus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/17
 * @Time 11:24
 */
@Service
public class ChorusService {
    @Autowired
    private ChorusDao chorusDao;
    public boolean addChorus(Chorus chorus){
        return chorusDao.insert(chorus) > 0 ? true : false;
    }
}
