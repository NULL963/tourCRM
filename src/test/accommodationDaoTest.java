package test;

import cn.crm.dao.AccommodationDao;
import cn.crm.dao.impl.AccommodationDaoImpl;
import cn.crm.domain.Accommodation;
import cn.crm.utils.webUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * Created by LEMON on 2017/5/6.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:beans.xml"})
public class accommodationDaoTest {
    @Test
    public void save() {
        AccommodationDao dao = new AccommodationDaoImpl();
        Accommodation accommodation = new Accommodation();
        accommodation.setId(webUtils.getUUID());
        accommodation.setSupplier_id("c9f61cdd88574477b99d25955b3fba4f");
        dao.save(accommodation);

    }

    @Test
    public void update() {
        AccommodationDao dao = new AccommodationDaoImpl();
        Accommodation accommodation = new Accommodation();
        accommodation.setId("742415ca008d445f9c1d704a3e00f045");
        accommodation.setSupplier_id("c9f61cdd88574477b99d25955b3fba4f");
        accommodation.setAddress("东林星区间大区");
        dao.update(accommodation);
    }

    @Test
    public void getById() {
        AccommodationDao dao = new AccommodationDaoImpl();
        Accommodation accommodation = dao.getById("742415ca008d445f9c1d704a3e00f045");
    }

    @Test
    public void getAll() {
        AccommodationDao dao = new AccommodationDaoImpl();
        List<Accommodation> list = dao.getAll();
    }

    @Test
    public void remove() {
        AccommodationDao dao = new AccommodationDaoImpl();
        dao.remove("742415ca008d445f9c1d704a3e00f045");

    }
}
