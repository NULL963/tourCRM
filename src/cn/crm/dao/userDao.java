package cn.crm.dao;

import cn.crm.domain.User;

import java.sql.SQLException;

/**
 * Created by LEMON on 2017/4/16.
 */
public interface userDao {
    User getUserById(String id) throws SQLException;

    User getUserByName(String name) throws SQLException;

    void insert(User user) throws SQLException;

    void delete(String user) throws SQLException;

    void update(User user) throws SQLException;
}
