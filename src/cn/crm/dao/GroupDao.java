package cn.crm.dao;

import cn.crm.domain.Group;

import java.util.List;

/**
 * Created by LEMON on 2017/5/12.
 */
public interface GroupDao {
    //对于订单set放到service层更新
    void save(Group group);

    void remove(String id);

    void update(Group group);

    Group getById(String id);

    List<Group> getAll();
}
