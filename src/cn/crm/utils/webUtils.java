package cn.crm.utils;

import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by LEMON on 2017/4/15.
 */
public class webUtils {
    public static <T> T request2Bean (HttpServletRequest req, HttpServletResponse resp, Class<T> beanClass) {
        try {
            T bean = beanClass.newInstance();
            Map map = req.getParameterMap();
            BeanUtils.populate(bean, map);
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
