package cn.crm.web.controller;

import cn.crm.domain.Department;
import cn.crm.domain.Employee;
import cn.crm.domain.User;
import cn.crm.enums.Gender;
import cn.crm.service.impl.SystemMangeServiceImpl;
import cn.crm.utils.webUtils;
import cn.crm.vdomain.Vemployee;
import cn.crm.vdomain.Vuser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LEMON on 2017/4/21.
 * 系统管理Handler 员工管理 角色管理 用户管理 部门管理
 */
@Controller
public class SystemMangeHandler {
    SystemMangeServiceImpl service;

    @Autowired
    public void setUserService(SystemMangeServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/users.action", method = {RequestMethod.GET})
    public ModelAndView user() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/user.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/userAppend.action", method = {RequestMethod.GET})
    public ModelAndView userAppend() {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> list = service.getAllEmployee();
        modelAndView.addObject("emList", list);
        modelAndView.setViewName("/manger/user/userAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/userAppend.action", method = {RequestMethod.POST})
    public ModelAndView userAppendPost(User user) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveUser(user);
        modelAndView.setViewName("/manger/user.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/user.action", method = {RequestMethod.GET})
    public
    @ResponseBody
    Map userGet() {
        Map map = new HashMap();
        List<Vuser> vusers = service.getAllUser();
        map.put("total", vusers.size());
        map.put("rows", vusers);
        return map;
    }

    @RequestMapping(value = "/user.action", method = {RequestMethod.DELETE})
    public
    @ResponseBody
    Map userDelete(@RequestBody User user) {
        service.deleteUser(user.getId());
        Map map = new HashMap();
        List<Vuser> vusers = service.getAllUser();
        map.put("total", vusers.size());
        map.put("rows", vusers);
        return map;
    }

    @RequestMapping(value = "/userUpdate.action", method = {RequestMethod.GET})
    public ModelAndView userUpdate(Vuser vuser) {
        ModelAndView modelAndView = new ModelAndView();
        List<Employee> list = service.getAllEmployee();
        modelAndView.addObject("vuser", vuser);
        modelAndView.addObject("emList", list);
        modelAndView.setViewName("/manger/user/userUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/userUpdate.action", method = {RequestMethod.POST})
    public ModelAndView userUpdatePost(Vuser vuser) {
        ModelAndView modelAndView = new ModelAndView();
        service.updateUser(vuser);
        modelAndView.setViewName("/manger/user.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/employees.action", method = {RequestMethod.GET})
    public ModelAndView employee() {
        ModelAndView modelandview = new ModelAndView();
        modelandview.setViewName("/manger/employee/employee.jsp");
        return modelandview;
    }

    @RequestMapping(value = "/employee.action", method = {RequestMethod.GET})
    public
    @ResponseBody
    Map employeeGet() {
        Map map = new HashMap();
        List<Employee> list = service.getAllEmployee();
        List<Vemployee> vlist = new ArrayList<Vemployee>();
        Vemployee vemployee = null;
        for (Employee employee : list) {
            vemployee = webUtils.source2aim(employee, Vemployee.class);
            vemployee.setHiredate(webUtils.formatDate(employee.getHireDate()));
            vemployee.setDepartment(employee.getDepartment().getName());
            vemployee.setGender(webUtils.num2Gender(employee.getGender()));
            vlist.add(vemployee);
        }
        map.put("total", vlist.size());
        map.put("rows", vlist);
        return map;
    }

    @RequestMapping(value = "/employeeAppend.action", method = {RequestMethod.GET})
    public ModelAndView employeeAppend() {
        ModelAndView modelAndView = new ModelAndView();
        List<Department> list = service.getAllDepartment();
        modelAndView.addObject("departmentList", list);
        modelAndView.setViewName("/manger/employee/employeeAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/employeeAppend.action", method = {RequestMethod.POST})
    public ModelAndView employeeAppendPost(Vemployee vemployee) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveEmployee(vemployee);
        modelAndView.setViewName("/manger/employee/employee.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/employeeRemove.action", method = {RequestMethod.DELETE})
    public
    @ResponseBody
    Map employeeRemove(@RequestBody Vemployee vem, HttpServletRequest request, HttpServletResponse response) {
        service.removeEmployee(vem.getId());
        Map map = new HashMap();
        List<Employee> list = service.getAllEmployee();
        List<Vemployee> vlist = new ArrayList<Vemployee>();
        Vemployee vemployee = null;
        for (Employee employee : list) {
            vemployee = webUtils.source2aim(employee, Vemployee.class);
            vemployee.setHiredate(webUtils.formatDate(employee.getHireDate()));
            vemployee.setDepartment(employee.getDepartment().getName());
            vemployee.setGender(webUtils.num2Gender(employee.getGender()));
            vlist.add(vemployee);
        }
        map.put("total", vlist.size());
        map.put("rows", vlist);
        return map;
    }

    @RequestMapping(value = "/employeeUpdate.action", method = {RequestMethod.GET})
    public ModelAndView employeeUpdateGet(Vemployee vemployee) {
        ModelAndView modelAndView = new ModelAndView();
        List<Department> list = service.getAllDepartment();
        modelAndView.addObject("vemployee", vemployee);
        modelAndView.addObject("deList", list);
        modelAndView.setViewName("/manger/employee/employeeUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/employeeUpdate.action", method = {RequestMethod.POST})
    public ModelAndView employeeUpdatePost(Vemployee vemployee) {
        ModelAndView modelAndView = new ModelAndView();
        service.updateEmployee(vemployee);
        modelAndView.setViewName("/manger/employee/employee.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/departments.action", method = {RequestMethod.GET})
    public ModelAndView department() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/department/department.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/department.action", method = {RequestMethod.GET})
    public @ResponseBody Map departmentGet() {
        Map map = new HashMap();
        List<Department> list = service.getAllDepartment();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/departmentAppend.action", method = {RequestMethod.GET})
    public ModelAndView departmentAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/department/departmentAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/departmentAppend.action", method = {RequestMethod.POST})
    public ModelAndView departmentAppendPost(Department department) {
        service.saveDepartment(department);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/department/department.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/departmentRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map departmentRemove(@RequestBody Department department) {
        service.removeDepartment(department);
        Map map = new HashMap();
        List<Department> list = service.getAllDepartment();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/departmentUpdate.action", method = {RequestMethod.GET})
    public ModelAndView departmentUpdate(Department department) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("department", department);
        modelAndView.setViewName("/manger/department/departmentUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/departmentUpdate.action", method = {RequestMethod.POST})
    public ModelAndView departmentUpdatePost(Department department) {
        service.updateDepartment(department);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/department/department.jsp");
        return modelAndView;
    }
}



