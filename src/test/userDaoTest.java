package test;

import cn.crm.dao.UserDao;
import cn.crm.dao.impl.UserDaoImpl;
import cn.crm.domain.Employee;
import cn.crm.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/4/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class userDaoTest {

    @Test
    public void testInsert() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setPassword("63396931");
        user.setId("2");
        user.setName("Íõ¸Õ");
        user.setDescription("nothing");
        Employee employee = new Employee();
        employee.setId("1");
        user.setEmployee(employee);

        dao.save(user);

    }
    @Test
    public void testUpdate() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = new User();
        user.setPassword("63396931");
        user.setId("2");
        user.setName("Íõ¸Õ");
        user.setDescription("a little");
        Employee employee = new Employee();
        employee.setId("1");
        user.setEmployee(employee);
        dao.update(user);
    }
    @Test
    public void testDelete() throws SQLException {
        UserDao dao = new UserDaoImpl();

        dao.delete("2");
    }
    @Test
    public void testgetByName() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserByName("Íõ¸Õ");
        System.out.println(user.getPassword());

    }
    @Test
    public void testgetById() throws SQLException {
        UserDao dao = new UserDaoImpl();
        User user = dao.getUserById("1");
        System.out.println(user.getPassword());
    }
    @Test
    public void testGetAll() throws SQLException {
        UserDao dao = new UserDaoImpl();
        List<User> list = dao.getAllUser();
    }
}
