package cn.crm.dao;

import cn.crm.domain.Employee;

import java.util.List;

/**
 * Created by LEMON on 2017/4/21.
 */
public interface EmployeeDao {
    void save(Employee employee);

    void update(Employee employee);

    void delete(String id);

    Employee getEmployeeById(String id);

    Employee getEmployeeByName(String name);

    List<Employee> getAllEmployee();
}
