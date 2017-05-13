package cn.crm.dao.impl;

import cn.crm.domain.Group;
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
 * Created by LEMON on 2017/5/11.
 */
@Repository
public class GroupDaoImpl implements cn.crm.dao.GroupDao {
    //对于订单set放到service层更新
    @Override
    public void save(Group group) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into groups(id,number,tour_guide_id,driver_id,product_id,gmt_create) values(?,?,?,?,?,?)";
        Object[] perms = {group.getId(), group.getNumber(), group.getTour_guide_id(), group.getDriver_id(), group.getProduct_id(), new Timestamp(new Date().getTime())};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from groups where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Group group) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update groups set number=?,tour_guide_id=?,driver_id=?,product_id=?,gmt_modified=? where id = ?";
        Object[] perms = {group.getNumber(), group.getTour_guide_id(), group.getDriver_id(), group.getProduct_id(), new Timestamp(new Date().getTime()), group.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Group getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,number,tour_guide_id,driver_id,product_id   from groups where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Group>(Group.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Group> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,number,tour_guide_id,driver_id,product_id from groups";
        try {
            return runner.query(sql, new BeanListHandler<Group>(Group.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
