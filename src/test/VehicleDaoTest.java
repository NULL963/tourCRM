package test;

import cn.crm.dao.VehicleDao;
import cn.crm.dao.impl.VehicleDaoImpl;
import cn.crm.domain.Vehicle;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * VehicleDao的测试类已完成测试无问题
 * Created by LEMON on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class VehicleDaoTest {
    @Test
    public void save() {
        VehicleDao dao = new VehicleDaoImpl();
        Vehicle vehicle = new Vehicle();
        vehicle.setId(webUtils.getUUID());
        vehicle.setSupplier_id("0e197f12eee4449d9ae0ce4be3c407d8");
        vehicle.setEnable_date(new Date());
        dao.save(vehicle);

    }

    @Test
    public void update() {
        VehicleDao dao = new VehicleDaoImpl();
        Vehicle vehicle = new Vehicle();
        vehicle.setId("28162d88d00b40a88f8cc472212bcdb9");
        vehicle.setSupplier_id("0e197f12eee4449d9ae0ce4be3c407d8");
        vehicle.setEnable_date(new Date());
        vehicle.setPlate_number("123");
        vehicle.setBrand_model("五菱宏光");
        dao.update(vehicle);
    }

    @Test
    public void getById() {
        VehicleDao dao = new VehicleDaoImpl();
        Vehicle vehicle = dao.getById("28162d88d00b40a88f8cc472212bcdb9");
    }

    @Test
    public void getByPlate_Number() {
        VehicleDao dao = new VehicleDaoImpl();
        Vehicle vehicle = dao.getByPlateNumber("123");
    }

    @Test
    public void getAll() {
        VehicleDao dao = new VehicleDaoImpl();
        List<Vehicle> list = dao.getAll();
    }

}
