package cn.crm.dao;

import cn.crm.domain.Customer;

import java.util.List;

/**
 * Created by LEMON on 2017/5/3.
 */
public interface CustomerDao {
    Customer getCustomerById(String id);

    Customer getCustomerByNmae(String name);

    List<Customer> getAllCustomer();

    void save(Customer customer);

    void remove(String id);

    void update(Customer customer);
}
