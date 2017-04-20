package cn.crm.domain;

import java.util.Date;

/**
 * Created by LEMON on 2017/4/16.
 */
public class Department {
    private String id;
    private String name;
    private Date gmt_modifed;
    private Date gmt_create;

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
