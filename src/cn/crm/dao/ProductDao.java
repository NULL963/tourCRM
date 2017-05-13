package cn.crm.dao;

import cn.crm.domain.Product;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by LEMON on 2017/5/9.
 */
public interface ProductDao {
    void save(Product product)  ;

    void remove(String id)  ;

    void update(Product product)  ;

    Product getById(String id)  ;

    List<Product> getAll()  ;
}
