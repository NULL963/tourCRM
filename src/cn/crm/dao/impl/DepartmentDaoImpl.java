package cn.crm.dao.impl;

import cn.crm.domain.Department;
import cn.crm.domain.Employee;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/4/26.
 */
@Repository
public class DepartmentDaoImpl implements cn.crm.dao.DepartmentDao {
    @Override
    public Department getDepartmentById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from department where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Department>(Department.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department getDepartmentByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from department where name = ?";
        try {
            return runner.query(sql, new BeanHandler<Department>(Department.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Department> getAllDepartment() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from department";
        try {
            return runner.query(sql, new BeanListHandler<Department>(Department.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Department department) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update department set name=?,gmt_modified=? where id=?";
        Object[] perms = {department.getName(), department.getGmt_modifed(), department.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(Department department) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from department where id = ?";
        try {
            runner.update(sql, department.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Department save(Department department) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into department(id,name,gmt_create) values(?,?,?)";
        Object[] perms = {department.getId(), department.getName(), department.getGmt_create()};
        try {
            return runner.insert(sql, new BeanHandler<Department>(Department.class),perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
