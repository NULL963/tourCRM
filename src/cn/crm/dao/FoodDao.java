package cn.crm.dao;

import cn.crm.domain.Food;

import java.util.List;

/**
 * Created by LEMON on 2017/5/5.
 */
public interface FoodDao {
    void save(Food food);

    void remove(String id);

    void update(Food food);

    Food getById(String id);

    Food getByName(String name);

    List<Food> getAll();
}
