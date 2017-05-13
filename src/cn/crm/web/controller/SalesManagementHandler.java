package cn.crm.web.controller;

import cn.crm.domain.Customer;
import cn.crm.domain.Employee;
import cn.crm.domain.Order;
import cn.crm.domain.Product;
import cn.crm.service.impl.BasicInformationServiceImpl;
import cn.crm.service.impl.CustomerMangeServiceImpl;
import cn.crm.service.impl.SalesManagementServiceImpl;
import cn.crm.service.impl.SystemMangeServiceImpl;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * Created by LEMON on 2017/5/11.
 */
@Controller
public class SalesManagementHandler {

    private SalesManagementServiceImpl service;
    private SystemMangeServiceImpl systemMangeService;
    private BasicInformationServiceImpl basicInformationService;
    private CustomerMangeServiceImpl customerMangeService;

    @Autowired
    public void setCustomerMangeService(CustomerMangeServiceImpl customerMangeService) {
        this.customerMangeService = customerMangeService;
    }

    @Autowired
    public void setBasicInformationService(BasicInformationServiceImpl basicInformationService) {
        this.basicInformationService = basicInformationService;
    }

    @Autowired
    public void setSystemMangeService(SystemMangeServiceImpl systemMangeService) {
        this.systemMangeService = systemMangeService;
    }

    @Autowired
    public void setService(SalesManagementServiceImpl service) {
        this.service = service;
    }

    /**
     * order
     * @return
     */
    @RequestMapping(value = "/orders.action", method = {RequestMethod.GET})
    public ModelAndView orders() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/order/order.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/order.action", method = {RequestMethod.GET})
    public
    @ResponseBody
    Map orderGet() {
        Map map = new HashMap();
        List list = service.getALlOrder();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/orderAppend.action", method = {RequestMethod.GET})
    public ModelAndView orderAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("productList", basicInformationService.getAllProduct());
        modelAndView.setViewName("/manger/order/orderAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/getCustomer.action", method = {RequestMethod.GET})
    public
    @ResponseBody
    List orderAppendGetEmployee() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Customer> customerList = customerMangeService.getAllCustomer();
        for (Customer customer : customerList) {
            Map map = new HashMap();
            map.put("id", customer.getId());
            map.put("text", customer.getName());
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/orderAppend.action", method = {RequestMethod.POST})
    public ModelAndView orderAppendPost(Order order, HttpSession session, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        order.setEmployee_id(systemMangeService.getUserById((String) session.getAttribute("userId")).getId());
        String[] itmes = request.getParameterValues("customerSet.id");
        for (int i = 0; i < itmes.length; i++) {
            order.getCustomerSet().add(customerMangeService.getCustomerById(itmes[i]));
        }
        service.saveOrder(order);
        modelAndView.setViewName("/manger/order/order.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/orderRemove.action", method = {RequestMethod.DELETE})
    public
    @ResponseBody
    Map orderRemove(@RequestBody Order order) {
        service.removeOrder(order.getId());
        Map map = new HashMap();
        List<Order> orderList = service.getALlOrder();
        map.put("rows", orderList.size());
        map.put("total", orderList);
        return map;
    }

    @RequestMapping(value = "/orderDetail.action", method = {RequestMethod.POST})
    public
    @ResponseBody
    List orderDetail(@RequestBody Order order) {
        List list = new ArrayList();
        order = service.getOrderById(order.getId());
        for (Customer customer : order.getCustomerSet()) {
            Map map = new HashMap();
            map.put("text", customer.getName());
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/orderUpdate.action", method = {RequestMethod.GET})
    public ModelAndView orderUpdate(Order order) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("order", order);
        modelAndView.addObject("productList", basicInformationService.getAllProduct());
        modelAndView.setViewName("/manger/order/orderUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/updateGetCustomer.action", method = {RequestMethod.GET})
    @ResponseBody
    public List OrderUpdateGetCustomer(String id) {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        List<Customer> customerList = customerMangeService.getAllCustomer();
        Order order = service.getOrderById(id);
        for (Customer customer : customerList) {
            Map map = new HashMap();
            map.put("id", customer.getId());
            map.put("text", customer.getName());
            if (order.getCustomerSet().contains(customer)) {
                map.put("selected", true);
            }
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/orderUpdate.action", method = {RequestMethod.POST})
    public ModelAndView orderUpdatePost(Order order, HttpServletRequest request, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        order.setEmployee_id(systemMangeService.getUserById((String) session.getAttribute("userId")).getId());
        String[] itmes = request.getParameterValues("customerSet.id");
        for (int i = 0; i < itmes.length; i++) {
            order.getCustomerSet().add(customerMangeService.getCustomerById(itmes[i]));
        }
        order.setConditions(service.getOrderById(order.getId()).getConditions());
        service.updateOrder(order);
        modelAndView.setViewName("/manger/order/order.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/orderAuditing.action", method = {RequestMethod.POST})
    @ResponseBody
    public Map orderAuditing(@RequestBody Order order) {
        service.auditingOrder(order.getId());
        Map map = new HashMap();
        List<Order> orderList = service.getALlOrder();
        map.put("rows", orderList.size());
        map.put("total", orderList);
        return map;
    }

    @RequestMapping(value = "/orderCancel.action", method = {RequestMethod.POST})
    @ResponseBody
    public Map orderCancel(@RequestBody Order order) {
        service.cancelOrder(order.getId());
        Map map = new HashMap();
        List<Order> orderList = service.getALlOrder();
        map.put("rows", orderList.size());
        map.put("total", orderList);
        return map;
    }


}
