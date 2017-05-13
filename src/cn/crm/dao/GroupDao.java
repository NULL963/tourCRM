package cn.crm.dao;

import cn.crm.domain.Group;

import java.util.List;

/**
 * Created by LEMON on 2017/5/12.
 */
public interface GroupDao {
    //���ڶ���set�ŵ�service�����
    void save(Group group);

    void remove(String id);

    void update(Group group);

    Group getById(String id);

    List<Group> getAll();
}
