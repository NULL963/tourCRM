package cn.crm.web.controller;

import cn.crm.domain.Customer;
import cn.crm.domain.Supplier;
import cn.crm.service.impl.CustomerMangeServiceImpl;
import cn.crm.utils.webUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LEMON on 2017/5/3.
 */
@Controller
public class CustomerMangerHandler {
    private CustomerMangeServiceImpl service;

    @Autowired
    public void setService(CustomerMangeServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/customers.action", method = {RequestMethod.GET})
    public ModelAndView customer() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/customer/customer.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/customer.action", method = {RequestMethod.GET})
    public @ResponseBody Map customerGet() {
        List<Customer> list = service.getAllCustomer();
        for (Customer customer : list) {
            customer.setGender(webUtils.num2Gender(customer.getGender()));
        }
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/customerAppend.action", method = {RequestMethod.GET})
    public ModelAndView customerAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/customer/customerAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/customerAppend.action", method = {RequestMethod.POST})
    public ModelAndView customerAppendPost(Customer customer) {
        customer.setGender(webUtils.transGender(customer.getGender()));
        service.saveCustomer(customer);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/customer/customer.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/customerRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map customerRemove(@RequestBody Customer customer1) {
        service.removeCustomer(customer1);
        List<Customer> list = service.getAllCustomer();
        for (Customer customer : list) {
            customer.setGender(webUtils.num2Gender(customer.getGender()));
        }
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/customerUpdate.action", method = {RequestMethod.GET})
    public ModelAndView customerUpdate(Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customer", customer);
        modelAndView.setViewName("/manger/customer/customerUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/customerUpdate.action", method = {RequestMethod.POST})
    public ModelAndView customerUpdatePost(Customer customer) {
        ModelAndView modelAndView = new ModelAndView();
        service.updateCustomer(customer);
        modelAndView.setViewName("/manger/customer/customer.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/suppliers.action", method = {RequestMethod.GET})
    public ModelAndView supplier() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/supplier/supplier.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/supplier.action", method = {RequestMethod.GET})
    public @ResponseBody Map supplierGet() {
        Map map = new HashMap();
        List<Supplier> list = service.getAllSupplier();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/supplierAppend.action", method = {RequestMethod.GET})
    public ModelAndView supplierAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/supplier/supplierAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/supplierAppend.action", method = {RequestMethod.POST})
    public ModelAndView supplierAppendPost(Supplier supplier) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveSupplier(supplier);
        modelAndView.setViewName("/manger/supplier/supplier.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/supplierRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map supplierRemove(@RequestBody Supplier supplier) {
        service.removeSupplier(supplier);
        Map map = new HashMap();
        List<Supplier> list = service.getAllSupplier();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/supplierUpdate.action", method = {RequestMethod.GET})
    public ModelAndView supplierUpdate(Supplier supplier) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("supplier", supplier);
        modelAndView.setViewName("/manger/supplier/supplierUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/supplierUpdate.action", method = {RequestMethod.POST})
    public ModelAndView supplierUpdatePost(Supplier supplier) {
        ModelAndView modelAndView = new ModelAndView();
        service.updateSupplier(supplier);
        modelAndView.setViewName("/manger/supplier/supplier.jsp");
        return modelAndView;
    }
}
