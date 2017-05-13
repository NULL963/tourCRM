package cn.crm.web.controller;

import cn.crm.domain.User;
import cn.crm.service.impl.LoginServiceImpl;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
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
    public String loginAfter(User user, HttpSession session){
        ModelAndView modelAndView = new ModelAndView();
        user = service.login(user);
        if (user != null) {
            session.setAttribute("username", user.getName());
            session.setAttribute("userId", user.getId());
            return "redirect:/index.jsp";
        } else {
            return "redirect:/manger/login.jsp";
        }
    }
//    @RequestMapping("/employee.action")
//    public ModelAndView employee() {
//        ModelAndView modelAndView = new ModelAndView();
//
//        return modelAndView;
//    }

}
