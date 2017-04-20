package test;

import cn.crm.dao.impl.userDaoImpl;
import cn.crm.dao.userDao;
import cn.crm.domain.Employee;
import cn.crm.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;

/**
 * Created by LEMON on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class userDaoTest {
    private userDao dao;

    public void setDao(userDao dao) {
        this.dao = dao;
    }

    @Test
    public void testInsert() throws SQLException {
        userDao dao = new userDaoImpl();
        User user = new User();
        ;
        user.setPassword("63396931");
        user.setId("2");
        user.setName("Íõ¸Õ");
        user.setDesc("nothing");
        Employee employee = new Employee();
        employee.setId("1");
        user.setEmployee(employee);

        dao.insert(user);

    }
    @Test
    public void testUpdate() throws SQLException {
        userDao dao = new userDaoImpl();
        User user = new User();
        user.setPassword("63396931");
        user.setId("2");
        user.setName("Íõ¸Õ");
        user.setDesc("a little");
        Employee employee = new Employee();
        employee.setId("1");
        user.setEmployee(employee);
        dao.update(user);
    }
    @Test
    public void testDelete() throws SQLException {
        userDao dao = new userDaoImpl();

        dao.delete("2");
    }
    @Test
    public void testgetByName() throws SQLException {
        userDao dao = new userDaoImpl();
        User user = dao.getUserByName("Íõ¸Õ");
        System.out.println(user.getPassword());

    }
    @Test
    public void testgetById() throws SQLException {
        userDao dao = new userDaoImpl();
        User user = dao.getUserById("1");
        System.out.println(user.getPassword());

    }
}
