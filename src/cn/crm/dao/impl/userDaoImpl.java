package cn.crm.dao.impl;

import cn.crm.dao.UserDao;
import cn.crm.domain.User;
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
 * Created by LEMON on 2017/4/15.
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Override
    public User getUserById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from users where id = ?";
        try {
            return runner.query(sql, new BeanHandler<User>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUserByName(String name) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from users where name = ?";
        try {
            return runner.query(sql, new BeanHandler<User>(User.class), name);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> getAllUser() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select * from users";
        try {
            return runner.query(sql, new BeanListHandler<User>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User save(User user) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into users(id,name,password,description,gmt_create,employee_id) values(?,?,?,?,?,?)";
        Object[] perms = {user.getId(), user.getName(), user.getPassword(), user.getDescription(), new Timestamp(new Date().getTime()), user.getEmployee_id()};
        try {
            return runner.insert(sql, new BeanHandler<User>(User.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }

    @Override
    public void delete(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from users where id = ?";
        try {
            int a = runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update users set name=?,password=?,description=?,gmt_modified=?,employee_id=? where id=?";
        Object[] perms = {user.getName(), user.getPassword(), user.getDescription(), new Timestamp(new Date().getTime()), user.getEmployee().getId(), user.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
