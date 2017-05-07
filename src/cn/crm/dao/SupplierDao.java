package cn.crm.dao;

import cn.crm.domain.Supplier;

import java.util.List;

/**
 * Created by LEMON on 2017/5/4.
 */
public interface SupplierDao {
    void save(Supplier supplier);

    void remove(String id);

    void update(Supplier supplier);

    Supplier getSupplierById(String id);

    Supplier getSuppliderByName(String name);

    List<Supplier> getAll();
}
