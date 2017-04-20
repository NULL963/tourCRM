package cn.crm.service.impl;

import cn.crm.dao.menuDao;
import cn.crm.dao.userDao;
import cn.crm.domain.Pub_menu;
import cn.crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.ManagedMap;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LEMON on 2017/4/16.
 */
@Service
public class loginServiceImpl {
    private userDao userDao;


    private menuDao menuDao;
    @Autowired
    public void setMenuDao(cn.crm.dao.menuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Autowired
    public void setUserDao(cn.crm.dao.userDao userDao) {
        this.userDao = userDao;
    }

    public Map<String, Object> login(User user) {
        List<Pub_menu> firstMenu = new ArrayList<Pub_menu>();
        List<Pub_menu> secondMenu = null;
        Map<String, List<Pub_menu>> menuMap = new HashMap<String, List<Pub_menu>>();
        Map<String,Object> map = new HashMap<String, Object>();
        User getUser = null;
        String name = "";
        try {
            getUser = userDao.getUserByName(user.getName());
            if (user.getPassword().equals(getUser.getPassword())) {
                map.put("user", user);
                List<Pub_menu> list = menuDao.getAllMenu();
                for (Pub_menu menu : list) {
                    if (menu.getDepth() == 1) {
                        firstMenu.add(menu);
                        name = menu.getText();
                        secondMenu = new ArrayList<Pub_menu>();
                        menuMap.put(name, secondMenu);
                    } else {
                        secondMenu = menuMap.get(name);
                        secondMenu.add(menu);
                        map.put(name, secondMenu);
                    }
                    map.put("firstlist", firstMenu);
                    map.put("menuMap", menuMap);
                }
                return map;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
