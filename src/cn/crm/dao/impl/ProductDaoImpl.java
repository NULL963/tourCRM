package cn.crm.dao.impl;

import cn.crm.domain.Accommodation;
import cn.crm.domain.Food;
import cn.crm.domain.Product;
import cn.crm.domain.ScenicSpot;
import cn.crm.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.*;

/**
 * Created by LEMON on 2017/5/8.
 */
@Repository
public class ProductDaoImpl implements cn.crm.dao.ProductDao {

    @Override
    public void save(Product product) {
        try {

            QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
            String sql = "insert into products(id,money,number,name,description,gmt_create) values(?,?,?,?,?,?)";
            Object[] perms = {product.getId(), product.getMoney(), product.getNumber(), product.getName(), product.getDescription(), new Timestamp(new Date().getTime())};
            runner.insert(sql, new BeanHandler<Product>(Product.class), perms);

            Set<Accommodation> list1 = product.getAccommodationSet();
            for (Accommodation accommodation : list1) {
                sql = "insert into mid_product_accomodation(product_id,accomodation_id) values(?,?)";
                perms = new Object[]{product.getId(), accommodation.getId()};
                runner.update(sql, perms);
            }

            Set<ScenicSpot> list2 = product.getSpotSet();
            for (ScenicSpot scenicSpot : list2) {
                sql = "insert into mid_product_spot(product_id,spot_id) values(?,?)";
                perms = new Object[]{product.getId(), scenicSpot.getId()};
                runner.update(sql, perms);
            }

            Set<Food> list3 = product.getFoodSet();
            for (Food food : list3) {
                sql = "insert into mid_product_food(product_id,food_id) values(?,?)";
                perms = new Object[]{product.getId(), food.getId()};
                runner.update(sql, perms);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void remove(String id) {
        try {

            QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
            //首先删除中间表的相关数据
            String sql = "delete from mid_product_accomodation where product_id = ?";
            runner.update(sql, id);
            sql = "delete from mid_product_spot where product_id = ?";
            runner.update(sql, id);
            sql = "delete from mid_product_food where product_id = ?";
            runner.update(sql, id);
            //删除产品表的数据
            sql = "delete from products where id = ?";
            runner.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Product product) {
        try {

            QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
            String sql = "update products set money=?,number=?,name=?,description=?,gmt_modified=? where id=?";
            Object[] perms = {product.getMoney(), product.getNumber(), product.getName(), product.getDescription(), new Timestamp(new Date().getTime()), product.getId()};
            int a = runner.update(sql, perms);
            //删除所有中间表的对应数据
            sql = "delete from mid_product_accomodation where product_id = ?";
            runner.update(sql, product.getId());
            sql = "delete from mid_product_spot where product_id = ?";
            runner.update(sql, product.getId());
            sql = "delete from mid_product_food where product_id = ?";
            runner.update(sql, product.getId());
            //重新插入对应数据
            Set<Accommodation> list1 = product.getAccommodationSet();
            if (list1 != null) {
                for (Accommodation accommodation : list1) {
                    sql = "insert into mid_product_accomodation(product_id,accomodation_id,gmt_create) values(?,?,?)";
                    perms = new Object[]{product.getId(), accommodation.getId(), new Timestamp(new Date().getTime())};
                    runner.update(sql, perms);
                }
            }

            Set<ScenicSpot> list2 = product.getSpotSet();
            if (list2 != null) {
                for (ScenicSpot scenicSpot : list2) {
                    sql = "insert into mid_product_spot(product_id,spot_id,gmt_create) values(?,?,?)";
                    perms = new Object[]{product.getId(), scenicSpot.getId(), new Timestamp(new Date().getTime())};
                    runner.update(sql, perms);
                }
            }

            Set<Food> list3 = product.getFoodSet();
            if (list3 != null) {
                for (Food food : list3) {
                    sql = "insert into mid_product_food(product_id,food_id,gmt_create) values(?,?,?)";
                    perms = new Object[]{product.getId(), food.getId(), new Timestamp(new Date().getTime())};
                    runner.update(sql, perms);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Product getById(String id) {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());
        try {
            String sql = "select * from products where id = ?";
            Product product = runner.query(sql, new BeanHandler<Product>(Product.class), id);
            //找到所有accommodation数据
            sql = "select a.id,a.level,a.price,a.address,a.rome_type,a.is_usable usable,a.supplier_id from mid_product_accomodation mid,accomodations a where mid.product_id = ? and mid.accomodation_id=a.id";
            List<Accommodation> accommodationList = runner.query(sql, new BeanListHandler<Accommodation>(Accommodation.class), id);
            if (accommodationList != null) {
                Set<Accommodation> accommodationSet = new HashSet<Accommodation>();
                accommodationSet.addAll(accommodationList);
                product.setAccommodationSet(accommodationSet);
            }
            //找到所有food数据F
            sql = "select f.id,f.level,f.price,f.address,f.supplier_id,f.is_usable usable,f.name from mid_product_food mid,foods f where mid.product_id = ? and mid.food_id = f.id";
            List<Food> foodList = runner.query(sql, new BeanListHandler<Food>(Food.class), id);
            if (foodList != null) {
                Set<Food> foodSet = new HashSet<Food>();
                foodSet.addAll(foodList);
                product.setFoodSet(foodSet);
            }
            //spot
            sql = "select s.id,s.name,s.level,s.price,s.is_usable usable,s.address from mid_product_spot mid,scenic_spots s where mid.product_id = ? and mid.spot_id = s.id";
            List<ScenicSpot> scenicSpotList = runner.query(sql, new BeanListHandler<ScenicSpot>(ScenicSpot.class), id);
            if (scenicSpotList != null) {
                Set<ScenicSpot> scenicSpotSet = new HashSet<ScenicSpot>();
                scenicSpotSet.addAll(scenicSpotList);
                product.setSpotSet(scenicSpotSet);
            }
            return product;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Product> getAll() {
        QueryRunner runner = new QueryRunner(jdbcUtils.getDataSoruce());

        String sql = "select * from products";
        List<Product> list = null;
        try {
            list = runner.query(sql, new BeanListHandler<Product>(Product.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < list.size(); i++) {
            list.set(i, this.getById(list.get(i).getId()));
        }
        return list;

    }
}
