package cn.crm.dao.impl;

import cn.crm.dao.MenuDao;
import cn.crm.domain.Pub_menu;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/4/18. ≤È’“
 */
@Repository
public class MenuDaoImpl implements MenuDao {
    @Override
    public List getAllMenu() throws SQLException {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "SELECT child.id, child.text,child.uri,child.lft,child.rht, count(child.text) as depth from pub_menu as parent,pub_menu as child where parent.lft<child.lft and parent.rht>child.rht group by(child.text) order by child.lft";
        return runner.query(sql, new BeanListHandler<Pub_menu>(Pub_menu.class));
    }
}
