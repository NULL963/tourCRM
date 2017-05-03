package cn.crm.dao;

import cn.crm.domain.User;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/4/16.
 */
public interface UserDao {
    User getUserById(String id);

    User getUserByName(String name);

    User save(User user);

    void delete(String user);

    void update(User user);

    List<User> getAllUser();
}
