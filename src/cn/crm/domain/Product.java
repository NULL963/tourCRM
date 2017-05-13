package cn.crm.domain;

import java.util.List;
import java.util.Set;

/**
 * Created by LEMON on 2017/5/8.
 */
public class Product {

    private String id;
    private int money;
    private String number;
    private String name;
    private String description;
    private Set<ScenicSpot> spotSet;
    private Set<Accommodation> accommodationSet;
    private Set<Food> foodSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ScenicSpot> getSpotSet() {
        return spotSet;
    }

    public void setSpotSet(Set<ScenicSpot> spotSet) {
        this.spotSet = spotSet;
    }

    public Set<Accommodation> getAccommodationSet() {
        return accommodationSet;
    }

    public void setAccommodationSet(Set<Accommodation> accommodationSet) {
        this.accommodationSet = accommodationSet;
    }

    public Set<Food> getFoodSet() {
        return foodSet;
    }

    public void setFoodSet(Set<Food> foodSet) {
        this.foodSet = foodSet;
    }
}
