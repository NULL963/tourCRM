package test;

import cn.crm.dao.OrderDao;
import cn.crm.dao.impl.CustomerDaoImpl;
import cn.crm.dao.impl.OrderDaoImpl;
import cn.crm.domain.Customer;
import cn.crm.domain.Order;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * OrderDaoImpl 的测试类已完成测验无明显异常
 * Created by LEMON on 2017/5/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class OrderDaoTest {
    @Test
    public void add() {
        OrderDao dao = new OrderDaoImpl();
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        Order order = new Order();
        order.setId(webUtils.getUUID());
        order.setCustomer_number("1");
        Customer customer = customerDao.getCustomerById("ebb2af5f6de44a579ffa9e24785ab8b1");
        Set<Customer> set = new HashSet<Customer>();
        set.add(customer);
        order.setCustomerSet(set);
        order.setGo_off_time(new Date());
        order.setEnd_time(new Date());

        dao.save(order);

    }

    @Test
    public void udpate() {
        OrderDao dao = new OrderDaoImpl();
        CustomerDaoImpl customerDao = new CustomerDaoImpl();
        Order order = new Order();
        order.setId("11d77a1295db47428fe1b9c6b48ee64b");
        order.setCustomer_number("1");
        order.setConditions("1");
        Customer customer = customerDao.getCustomerById("ebb2af5f6de44a579ffa9e24785ab8b1");
        Set<Customer> set = new HashSet<Customer>();
        set.add(customer);
        order.setCustomerSet(set);
        order.setGo_off_time(new Date());
        order.setEnd_time(new Date());

        dao.update(order);
    }

    @Test
    public void getById() {
        OrderDao dao = new OrderDaoImpl();
        Order order = dao.getById("11d77a1295db47428fe1b9c6b48ee64b");
    }

    @Test
    public void getAll() {
        OrderDao dao = new OrderDaoImpl();
        List list = dao.getAll();
    }

    @Test
    public void remove() {
        OrderDao dao = new OrderDaoImpl();
        dao.remove("11d77a1295db47428fe1b9c6b48ee64b");

    }
}
