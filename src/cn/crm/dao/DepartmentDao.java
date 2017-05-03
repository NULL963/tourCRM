package cn.crm.dao;

import cn.crm.domain.Department;

import java.util.List;

/**
 * Created by LEMON on 2017/4/26.
 */
public interface DepartmentDao {
    Department getDepartmentById(String id);

    Department getDepartmentByName(String name);

    List<Department> getAllDepartment();

    void update(Department department);

    void remove(Department department);

    Department save(Department department);
}
