package cn.crm.service.impl;

import cn.crm.dao.*;
import cn.crm.dao.impl.ScenicSpotDaoImpl;
import cn.crm.domain.Accommodation;
import cn.crm.domain.Food;
import cn.crm.domain.ScenicSpot;
import cn.crm.domain.Vehicle;
import cn.crm.utils.webUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LEMON on 2017/5/5.
 */
@Service
public class BasicInformationServiceImpl {

    private FoodDao foodDao;

    private SupplierDao supplierDao;

    private VehicleDao vehicleDao;

    private AccommodationDao accommodationDao;

    private ScenicSpotDao scenicSpotDao;

    @Autowired
    public void setScenicSpotDao(ScenicSpotDao scenicSpotDao) {
        this.scenicSpotDao = scenicSpotDao;
    }

    @Autowired
    public void setAccommodationDao(AccommodationDao accommodationDao) {
        this.accommodationDao = accommodationDao;
    }

    @Autowired
    public void setVehicleDao(VehicleDao vehicleDao) {
        this.vehicleDao = vehicleDao;
    }

    @Autowired
    public void setFoodDao(FoodDao foodDao) {
        this.foodDao = foodDao;
    }

    @Autowired
    public void setSupplierDao(SupplierDao supplierDao) {
        this.supplierDao = supplierDao;
    }

    public List<Food> getAllFood() {
        List<Food> list = foodDao.getAll();
        for (Food food : list) {
            food.setLevel(webUtils.num2FoodLevel(food.getLevel()));
            food.setSupplier(supplierDao.getSupplierById(food.getSupplier_id()));
            food.setSupplier_name(food.getSupplier().getName());
        }
        return list;
    }

    public void saveFood(Food food) {
        food.setId(webUtils.getUUID());
        food.setLevel(webUtils.transFoodLevel(food.getLevel()));
        foodDao.save(food);
    }

    public void removeFood(Food food) {
        foodDao.remove(food.getId());
    }

    public void updateFood(Food food) {
        food.setLevel(webUtils.transFoodLevel(food.getLevel()));
        foodDao.update(food);
    }

    /**
     * 以下是关于vehicle的方法
     */
    public List<Vehicle> getAllVehicle() {
        List<Vehicle> list = vehicleDao.getAll();
        for (Vehicle vehicle : list) {
            vehicle.setSupplier(supplierDao.getSupplierById(vehicle.getSupplier_id()));
            vehicle.setSupplier_name(vehicle.getSupplier().getName());
        }
        return list;
    }

    public void saveVehicle(Vehicle vehicle) {
        vehicle.setId(webUtils.getUUID());
        vehicleDao.save(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicleDao.remove(vehicle.getId());
    }

    public void updateVehicle(Vehicle vehicle) {
        vehicleDao.update(vehicle);
    }

    /**
     * accommodation
     */
    public List<Accommodation> getAllAccommodation() {
        List<Accommodation> list = accommodationDao.getAll();
        for (Accommodation accommodation : list) {
            accommodation.setLevel(webUtils.num2AccommodationLevel(accommodation.getLevel()));
            accommodation.setSupplier(supplierDao.getSupplierById(accommodation.getSupplier_id()));
            accommodation.setSupplier_name(accommodation.getSupplier().getName());
        }
        return list;
    }

    public void saveAccommodation(Accommodation accommodation) {
        accommodation.setId(webUtils.getUUID());
        accommodation.setLevel(webUtils.transAccommodationLevel(accommodation.getLevel()));
        accommodationDao.save(accommodation);
    }

    public void removeAccommodation(Accommodation accommodation) {
        accommodationDao.remove(accommodation.getId());
    }

    public void updateAccommodation(Accommodation accommodation) {
        accommodation.setLevel(webUtils.transAccommodationLevel(accommodation.getLevel()));
        accommodationDao.update(accommodation);
    }

    /**
     * scenic_spot
     */

    public List<ScenicSpot> getAllScenicSpot() {
        List<ScenicSpot> list = scenicSpotDao.getAll();
        for (ScenicSpot scenicSpot : list) {
            scenicSpot.setLevel(webUtils.num2ScenicSpotLevel(scenicSpot.getLevel()));
        }
        return list;
    }

    public void saveScenicSpot(ScenicSpot scenicSpot) {
        scenicSpot.setLevel(webUtils.transScenicSpotLevel(scenicSpot.getLevel()));
        scenicSpot.setId(webUtils.getUUID());
        scenicSpotDao.save(scenicSpot);
    }

    public void removeScenicSpot(ScenicSpot scenicSpot) {
        scenicSpotDao.remove(scenicSpot.getId());
    }

    public void updateScenicSpot(ScenicSpot scenicSpot) {
        scenicSpot.setLevel(webUtils.transScenicSpotLevel(scenicSpot.getLevel()));
        scenicSpotDao.update(scenicSpot);
    }
}
