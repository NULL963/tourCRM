package cn.crm.web.controller;

import cn.crm.domain.*;
import cn.crm.service.impl.BasicInformationServiceImpl;
import cn.crm.service.impl.CustomerMangeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by LEMON on 2017/5/5.
 */
@Controller
public class BasicInformationHandler {

    private BasicInformationServiceImpl service;
    private CustomerMangeServiceImpl customerMangeService;

    @Autowired
    public void setCustomerMangeService(CustomerMangeServiceImpl customerMangeService) {
        this.customerMangeService = customerMangeService;
    }

    @Autowired
    public void setService(BasicInformationServiceImpl service) {
        this.service = service;
    }

    @RequestMapping(value = "/foods.action", method = {RequestMethod.GET})
    public ModelAndView foods() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/food/food.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/food.action", method = {RequestMethod.GET})
    public @ResponseBody Map foodGet() {
        Map map = new HashMap();
        List list = service.getAllFood();
        map.put("rows", list);
        map.put("total", list.size());
        return map;
    }

    @RequestMapping(value = "/foodAppend.action", method = {RequestMethod.GET})
    public ModelAndView foodAppend() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"餐饮".equals(it.next().getType().trim())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/manger/food/foodAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/foodAppend.action", method = {RequestMethod.POST})
    public ModelAndView foodAppendPost(Food food) {
        service.saveFood(food);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/food/food.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/foodRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map foodRemove(@RequestBody Food food) {
        service.removeFood(food);
        Map map = new HashMap();
        List list = service.getAllFood();
        map.put("rows", list);
        map.put("total", list.size());
        return map;
    }

    @RequestMapping(value = "/foodUpdate.action", method = {RequestMethod.GET})
    public ModelAndView foodUpdate(Food food) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("food", food);
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"餐饮".equals(it.next().getType().trim())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/manger/food/foodUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/foodUpdate.action", method = {RequestMethod.POST})
    public ModelAndView foodUpdatePost(Food food) {
        service.updateFood(food);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/food/food.jsp");
        return modelAndView;
    }

    /***
     * 以下是vehicle管理部分
     * @return
     */
    @RequestMapping(value = "/vehicles.action", method = {RequestMethod.GET})
    public ModelAndView vehicles() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/vehicle/vehicle.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/vehicle.action", method = {RequestMethod.GET})
    public @ResponseBody Map vehicleGet() {
        List<Vehicle> list = service.getAllVehicle();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/vehicleAppend.action", method = {RequestMethod.GET})
    public ModelAndView vehicleAppend() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"车辆".equals(it.next().getType().trim())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/manger/vehicle/vehicleAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/vehicleAppend.action", method = {RequestMethod.POST})
    public ModelAndView vehicleAppendPost(Vehicle vehicle) {
        service.saveVehicle(vehicle);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/vehicle/vehicle.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/vehicleRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map vehicleRemove(@RequestBody Vehicle vehicle) {
        service.removeVehicle(vehicle);
        List<Vehicle> list = service.getAllVehicle();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/vehicleUpdate.action", method = {RequestMethod.GET})
    public ModelAndView vehicleUpdate(Vehicle vehicle) {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"车辆".equals(it.next().getType().trim())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.addObject("vehicle", vehicle);
        modelAndView.setViewName("/manger/vehicle/vehicleUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/vehicleUpdate.action", method = {RequestMethod.POST})
    public ModelAndView vehicleUpdatePost(Vehicle vehicle) {
        service.updateVehicle(vehicle);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/vehicle/vehicle.jsp");
        return modelAndView;
    }

    /**
     * 一下是Accommodation部分
     */
    @RequestMapping(value = "/accommodations.action", method = {RequestMethod.GET})
    public ModelAndView accommodations() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/accommodation/accommodation.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/accommodation.action", method = {RequestMethod.GET})
    public @ResponseBody Map accomodationGet() {
        List<Accommodation> list = service.getAllAccommodation();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/accommodationAppend.action", method = {RequestMethod.GET})
    public ModelAndView accommodationAppend() {
        ModelAndView modelAndView = new ModelAndView();
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"住宿".equals(it.next().getType())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/manger/accommodation/accommodationAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = ("/accommodationAppend.action"), method = {RequestMethod.POST})
    public ModelAndView accommodationAppendPost(Accommodation accommodation) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveAccommodation(accommodation);
        modelAndView.setViewName("/manger/accommodation/accommodation.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/accommodationRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map accommodationRemove(@RequestBody Accommodation accommodation) {
        service.removeAccommodation(accommodation);
        List<Accommodation> list = service.getAllAccommodation();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/accommodationUpdate.action", method = {RequestMethod.GET})
    public ModelAndView accommodationUpdate(Accommodation accommodation) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("accommodation", accommodation);
        List<Supplier> list = customerMangeService.getAllSupplier();
        Iterator<Supplier> it = list.iterator();
        while (it.hasNext()) {
            if (!"住宿".equals(it.next().getType())) {
                it.remove();
            }
        }
        modelAndView.addObject("list", list);
        modelAndView.setViewName("/manger/accommodation/accommodationUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/accommodationUpdate.action", method = {RequestMethod.POST})
    public ModelAndView accommodationUpdatePost(Accommodation accommodation) {
        service.updateAccommodation(accommodation);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/accommodation/accommodation.jsp");
        return modelAndView;
    }

    /**
     * scenic_spot
     */

    @RequestMapping(value = "/scenic_spots.action", method = {RequestMethod.GET})
    public ModelAndView scenicSpots() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/scenicSpot/scenicSpot.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/scenic_spot.action", method = {RequestMethod.GET})
    public @ResponseBody Map scenicSpotGet() {
        Map map = new HashMap();
        List list = service.getAllScenicSpot();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/scenic_spotAppend.action", method = {RequestMethod.GET})
    public ModelAndView scenicSpotAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/scenicSpot/scenicSpotAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/scenic_spotAppend.action", method = {RequestMethod.POST})
    public ModelAndView scenicSpotAppendPost(ScenicSpot scenicSpot) {
        ModelAndView modelAndView = new ModelAndView();
        service.saveScenicSpot(scenicSpot);
        modelAndView.setViewName("/manger/scenicSpot/scenicSpot.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/scenic_spotRemove.action", method = {RequestMethod.DELETE})
    public @ResponseBody Map scenicSpotRemove(@RequestBody ScenicSpot scenicSpot) {
        service.removeScenicSpot(scenicSpot);
        Map map = new HashMap();
        List list = service.getAllScenicSpot();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/scenic_spotUpdate.action", method = {RequestMethod.GET})
    public ModelAndView scenicSpotUpdate(ScenicSpot scenicSpot) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("spot", scenicSpot);
        modelAndView.setViewName("/manger/scenicSpot/scenicSpotUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/scenic_spotUpdate.action", method = {RequestMethod.POST})
    public ModelAndView scenicSpotUpdatePost(ScenicSpot scenicSpot) {
        ModelAndView modelAndView = new ModelAndView();
        service.updateScenicSpot(scenicSpot);
        modelAndView.setViewName("/manger/scenicSpot/scenicSpot.jsp");
        return modelAndView;
    }

    /**
     * Product
     */
    @RequestMapping(value = "/products.action", method = {RequestMethod.GET})
    public ModelAndView products() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/product/product.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/product.action", method = {RequestMethod.GET})
    public @ResponseBody Map productGet() {
        List<Product> list = service.getAllProduct();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/productDetail.action", method = {RequestMethod.POST})
    public @ResponseBody List productDetail(@RequestBody Product product) {
        product = service.getProductById(product.getId());
        List list = new ArrayList();
        Set<Accommodation> set = product.getAccommodationSet();
        for (Accommodation accommodation : set) {
            Map map = new HashMap();
            map.put("text", accommodation.getSupplier_name());
            map.put("group", "住宿");
            list.add(map);
        }
        for (ScenicSpot scenicSpot : product.getSpotSet()) {
            Map map = new HashMap();
            map.put("text", scenicSpot.getName());
            map.put("group", "景点");
            list.add(map);
        }
        for (Food food : product.getFoodSet()) {
            Map map = new HashMap();
            map.put("text", food.getName());
            map.put("group", "餐饮");
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/productAppend.action", method = {RequestMethod.GET})
    public ModelAndView productAppend() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/manger/product/productAppend.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/getAccommodation.action", method = {RequestMethod.GET})
    public @ResponseBody List getAllAccomodation() {
        List<Map<String, String>> list = new ArrayList();
        List<Accommodation> accommodationList = service.getAllAccommodation();
        for (Accommodation accommodation : accommodationList) {
            Map map = new HashMap();
            map.put("id", accommodation.getId());
            map.put("text", accommodation.getSupplier_name());
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/getFood.action", method = {RequestMethod.GET})
    public @ResponseBody List getAllFood() {
        List<Map<String, String>> list = new ArrayList();
        List<Food> foodList = service.getAllFood();
        for (Food food : foodList) {
            Map map = new HashMap();
            map.put("id", food.getId());
            map.put("text", food.getName());
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/getSpot.action", method = {RequestMethod.GET})
    public @ResponseBody List getAllSpot() {
        List<Map<String, String>> list = new ArrayList();
        List<ScenicSpot> scenicSpotList = service.getAllScenicSpot();
        for (ScenicSpot scenicSpot : scenicSpotList) {
            Map map = new HashMap();
            map.put("id", scenicSpot.getId());
            map.put("text", scenicSpot.getName());
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/productAppend.action", method = {RequestMethod.POST})
    public ModelAndView productAppend(Product product, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String [] foodId = request.getParameterValues("foodSet.id");
        for (int i=0; i<foodId.length; i++) {
            product.getFoodSet().add(service.getFoodById(foodId[i]));
        }
        String [] spotId = request.getParameterValues("spotSet.id");
        for (int i=0; i<spotId.length; i++) {
            product.getSpotSet().add(service.getSpotById(spotId[i]));
        }
        String [] accommodationId = request.getParameterValues("accommodationSet.id");
        for (int i=0; i<accommodationId.length; i++) {
            product.getAccommodationSet().add(service.getAccommodationById(accommodationId[i]));
        }
        service.saveProduct(product);
        modelAndView.setViewName("/manger/product/product.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/productRemove.action", method = {RequestMethod.DELETE})
    public
    @ResponseBody
    Map productRemove(@RequestBody Product product) {
        service.removeProduct(product);
        List<Product> list = service.getAllProduct();
        Map map = new HashMap();
        map.put("total", list.size());
        map.put("rows", list);
        return map;
    }

    @RequestMapping(value = "/productUpdate.action", method = {RequestMethod.GET})
    public ModelAndView productUpdate(Product product) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product", product);
        modelAndView.setViewName("/manger/product/productUpdate.jsp");
        return modelAndView;
    }

    @RequestMapping(value = "/updateProductAccommodation.action", method = {RequestMethod.GET})
    public @ResponseBody List productUpdateAccommodation(String id) {
        List<Map<String, String>> list = new ArrayList();
        Product product = service.getProductById(id);
        List<Accommodation> accommodationList = service.getAllAccommodation();
        for (Accommodation accommodation : accommodationList) {
            Map map = new HashMap();
            map.put("id", accommodation.getId());
            map.put("text", accommodation.getSupplier_name());
            if (product.getAccommodationSet().contains(accommodation)) {
                map.put("selected", true);
            }
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/updateProductFood.action", method = {RequestMethod.GET})
    public
    @ResponseBody
    List updateProductFood(String id) {
        Product product = service.getProductById(id);
        List<Map<String, String>> list = new ArrayList();
        List<Food> foodList = service.getAllFood();
        for (Food food : foodList) {
            Map map = new HashMap();
            map.put("id", food.getId());
            map.put("text", food.getName());
            if (product.getFoodSet().contains(food)) {
                map.put("selected", true);
            }
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/updateProductSpot.action", method = {RequestMethod.GET})
    public @ResponseBody List updateProductSpot(String id) {
        Product product = service.getProductById(id);
        List<Map<String, String>> list = new ArrayList();
        List<ScenicSpot> scenicSpotList = service.getAllScenicSpot();
        for (ScenicSpot scenicSpot : scenicSpotList) {
            Map map = new HashMap();
            map.put("id", scenicSpot.getId());
            map.put("text", scenicSpot.getName());
            if (product.getSpotSet().contains(scenicSpot)) {
                map.put("selected", true);
            }
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/productUpdate.action", method = {RequestMethod.POST})
    public ModelAndView productUpdatePost(Product product, HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        String [] foodId = request.getParameterValues("foodSet.id");
        for (int i=0; i<foodId.length; i++) {
            product.getFoodSet().add(service.getFoodById(foodId[i]));
        }
        String [] spotId = request.getParameterValues("spotSet.id");
        for (int i=0; i<spotId.length; i++) {
            product.getSpotSet().add(service.getSpotById(spotId[i]));
        }
        String [] accommodationId = request.getParameterValues("accommodationSet.id");
        for (int i=0; i<accommodationId.length; i++) {
            product.getAccommodationSet().add(service.getAccommodationById(accommodationId[i]));
        }
        service.updateProduct(product);
        modelAndView.setViewName("/manger/product/product.jsp");
        return modelAndView;
    }
}
