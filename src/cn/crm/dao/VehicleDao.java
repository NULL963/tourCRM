package cn.crm.dao;

import cn.crm.domain.Vehicle;

import java.util.List;

/**
 * Created by LEMON on 2017/5/6.
 */
public interface VehicleDao {
    void save(Vehicle vehicle);

    void remove(String id);

    void update(Vehicle vehicle);

    Vehicle getById(String id);

    Vehicle getByPlateNumber(String plateNumber);

    List<Vehicle> getAll();
}
