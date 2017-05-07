package test;

import cn.crm.dao.SupplierDao;
import cn.crm.dao.impl.SupplierDaoImpl;
import cn.crm.domain.Supplier;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 供应商dao的crud方法已完成测试无异常
 * Created by LEMON on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class supplierDaoTest {
    @Test
    public void saveTest() {
        SupplierDao dao = new SupplierDaoImpl();
        Supplier supplier = new Supplier();
        supplier.setId(webUtils.getUUID());
        supplier.setBank_of_deposit("123");
        supplier.setBank_card_number("234");
        supplier.setName("恩佐斯");
        supplier.setAddress("艾泽拉斯");
        supplier.setEmail("12345");
        supplier.setPhone("1234");
        supplier.setType("餐饮");
        dao.save(supplier);
    }

    @Test
    public void updateTest() {
        SupplierDao dao = new SupplierDaoImpl();
        Supplier supplier = new Supplier();
        supplier.setId("0e197f12eee4449d9ae0ce4be3c407d8");
        supplier.setBank_of_deposit("123");
        supplier.setBank_card_number("234");
        supplier.setName("恩佐斯");
        supplier.setAddress("艾泽拉斯");
        supplier.setEmail("12345");
        supplier.setPhone("1234");
        supplier.setType("酒店");
        dao.update(supplier);
    }

    @Test
    public void getById() {
        SupplierDao dao = new SupplierDaoImpl();
        Supplier supplier = dao.getSupplierById("0e197f12eee4449d9ae0ce4be3c407d8");
    }

    @Test
    public void getByNmae() {
        SupplierDao dao = new SupplierDaoImpl();
        Supplier supplier = dao.getSuppliderByName("恩佐斯");
    }

    @Test
    public void GetAll() {
        SupplierDao dao = new SupplierDaoImpl();
        List<Supplier> list = dao.getAll();
    }
}
