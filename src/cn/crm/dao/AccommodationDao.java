package cn.crm.dao;

import cn.crm.domain.Accommodation;

import java.util.List;

/**
 * Created by LEMON on 2017/5/6.
 */
public interface AccommodationDao {
    void save(Accommodation accommodation);

    void remove(String id);

    void update(Accommodation accommodation);

    Accommodation getById(String id);

    List<Accommodation> getAll();
}
