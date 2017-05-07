package cn.crm.dao.impl;

import cn.crm.domain.Accommodation;
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
public class AccommodationDaoImpl implements cn.crm.dao.AccommodationDao {
    @Override
    public void save(Accommodation accommodation) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into accomodations(id,level,price,address,rome_type,supplier_id,is_usable,gmt_create) values(?,?,?,?,?,?,?,?)";
        Object[] perms = {accommodation.getId(), accommodation.getLevel(), accommodation.getPrice(), accommodation.getAddress(), accommodation.getRome_type(), accommodation.getSupplier_id(), accommodation.isUsable(), new Timestamp(new Date().getTime())};
        try {
            runner.insert(sql, new BeanHandler<Accommodation>(Accommodation.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from accomodations where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Accommodation accommodation) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update accomodations set level=?,price=?,address=?,rome_type=?,supplier_id=?,is_usable=?,gmt_modified=? where id=?";
        Object[] perms = {accommodation.getLevel(), accommodation.getPrice(), accommodation.getAddress(), accommodation.getRome_type(), accommodation.getSupplier_id(), accommodation.isUsable(), new Timestamp(new Date().getTime()), accommodation.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Accommodation getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,level,price,address,rome_type,is_usable usable,supplier_id from accomodations where id = ?";
        try {
            return runner.query(sql, new BeanHandler<Accommodation>(Accommodation.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Accommodation> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,level,price,address,rome_type,is_usable usable,supplier_id from accomodations";
        try {
            return runner.query(sql, new BeanListHandler<Accommodation>(Accommodation.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


