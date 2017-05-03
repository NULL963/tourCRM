package test;

import cn.crm.domain.Employee;
import cn.crm.domain.User;
import cn.crm.service.impl.LoginServiceImpl;
import cn.crm.service.impl.SystemMangeServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by LEMON on 2017/4/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class userServiceTest {
    @Test
    public void getall(){
        SystemMangeServiceImpl service = new SystemMangeServiceImpl();
        service.getAllUser();
    }
    @Test
    public void test(){
        LoginServiceImpl service = new LoginServiceImpl();
        User user = new User();
        user.setPassword("63396931");
        user.setId("2");
        user.setName("Íõ¸Õ");
        user.setDescription("nothing");
        Employee employee = new Employee();
        employee.setId("1");
        user.setEmployee(employee);
        service.login(user);
    }
}
