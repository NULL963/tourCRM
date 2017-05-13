package cn.crm.dao.impl;

import cn.crm.domain.Customer;
import cn.crm.domain.Order;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by LEMON on 2017/5/11.
 */
@Repository
public class OrderDaoImpl implements cn.crm.dao.OrderDao {
    @Override
    public void save(Order order) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into orders(id,number,conditions,is_pay,customer_number,money,mode_of_payment,go_off_time,end_time,employee_id,product_id,gmt_create) values(?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] perms = {order.getId(), order.getNumber(), order.getConditions(), order.isPay(), order.getCustomer_number(), order.getMoney(), order.getMode_of_payment(), new java.sql.Date(order.getGo_off_time().getTime()), new java.sql.Date(order.getEnd_time().getTime()), order.getEmployee_id(), order.getProduct_id(), new Timestamp(new Date().getTime())};
        try {
            runner.update(sql, perms);
            sql = "insert into mid_order_customer(order_id,customer_id) values(?,?)";
            for (Customer customer : order.getCustomerSet()) {
                perms = new Object[]{order.getId(), customer.getId()};
                runner.update(sql, perms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from mid_order_customer where order_id = ?";
        try {
            runner.update(sql, id);
            sql = "delete from orders where id = ?";
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Order order) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update orders set number=?,conditions=?,is_pay=?,customer_number=?,money=?,mode_of_payment=?,go_off_time=?,end_time=?,employee_id=?,product_id=?,group_id=?,gmt_modified=? where id = ?";
        Object[] perms = {order.getNumber(), order.getConditions(), order.isPay(), order.getCustomer_number(), order.getMoney(), order.getMode_of_payment(), new java.sql.Date(order.getGo_off_time().getTime()), new java.sql.Date(order.getEnd_time().getTime()), order.getEmployee_id(), order.getProduct_id(), order.getGroup_id(), new Timestamp(new Date().getTime()), order.getId()};
        try {
            runner.update(sql, perms);
            //删除中间表的所有相关数据
            sql = "delete from mid_order_customer where order_id = ?";
            runner.update(sql, order.getId());
            //重新插入新的对应关系到中间表
            sql = "insert into mid_order_customer(order_id,customer_id) values(?,?)";
            for (Customer customer : order.getCustomerSet()) {
                perms = new Object[]{order.getId(), customer.getId()};
                runner.update(sql, perms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,number,conditions,is_pay pay,customer_number,money,mode_of_payment,go_off_time,end_time,employee_id,product_id,group_id from orders where id = ?";
        try {
            Order order = runner.query(sql, new BeanHandler<Order>(Order.class), id);
            sql = "select c.* from mid_order_customer mid,customers c where mid.order_id = ? and mid.customer_id = c.id";
            List<Customer> customerList = runner.query(sql, new BeanListHandler<Customer>(Customer.class), order.getId());
            Set<Customer> set = new HashSet<Customer>();
            if (customerList != null) {
                set.addAll(customerList);
            }
            order.setCustomerSet(set);
            return order;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,number,conditions,is_pay pay,customer_number,money,mode_of_payment,go_off_time,end_time,employee_id,product_id,group_id from orders";
        try {
            List<Order> list = runner.query(sql, new BeanListHandler<Order>(Order.class));
            for (Order order : list) {
                sql = "select c.* from mid_order_customer mid,customers c where mid.order_id = ? and mid.customer_id = c.id";
                List<Customer> customerList = runner.query(sql, new BeanListHandler<Customer>(Customer.class), order.getId());
                Set<Customer> set = new HashSet<Customer>();
                if (customerList != null) {
                    set.addAll(customerList);
                }
                order.setCustomerSet(set);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void changeCondition(String condition, String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update orders set conditions=? where id=?";
        Object[] perms = {condition, id};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
