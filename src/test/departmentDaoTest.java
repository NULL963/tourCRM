package test;

import cn.crm.dao.impl.DepartmentDaoImpl;
import cn.crm.domain.Department;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by LEMON on 2017/5/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class departmentDaoTest {
    @Test
    public void testGetALl() {
        DepartmentDaoImpl dao = new DepartmentDaoImpl();
        List<Department> list = dao.getAllDepartment();
    }

    @Test
    public void testUpdate(){
    }
}
