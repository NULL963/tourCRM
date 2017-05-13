package test;

import cn.crm.dao.GroupDao;
import cn.crm.dao.impl.GroupDaoImpl;
import cn.crm.domain.Group;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * GroupDao的测试类已完成测验无明显异常
 * Created by LEMON on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class GroupDaoTest {
    @Test
    public void save() {
        GroupDao dao = new GroupDaoImpl();
        Group group = new Group();
        group.setId(webUtils.getUUID());
        dao.save(group);
    }

    @Test
    public void update() {
        GroupDao dao = new GroupDaoImpl();
        Group group = new Group();
        group.setId("2a051c6c4693496083139e2590b9b007");
        group.setNumber("123");
        dao.update(group);
    }

    @Test
    public void getById() {
        GroupDao dao = new GroupDaoImpl();
        Group group = dao.getById("2a051c6c4693496083139e2590b9b007");
    }

    @Test
    public void getAll() {
        GroupDao dao = new GroupDaoImpl();
        List list = dao.getAll();
    }

    @Test
    public void remove() {
        GroupDao dao = new GroupDaoImpl();
        dao.remove("2a051c6c4693496083139e2590b9b007");
    }
}
