package test;

import cn.crm.dao.ProductDao;
import cn.crm.dao.impl.AccommodationDaoImpl;
import cn.crm.dao.impl.FoodDaoImpl;
import cn.crm.dao.impl.ProductDaoImpl;
import cn.crm.dao.impl.ScenicSpotDaoImpl;
import cn.crm.domain.Accommodation;
import cn.crm.domain.Food;
import cn.crm.domain.Product;
import cn.crm.domain.ScenicSpot;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Product的dao已完成测验
 * Created by LEMON on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class ProductDaoTest {
    @Test
    public void save() {
        ProductDao dao = new ProductDaoImpl();
        Product product = new Product();
        AccommodationDaoImpl accommodationDao = new AccommodationDaoImpl();
        ScenicSpotDaoImpl scenicSpotDao = new ScenicSpotDaoImpl();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        product.setId(webUtils.getUUID());
        product.setName("地狱三日游");
        List<Accommodation> accommodationList = accommodationDao.getAll();
        List<ScenicSpot> scenicSpotList = scenicSpotDao.getAll();
        List<Food> foodList = foodDao.getAll();
        Set<Accommodation> accommodationSet = new HashSet<Accommodation>();
        accommodationSet.addAll(accommodationList);

        Set<ScenicSpot> scenicSpotSet = new HashSet<ScenicSpot>();
        scenicSpotSet.addAll(scenicSpotList);

        Set<Food> foodSet = new HashSet<Food>();
        foodSet.addAll(foodList);

        product.setAccommodationSet(accommodationSet);
        product.setSpotSet(scenicSpotSet);
        product.setFoodSet(foodSet);


            dao.save(product);


    }

    @Test
    public void remove() {
        ProductDao dao = new ProductDaoImpl();

            dao.remove("a03e90dc50a848ed8a0a21e104e0b187");

    }

    @Test
    public void update() {
        ProductDao dao = new ProductDaoImpl();
        Product product = new Product();
        AccommodationDaoImpl accommodationDao = new AccommodationDaoImpl();
        ScenicSpotDaoImpl scenicSpotDao = new ScenicSpotDaoImpl();
        FoodDaoImpl foodDao = new FoodDaoImpl();
        product.setId("eb2592f5e1484cc0843e218872e14006");
        product.setName("天堂三日游");
        List<Accommodation> accommodationList = accommodationDao.getAll();
        List<ScenicSpot> scenicSpotList = scenicSpotDao.getAll();
        List<Food> foodList = foodDao.getAll();
        Set<Accommodation> accommodationSet = new HashSet<Accommodation>();
        accommodationSet.addAll(accommodationList);

        Set<ScenicSpot> scenicSpotSet = new HashSet<ScenicSpot>();
        scenicSpotSet.addAll(scenicSpotList);

        Set<Food> foodSet = new HashSet<Food>();
        foodSet.addAll(foodList);

        product.setAccommodationSet(accommodationSet);
        product.setSpotSet(scenicSpotSet);
//        product.setFoodSet(foodSet);


            dao.update(product);

    }

    @Test
    public void getById() {
        ProductDao dao = new ProductDaoImpl();

            Product product = dao.getById("eb2592f5e1484cc0843e218872e14006");
            System.out.println(product.getName());

    }

    @Test
    public void getAll() throws SQLException {
        ProductDao dao = new ProductDaoImpl();
        List<Product> list = dao.getAll();
    }
}
