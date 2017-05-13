package cn.crm.dao.impl;

import cn.crm.domain.ScenicSpot;
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
 * Created by LEMON on 2017/5/6.
 */
@Repository
public class ScenicSpotDaoImpl implements cn.crm.dao.ScenicSpotDao {
    @Override
    public void save(ScenicSpot scenicSpot) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into scenic_spots(id,name,level,price,address,is_usable,gmt_create) values(?,?,?,?,?,?,?)";
        Object[] perms = {scenicSpot.getId(), scenicSpot.getName(), scenicSpot.getLevel(), scenicSpot.getPrice(), scenicSpot.getAddress(), scenicSpot.isUsable(), new Timestamp(new Date().getTime())};
        try {
            runner.insert(sql, new BeanHandler<ScenicSpot>(ScenicSpot.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from scenic_spots where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(ScenicSpot scenicSpot) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update scenic_spots set name=?,level=?,price=?,address=?,is_usable=?,gmt_modified=? where id=?";
        Object[] perms = {scenicSpot.getName(), scenicSpot.getLevel(), scenicSpot.getPrice(), scenicSpot.getAddress(), scenicSpot.isUsable(), new Timestamp(new Date().getTime()), scenicSpot.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ScenicSpot getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,name,level,price,is_usable usable,address from scenic_spots where id = ?";
        try {
            return runner.query(sql, new BeanHandler<ScenicSpot>(ScenicSpot.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ScenicSpot getByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,name,level,price,is_usable usable,address from scenic_spots where name = ?";
        try {
            return runner.query(sql, new BeanHandler<ScenicSpot>(ScenicSpot.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<ScenicSpot> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,name,level,price,is_usable usable,address from scenic_spots";
        try {
            return runner.query(sql, new BeanListHandler<ScenicSpot>(ScenicSpot.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
