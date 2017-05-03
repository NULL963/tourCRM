package cn.crm.service.impl;

import cn.crm.dao.MenuDao;
import cn.crm.dao.UserDao;
import cn.crm.dao.impl.MenuDaoImpl;
import cn.crm.dao.impl.UserDaoImpl;
import cn.crm.domain.Pub_menu;
import cn.crm.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginServiceImpl {
    private UserDao userDao;


    private MenuDao menuDao;

    @Autowired
    public void setMenuDao(MenuDao menuDao) {
        this.menuDao = menuDao;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean login(User user) {
        User myUser = userDao.getUserByName(user.getName());
        if (myUser != null) {
            return true;
        }
        return false;
    }

    public Map<String, Object> getMenu() {
        List<Pub_menu> firstMenu = new ArrayList<Pub_menu>();
        List<Pub_menu> secondMenu = null;
        Map<String, List<Pub_menu>> menuMap = new HashMap<String, List<Pub_menu>>();
        Map<String, Object> map = new HashMap<String, Object>();
        String name = "";

        try {
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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
