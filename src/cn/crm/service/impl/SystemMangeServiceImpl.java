package cn.crm.service.impl;

import cn.crm.dao.DepartmentDao;
import cn.crm.dao.EmployeeDao;
import cn.crm.dao.UserDao;
import cn.crm.dao.impl.DepartmentDaoImpl;
import cn.crm.dao.impl.EmployeeDaoImpl;
import cn.crm.dao.impl.UserDaoImpl;
import cn.crm.domain.Department;
import cn.crm.domain.Employee;
import cn.crm.domain.User;
import cn.crm.utils.webUtils;
import cn.crm.vdomain.Vemployee;
import cn.crm.vdomain.Vuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by LEMON on 2017/4/21.
 */
@Service
public class SystemMangeServiceImpl {
    private UserDao userDao;
    private EmployeeDao employeeDao;
    private DepartmentDao departmentDao;

    @Autowired
    public void setDepartmentDao(DepartmentDaoImpl departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Autowired
    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }
    @Autowired
    public void setEmployeeDao(EmployeeDaoImpl employeeDao) {
        this.employeeDao = employeeDao;
    }

    public List<Vuser> getAllUser(){
        List<User> list = userDao.getAllUser();
        List<Vuser> vusers = new ArrayList<Vuser>();
        for (User a : list) {
            a.setEmployee(employeeDao.getEmployeeById(a.getEmployee_id()));
        }
        for (User user : list) {
            Vuser vuser = new Vuser();
            vuser.setId(user.getId());
            vuser.setName(user.getName());
            vuser.setPassword(user.getPassword());
            vuser.setEmployee(user.getEmployee().getName());
            vuser.setDescription(user.getDescription());
            vusers.add(vuser);
        }
        return vusers;
    }

    public List<Employee> getAllEmployee() {
        List<Employee> list = employeeDao.getAllEmployee();
        for (Employee employee : list) {
            employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment_id()));
        }
        return list;
    }

    public User saveUser(User user) {
        user.setId(webUtils.getUUID());
        return userDao.save(user);
    }

    public User getUserById(String id) {
        User user = userDao.getUserById(id);
        user.setEmployee(employeeDao.getEmployeeById(user.getEmployee_id()));
        return user;
    }

    public void deleteUser(String id) {
        userDao.delete(id);
    }

    public void updateUser(Vuser vuser) {
        User user = new User();
        user.setId(vuser.getId());
        user.setName(vuser.getName());
        user.setPassword(vuser.getPassword());
        user.setDescription(vuser.getDescription());
        Employee employee = employeeDao.getEmployeeByName(vuser.getEmployee());
        user.setEmployee(employee);
        userDao.update(user);
    }

    public List<Department> getAllDepartment() {
        return departmentDao.getAllDepartment();
    }

    public void saveEmployee(Vemployee vemployee) {
        Employee employee = new Employee();
        employee.setId(webUtils.getUUID());
        employee.setHireDate(webUtils.parseDate(vemployee.getHiredate()));
        employee.setQq(vemployee.getQq());
        employee.setSalary(vemployee.getSalary());
        employee.setDepartment_id(vemployee.getDepartment());
        employee.setJob(vemployee.getJob());
        employee.setGender(webUtils.transGender(vemployee.getGender()));
        employee.setEmail(vemployee.getEmail());
        employee.setName(vemployee.getName());
        employee.setPhone(vemployee.getPhone());
        employee.setDepartment(departmentDao.getDepartmentById(vemployee.getDepartment()));
        employeeDao.save(employee);
    }

    public void removeEmployee(String id) {
        employeeDao.delete(id);
    }

    public void updateEmployee(Vemployee vemployee) {
        Employee employee = new Employee();
        employee.setHireDate(webUtils.parseDate(vemployee.getHiredate()));
        employee.setId(vemployee.getId());
        employee.setQq(vemployee.getQq());
        employee.setSalary(vemployee.getSalary());
        employee.setDepartment_id(vemployee.getDepartment());
        employee.setJob(vemployee.getJob());
        employee.setGender(webUtils.transGender(vemployee.getGender()));
        employee.setEmail(vemployee.getEmail());
        employee.setName(vemployee.getName());
        employee.setPhone(vemployee.getPhone());
        employee.setDepartment(departmentDao.getDepartmentById(vemployee.getDepartment()));
        employeeDao.update(employee);
    }

    public void saveDepartment(Department department) {
        department.setId(webUtils.getUUID());
        departmentDao.save(department);
    }

    public void removeDepartment(Department department) {
        departmentDao.remove(department);
    }

    public void updateDepartment(Department department) {
        departmentDao.update(department);
    }
}
