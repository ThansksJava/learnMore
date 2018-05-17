package com.cnpc.sss.mybatis.controller;

import com.cnpc.sss.mybatis.model.Chorus;
import com.cnpc.sss.mybatis.service.ChorusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/17
 * @Time 11:27
 */
@RestController
@RequestMapping("/chorus")
public class ChorusController {
    @Autowired
    private ChorusService chorusService;
    @RequestMapping("/addChorus")
    public String addChorus(){
        Chorus chorus = new Chorus();
        chorus.setId("qwertyuiopasdfghjklzxcvbnm1234");
        chorus.setChrousname("richfit");
        chorus.setMembernum(24);
        chorus.setStatus("1");
        chorus.setVoicepartnum(4);
        return chorusService.addChorus(chorus)?"success":"failure";
    }
}
