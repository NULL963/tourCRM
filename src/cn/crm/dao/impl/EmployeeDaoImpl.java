package cn.crm.dao.impl;

import cn.crm.dao.EmployeeDao;
import cn.crm.domain.Employee;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by LEMON on 2017/4/20.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Override
    public void save(Employee employee) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into employees(id,name,gender,email,phone,qq,hiredate,salary,department_id,gmt_create,job) values(?,?,?,?,?,?,?,?,?,?,?)";
        Object[] perms = {employee.getId(), employee.getName(), employee.getGender(), employee.getEmail(), employee.getPhone(), employee.getQq(), new java.sql.Date(employee.getHireDate().getTime()), employee.getSalary(), employee.getDepartment().getId(), new Timestamp(new Date().getTime()),employee.getJob()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Employee employee) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update employees set job=?,name=?,gender=?,email=?,phone=?,qq=?,hiredate=?,salary=?,department_id=?,gmt_modified=? where id=?";
        Object[] perms = {employee.getJob(),employee.getName(), employee.getGender(), employee.getEmail(), employee.getPhone(), employee.getQq(), new java.sql.Date(employee.getHireDate().getTime()), employee.getSalary(), employee.getDepartment().getId(), new Timestamp(new Date().getTime()), employee.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from employees where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from employees where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Employee>(Employee.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee getEmployeeByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from employees where name = ?";
        try {
            return runner.query(sql, new BeanHandler<Employee>(Employee.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> getAllEmployee() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from employees";
        try {
            return runner.query(sql, new BeanListHandler<Employee>(Employee.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
