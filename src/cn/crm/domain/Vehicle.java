package cn.crm.domain;

import java.util.Date;

/**
 * Created by LEMON on 2017/5/5.
 */
public class Vehicle {
    private String id;
    private String plate_number;
    private int seat_number;
    private int price;
    private Date enable_date;
    private String brand_model;
    private boolean usable;
    private Supplier supplier;
    private String supplier_id;
    private String supplier_name;
    private Date gmt_create;
    private Date gmt_modified;

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPlate_number() {
        return plate_number;
    }

    public void setPlate_number(String plate_number) {
        this.plate_number = plate_number;
    }

    public int getSeat_number() {
        return seat_number;
    }

    public void setSeat_number(int seat_number) {
        this.seat_number = seat_number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getEnable_date() {
        return enable_date;
    }

    public void setEnable_date(Date enable_date) {
        this.enable_date = enable_date;
    }

    public String getBrand_model() {
        return brand_model;
    }

    public void setBrand_model(String brand_model) {
        this.brand_model = brand_model;
    }

    public boolean isUsable() {
        return usable;
    }

    public void setUsable(boolean usable) {
        this.usable = usable;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public String getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(String supplier_id) {
        this.supplier_id = supplier_id;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }
}
