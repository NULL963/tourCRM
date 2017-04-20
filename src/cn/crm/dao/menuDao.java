package cn.crm.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/4/18.
 */
public interface menuDao {
    List getAllMenu() throws SQLException;
}
