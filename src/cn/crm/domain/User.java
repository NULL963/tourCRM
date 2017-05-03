package cn.crm.domain;

import java.util.Date;

/**
 * Created by LEMON on 2017/4/16.
 */
public class User {
    private String id;
    private String name;
    private String password;
    private String description;

    private Date gmt_modifed;

    private Date gmt_create;
    private Employee  employee;
    private String employee_id;


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGmt_modifed() {
        return gmt_modifed;
    }

    public void setGmt_modifed(Date gmt_modifed) {
        this.gmt_modifed = gmt_modifed;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

}
