package test;

import cn.crm.dao.ScenicSpotDao;
import cn.crm.dao.impl.ScenicSpotDaoImpl;
import cn.crm.domain.ScenicSpot;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * ScenicSpotDao的测试类已完成测试无问题
 * Created by LEMON on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class scenicSpotDaoTest {
    @Test
    public void save() {
        ScenicSpotDao dao = new ScenicSpotDaoImpl();
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setId(webUtils.getUUID());
        dao.save(scenicSpot);

    }

    @Test
    public void update() {
        ScenicSpotDao dao = new ScenicSpotDaoImpl();
        ScenicSpot scenicSpot = new ScenicSpot();
        scenicSpot.setId("47f5cbb972144a969b734c79d061a31f");
        scenicSpot.setName("大明湖");
        dao.update(scenicSpot);

    }

    @Test
    public void getById() {
        ScenicSpotDao dao = new ScenicSpotDaoImpl();
        ScenicSpot scenicSpot = dao.getById("47f5cbb972144a969b734c79d061a31f");
    }

    @Test
    public void getByName() {
        ScenicSpotDao dao = new ScenicSpotDaoImpl();
        ScenicSpot scenicSpot = dao.getByName("大明湖");
    }

    @Test
    public void getAll() {
        ScenicSpotDao dao = new ScenicSpotDaoImpl();
        List<ScenicSpot> lsst = dao.getAll();
    }
}
