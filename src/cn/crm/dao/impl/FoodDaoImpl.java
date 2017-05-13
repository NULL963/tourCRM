package cn.crm.dao.impl;

import cn.crm.domain.Food;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * Created by LEMON on 2017/5/4.
 */
@Repository
public class FoodDaoImpl implements cn.crm.dao.FoodDao {
    @Override
    public void save(Food food) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into foods(id,name,level,price,address,supplier_id,gmt_create,is_usable) values(?,?,?,?,?,?,?,?)";
        Object[] perms = {food.getId(), food.getName(), food.getLevel(), food.getPrice(), food.getAddress(), food.getSupplier_id(), new Timestamp(new Date().getTime()), food.isUsable()};
        try {
            runner.insert(sql, new BeanHandler<Food>(Food.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from foods where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Food food) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update foods set name=?,level=?,price=?,address=?,supplier_id=?,gmt_modified=?,is_usable=? where id=?";
        Object[] perms = {food.getName(), food.getLevel(), food.getPrice(), food.getAddress(), food.getSupplier_id(), new Timestamp(new Date().getTime()), food.isUsable(), food.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,level,price,address,supplier_id,name,is_usable usable from foods where id=?";
        try {
            return runner.query(sql, new BeanHandler<Food>(Food.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Food getByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,level,price,address,supplier_id,name,is_usable usable from foods where name = ?";
        try {
            return runner.query(sql, new BeanHandler<Food>(Food.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Food> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,level,price,address,supplier_id,name,is_usable usable from foods";
        try {
            return runner.query(sql, new BeanListHandler<Food>(Food.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
