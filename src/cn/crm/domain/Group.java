package cn.crm.domain;

import java.util.Set;

/**
 * Created by LEMON on 2017/5/11.
 */
public class Group {
    private String id;
    private String number;

    private String tour_guide_id;
    private Employee tour_guide;

    private String driver_id;
    private Employee driver;

    private String product_id;
    private Product product;

    private Set<Order> orderSet;

    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getTour_guide_id() {
        return tour_guide_id;
    }

    public void setTour_guide_id(String tour_guide_id) {
        this.tour_guide_id = tour_guide_id;
    }

    public Employee getTour_guide() {
        return tour_guide;
    }

    public void setTour_guide(Employee tour_guide) {
        this.tour_guide = tour_guide;
    }

    public String getDriver_id() {
        return driver_id;
    }

    public void setDriver_id(String driver_id) {
        this.driver_id = driver_id;
    }

    public Employee getDriver() {
        return driver;
    }

    public void setDriver(Employee driver) {
        this.driver = driver;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
