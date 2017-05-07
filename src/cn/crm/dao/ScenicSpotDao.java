package cn.crm.dao;

import cn.crm.domain.ScenicSpot;

import java.util.List;

/**
 * Created by LEMON on 2017/5/7.
 */
public interface ScenicSpotDao {
    void save(ScenicSpot scenicSpot);

    void remove(String id);

    void update(ScenicSpot scenicSpot);

    ScenicSpot getById(String id);

    ScenicSpot getByName(String name);

    List<ScenicSpot> getAll();
}
