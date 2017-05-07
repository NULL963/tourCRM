package test;

import cn.crm.dao.CustomerDao;
import cn.crm.dao.impl.CustomerDaoImpl;
import cn.crm.domain.Customer;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * CustomerDaoImpl的测试类 经测试crud运行良好
 * Created by LEMON on 2017/5/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class customerDaoTest {
    @Test
    public void insertTest() {
        CustomerDao dao = new CustomerDaoImpl();
        Customer customer = new Customer();
        customer.setId(webUtils.getUUID());
        customer.setEmail("123");
        customer.setName("张量");
        customer.setQq("123");
        customer.setBank_card_number("123");
        customer.setDescription("nothing");
        customer.setAddress("q123");
        customer.setNation("汉");
        customer.setBank_of_deposit("123");
        customer.setId_number("123");
        customer.setGender("1");
        customer.setPhone("123");
        dao.save(customer);
    }

    @Test
    public void update() {
        CustomerDao dao = new CustomerDaoImpl();
        Customer customer = new Customer();
        customer.setId("5502380b0e4649c1acc9425e1678fe1f");
        customer.setEmail("123");
        customer.setName("理光");
        customer.setQq("123");
        customer.setBank_card_number("123");
        customer.setDescription("nothing");
        customer.setAddress("q123");
        customer.setNation("汉");
        customer.setBank_of_deposit("123");
        customer.setId_number("123");
        customer.setGender("1");
        customer.setPhone("123");
        dao.update(customer);
    }

    @Test
    public void getByid() {
        CustomerDao dao = new CustomerDaoImpl();
        Customer customer = dao.getCustomerById("5502380b0e4649c1acc9425e1678fe1f");
    }

    @Test
    public void getByNmae() {
        CustomerDao dao = new CustomerDaoImpl();
        Customer customer = dao.getCustomerByNmae("理光");
    }

    @Test
    public void getALl() {
        CustomerDao dao = new CustomerDaoImpl();
        List<Customer> list = dao.getAllCustomer();
    }

    @Test
    public void remove() {
        CustomerDao dao = new CustomerDaoImpl();
        dao.remove("5502380b0e4649c1acc9425e1678fe1f");
    }
}
