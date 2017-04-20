package cn.crm.web.controller;

import cn.crm.dao.userDao;
import cn.crm.domain.User;
import cn.crm.service.impl.loginServiceImpl;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.SQLException;
import java.util.Map;

/**
 * Created by LEMON on 2017/4/19.
 */

@Controller
public class businessHandler {

    private loginServiceImpl service;

    @Autowired
    public void setService(loginServiceImpl service) {
        this.service = service;
    }

    private userDao userDao;
    @Autowired
    public void setUserDao(userDao userDao) {
        this.userDao = userDao;
    }

    @RequestMapping("/login.action")
    public ModelAndView login(User user){
        ModelAndView modelAndView = new ModelAndView();

        Map map = service.login(user);
        if (map != null) {
            modelAndView.addObject("user", map.get("user"));
            modelAndView.addObject("firstList", map.get("firstlist"));
            modelAndView.addObject("menuMap", map.get("menuMap"));
            modelAndView.setViewName("/index.jsp");
        } else {
            modelAndView.addObject("message", "³ö´íÀ²");
            modelAndView.setViewName("/manger/message.jsp");
        }
        return modelAndView;
    }

    @RequestMapping("/employee.action")
    public @ResponseBody User testAjax() throws SQLException {
        return userDao.getUserById("1");
    }
}
