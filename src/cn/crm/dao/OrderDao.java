package cn.crm.dao;

import cn.crm.domain.Order;

import java.util.List;

/**
 * Created by LEMON on 2017/5/11.
 */
public interface OrderDao {
    void save(Order order);

    void remove(String id);

    void update(Order order);

    Order getById(String id);

    void changeCondition(String condition, String id);

    List<Order> getAll();
}
