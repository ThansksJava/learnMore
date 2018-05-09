package com.cnpc.sss.controller;

import com.cnpc.sss.domain.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author fengjie
 * @Description
 * @Date Created in 2018/5/9
 * @Time 15:25
 */
@Controller
public class HomeController {
    @RequestMapping("/")
    public String index(Model model){
        Msg msg = new Msg("测试标题","测试内容","额外信息只对管理员开放");
        model.addAttribute("msg",msg);
        return "home";
    }
    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
