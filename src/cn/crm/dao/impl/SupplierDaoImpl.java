package cn.crm.dao.impl;

import cn.crm.domain.Supplier;
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
 * Created by LEMON on 2017/5/4.
 */
@Repository
public class SupplierDaoImpl implements cn.crm.dao.SupplierDao {
    @Override
    public void save(Supplier supplier) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into suppliers(id,name,type,address,bank_card_number,bank_of_deposit,phone,email,gmt_create) values(?,?,?,?,?,?,?,?,?)";
        Object[] perms = {supplier.getId(), supplier.getName(), supplier.getType(), supplier.getAddress(), supplier.getBank_card_number(), supplier.getBank_of_deposit(), supplier.getPhone(), supplier.getEmail(), new Timestamp(new Date().getTime())};
        try {
            runner.insert(sql, new BeanHandler<Supplier>(Supplier.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from suppliers where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Supplier supplier) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update suppliers set name=?,type=?,address=?,bank_card_number=?,bank_of_deposit=?,phone=?,email=?,gmt_modified=? where id=?";
        Object[] perms = {supplier.getName(), supplier.getType(), supplier.getAddress(), supplier.getBank_card_number(), supplier.getBank_of_deposit(), supplier.getPhone(), supplier.getEmail(), new Timestamp(new Date().getTime()), supplier.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Supplier getSupplierById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from suppliers where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Supplier>(Supplier.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Supplier getSuppliderByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from suppliers where name = ?";
        try {
            return runner.query(sql, new BeanHandler<Supplier>(Supplier.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Supplier> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from suppliers";
        try {
            return runner.query(sql, new BeanListHandler<Supplier>(Supplier.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
