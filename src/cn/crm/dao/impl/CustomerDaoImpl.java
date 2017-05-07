package cn.crm.dao.impl;

import cn.crm.domain.Customer;
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
 * Created by LEMON on 2017/5/3.
 */
@Repository
public class CustomerDaoImpl implements cn.crm.dao.CustomerDao {
    @Override
    public Customer getCustomerById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from customers where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Customer>(Customer.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer getCustomerByNmae(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from customers where name = ?";
        try {
            return runner.query(sql, new BeanHandler<Customer>(Customer.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Customer> getAllCustomer() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from customers";
        try {
            return runner.query(sql, new BeanListHandler<Customer>(Customer.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void save(Customer customer) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into customers(id,name,gender,nation,email,phone,qq,address,bank_card_number,bank_of_deposit,description,id_number,gmt_create) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] perms = {customer.getId(), customer.getName(), customer.getGender(), customer.getNation(), customer.getEmail(), customer.getPhone(), customer.getQq(), customer.getAddress(), customer.getBank_card_number(), customer.getBank_of_deposit(), customer.getDescription(), customer.getId_number(), new Timestamp(new Date().getTime())};
        try {
            runner.insert(sql, new BeanHandler<Customer>(Customer.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from customers where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Customer customer) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update customers set name=?,gender=?,nation=?,email=?,phone=?,qq=?,address=?,bank_card_number=?,bank_of_deposit=?,description=?,id_number=?,gmt_modified=? where id=?";
        Object[] perms = {customer.getName(), customer.getGender(), customer.getNation(), customer.getEmail(), customer.getPhone(), customer.getQq(), customer.getAddress(), customer.getBank_card_number(), customer.getBank_of_deposit(), customer.getDescription(), customer.getId_number(), new Timestamp(new Date().getTime()), customer.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
