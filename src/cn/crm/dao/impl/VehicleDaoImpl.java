package cn.crm.dao.impl;

import cn.crm.domain.Vehicle;
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
 * Created by LEMON on 2017/5/5.
 */
@Repository
public class VehicleDaoImpl implements cn.crm.dao.VehicleDao {

    @Override
    public void save(Vehicle vehicle) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "insert into vehicles(id,plate_number,seat_number,price,enable_date,brand_model,is_usable,supplier_id,gmt_create) values(?,?,?,?,?,?,?,?,?)";
        Object[] perms = {vehicle.getId(), vehicle.getPlate_number(), vehicle.getSeat_number(), vehicle.getPrice(), new java.sql.Date(vehicle.getEnable_date().getTime()), vehicle.getBrand_model(), vehicle.isUsable(), vehicle.getSupplier_id(), new Timestamp(new Date().getTime())};
        try {
            runner.insert(sql, new BeanHandler<Vehicle>(Vehicle.class), perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "delete from vehicles where id = ?";
        try {
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Vehicle vehicle) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "update vehicles set plate_number=?,seat_number=?,price=?,enable_date=?,brand_model=?,is_usable=?,supplier_id=?,gmt_modified=? where id=?";
        Object[] perms = {vehicle.getPlate_number(), vehicle.getSeat_number(), vehicle.getPrice(), new java.sql.Date(vehicle.getEnable_date().getTime()), vehicle.getBrand_model(), vehicle.isUsable(), vehicle.getSupplier_id(), new Timestamp(new Date().getTime()), vehicle.getId()};
        try {
            runner.update(sql, perms);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,plate_number,seat_number,price,enable_date,brand_model,is_usable usable,supplier_id,gmt_create,gmt_modified from vehicles where id=?";
        try {
            return runner.query(sql, new BeanHandler<Vehicle>(Vehicle.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle getByPlateNumber(String plateNumber) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,plate_number,seat_number,price,enable_date,brand_model,is_usable usable,supplier_id,gmt_create,gmt_modified from vehicles where plate_number=?";
        try {
            return runner.query(sql, new BeanHandler<Vehicle>(Vehicle.class), plateNumber);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vehicle> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        String sql = "select id,plate_number,seat_number,price,enable_date,brand_model,is_usable usable,supplier_id,gmt_create,gmt_modified from vehicles";
        try {
            return runner.query(sql, new BeanListHandler<Vehicle>(Vehicle.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
