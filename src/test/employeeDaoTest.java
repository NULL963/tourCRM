package test;

import cn.crm.dao.impl.EmployeeDaoImpl;
import cn.crm.domain.Department;
import cn.crm.domain.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by LEMON on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class employeeDaoTest {
    @Test
    public void testinsert(){
        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("帐篷");
        employee.setEmail("123");
        employee.setGender("1");
        employee.setJob("经理");
        employee.setHireDate(new Date());
        employee.setDepartment_id("1");
        Department department = new Department();
        department.setId("1");
        employee.setDepartment(department);
        employee.setSalary(123);
        employee.setPhone("123");
        employee.setQq("123");
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.save(employee);
    }

    @Test
    public void testupdate() {
        Employee employee = new Employee();
        employee.setId("2");
        employee.setName("帐篷");
        employee.setEmail("123");
        employee.setGender("1");
        employee.setJob("经理");
        employee.setHireDate(new Date());
        employee.setDepartment_id("1");
        Department department = new Department();
        department.setId("1");
        employee.setDepartment(department);
        employee.setSalary(123);
        employee.setPhone("123");
        employee.setQq("321");
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.update(employee);
    }

    @Test
    public void deleteTest() {
        Employee employee = new Employee();
        employee.setId("2");
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        employeeDao.delete(employee.getId());

    }

    @Test
    public void getByname() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.getEmployeeByName("帐篷");
    }
    @Test
    public void getByid() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        Employee employee = employeeDao.getEmployeeById("2");
    }

    @Test
    public void getAll() {
        EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
        List employee = employeeDao.getAllEmployee();
    }
}
