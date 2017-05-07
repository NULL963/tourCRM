package test;

import cn.crm.dao.FoodDao;
import cn.crm.dao.impl.FoodDaoImpl;
import cn.crm.domain.Food;
import cn.crm.domain.Supplier;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 餐饮资源的dao测试已完成无异常
 * Created by LEMON on 2017/5/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class foodDaoImpl {
    @Test
    public void saveTest() {
        FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        food.setId(webUtils.getUUID());
        food.setName("将香槟");
        Supplier supplier = new Supplier();
        supplier.setId("0e197f12eee4449d9ae0ce4be3c407d8");
        food.setSupplier(supplier);
        dao.save(food);
    }

    @Test
    public void update() {
        FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        food.setId("fcb0afb2adb34208a974ddef8899f60e");
        food.setName("酱香饼");
        Supplier supplier = new Supplier();
        supplier.setId("0e197f12eee4449d9ae0ce4be3c407d8");
        food.setSupplier(supplier);
        dao.update(food);

    }

    @Test
    public void getById() {
        FoodDao dao = new FoodDaoImpl();
        Food food = dao.getById("fcb0afb2adb34208a974ddef8899f60e");
    }

    @Test
    public void getByName() {
        FoodDao dao = new FoodDaoImpl();
        Food food = dao.getByName("酱香饼");
    }

    @Test
    public void getAll() {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.getAll();
    }

    @Test
    public void remove() {
        FoodDao dao = new FoodDaoImpl();
        dao.remove("fcb0afb2adb34208a974ddef8899f60e");
    }
}
