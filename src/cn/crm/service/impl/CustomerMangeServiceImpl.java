package cn.crm.service.impl;

import cn.crm.dao.CustomerDao;
import cn.crm.dao.SupplierDao;
import cn.crm.domain.Customer;
import cn.crm.domain.Supplier;
import cn.crm.utils.webUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LEMON on 2017/5/3.
 */
@Service
public class CustomerMangeServiceImpl {

    private CustomerDao customerDao;

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    private SupplierDao supplierDao;

    @Autowired
    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }



    public List<Customer> getAllCustomer() {
        return customerDao.getAllCustomer();
    }

    public void saveCustomer(Customer customer) {
        customer.setId(webUtils.getUUID());
        customerDao.save(customer);
    }

    public void removeCustomer(Customer customer) {
        customerDao.remove(customer.getId());
    }

    public void updateCustomer(Customer customer) {
        customer.setGender(webUtils.transGender(customer.getGender()));
        customerDao.update(customer);
    }

    public List<Supplier> getAllSupplier() {
        return supplierDao.getAll();
    }

    public void saveSupplier(Supplier supplier) {
        supplier.setId(webUtils.getUUID());
        supplierDao.save(supplier);
    }

    public void removeSupplier(Supplier supplier) {
        supplierDao.remove(supplier.getId());
    }

    public void updateSupplier(Supplier supplier) {
        supplierDao.update(supplier);
    }
}
