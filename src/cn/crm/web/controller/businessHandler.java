package cn.crm.web.controller;

import cn.crm.domain.User;
import cn.crm.service.impl.LoginServiceImpl;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by LEMON on 2017/4/19.
 */

@Controller
public class BusinessHandler {

    private LoginServiceImpl service;

    @Autowired
    public void setService(LoginServiceImpl service) {
        this.service = service;
    }

    @RequestMapping("/menu.action")
    public ModelAndView getMenu(){
        ModelAndView modelAndView = new ModelAndView();

        Map map = service.getMenu();
        if (map != null) {
            modelAndView.addObject("user", map.get("user"));
            modelAndView.addObject("firstList", map.get("firstlist"));
            modelAndView.addObject("menuMap", map.get("menuMap"));
            modelAndView.setViewName("/manger/top.jsp");
        } else {
            modelAndView.addObject("message", "没有得到menu");
            modelAndView.setViewName("/manger/message.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/login.action")
    public ModelAndView loginAfter(User user){
        ModelAndView modelAndView = new ModelAndView();
        if (service.login(user)) {
            modelAndView.setViewName("/index.jsp");
        } else {
            modelAndView.addObject("message", "出错啦");
            modelAndView.setViewName("/manger/message.jsp");
        }
        return modelAndView;
    }
//    @RequestMapping("/employee.action")
//    public ModelAndView employee() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        return modelAndView;
//    }

}
