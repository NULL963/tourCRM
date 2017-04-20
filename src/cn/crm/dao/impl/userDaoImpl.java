package cn.crm.dao.impl;

import cn.crm.domain.User;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by LEMON on 2017/4/15.
 */
@Repository
public class userDaoImpl implements cn.crm.dao.userDao {

    @Override
    public User getUserById(String id) throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from users where id = ?";
        return runner.query(sql,new BeanHandler<User>(User.class), id);
    }
    @Override
    public User getUserByName(String name) throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from users where name = ?";
        return runner.query(sql, new BeanHandler<User>(User.class), name);
    }
    @Override
    public void insert(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into users(id,name,password,description,gmt_create,employee_id) values(?,?,?,?,?,?)";
        Object[] perms = {user.getId(), user.getName(), user.getPassword(), user.getDesc(),new Timestamp(new Date().getTime()), user.getEmployee().getId()};
        runner.update(sql, perms);
    }
    @Override
    public void delete(String id) throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from users where id = ?";
        runner.update(sql, id);
    }
    @Override
    public void update(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update users set name=?,password=?,description=?,gmt_modified=?,employee_id=? where id=?";
        Object[] perms = {user.getName(), user.getPassword(), user.getDesc(), new Date(), user.getEmployee().getId(), user.getId()};
        runner.update(sql, perms);
    }
}
