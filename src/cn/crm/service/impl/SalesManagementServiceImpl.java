package cn.crm.service.impl;

import cn.crm.dao.*;
import cn.crm.domain.Group;
import cn.crm.domain.Order;
import cn.crm.enums.Condition;
import cn.crm.utils.webUtils;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LEMON on 2017/5/11.
 */
@Service
public class SalesManagementServiceImpl {

    private OrderDao orderDao;
    private CustomerDao customerDao;
    private EmployeeDao employeeDao;
    private ProductDao productDao;
    private GroupDao groupDao;

    @Autowired
    public void setGroupDao(GroupDao groupDao) {
        this.groupDao = groupDao;
    }

    @Autowired
    public void setProductDao(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Autowired
    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    /**
     * order
     */
    public List<Order> getALlOrder() {
        List<Order> list = orderDao.getAll();
        for (Order order : list) {
            //装配employee
            String id;
            id = order.getEmployee_id();
            if (id != null && !"".equals(id.trim())) {
                order.setEmployee(employeeDao.getEmployeeById(order.getEmployee_id()));
                order.setEmployee_name(order.getEmployee().getName());
            }
            //装配product
            id = order.getProduct_id();
            if (id != null && !"".equals(id.trim())) {
                order.setProduct(productDao.getById(order.getProduct_id()));
                order.setProduct_number(order.getProduct().getNumber());
            }
            //装配group
            id = order.getGroup_id();
            if (id != null && !"".equals(id.trim())) {
                order.setGroup(groupDao.getById(order.getGroup_id()));
                order.setGroup_number(order.getGroup().getNumber());
            }

            order.setConditions(webUtils.num2Condition(order.getConditions()));
        }
        return list;
    }

    public void saveOrder(Order order) {
        order.setId(webUtils.getUUID());
        order.setConditions("0");
        orderDao.save(order);
    }

    public void removeOrder(String id) {
        orderDao.remove(id);
    }

    public Order getOrderById(String id) {
        Order order = orderDao.getById(id);
        return order;
    }

    public void updateOrder(Order order) {
        orderDao.update(order);
    }

    public void auditingOrder(String id) {
        orderDao.changeCondition("1", id);
    }

    public void cancelOrder(String id) {
        orderDao.changeCondition("2", id);
    }

    /**
     * group
     */

}
