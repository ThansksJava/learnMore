package com.learn.controller;

import com.learn.domain.ConfigPropertiesPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
/*使用此注解后属性自动注入的类不需要用@Compoment进行注解*/
@EnableConfigurationProperties(ConfigPropertiesPerson.class)
public class PersonController {
    @Autowired
    private ConfigPropertiesPerson person;
    @RequestMapping("/showPerson")
    public String showPerson(Model model){
        model.addAttribute("person",person);
        return "ShowPerson";
    }
}
