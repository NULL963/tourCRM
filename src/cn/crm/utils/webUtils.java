package cn.crm.utils;

import cn.crm.enums.AccommodationLevel;
import cn.crm.enums.FoodLevel;
import cn.crm.enums.Gender;
import cn.crm.enums.ScenicSpotLevel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

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

    /**
     * 把源对象的数据转入到目标对象中
     * @param sourceClass
     * @param aimClass
     * @param <T>
     * @param <E>
     * @return
     */
    public static <T,E> E source2aim(T sourceClass, Class<E> aimClass) {
        try {
            E aim = aimClass.newInstance();
            ConvertUtils.register(new Converter() {
                @Override
                public Object convert(Class aClass, Object o) {
                    if (o == null) {
                        return null;
                    }
                    if (!(o instanceof String)) {
                        throw new ConversionException("不支持String类型之外的转换");
                    }

                    String value = (String) o;
                    if ("".equals(value.trim())) {
                        return null;
                    }
                    SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                    try {
                        return format.parse(value);
                    } catch (ParseException e) {
                        throw new RuntimeException(e);
                    }
                }
            },Date.class);
            BeanUtils.copyProperties(aim, sourceClass);
            return aim;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String formatDate(Date date) {
        if (date != null) {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            return format.format(date);
        }
        return null;
    }

    public static Date parseDate(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return format.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /**
     * 男to1
     * @param value
     * @return
     */
    public static String transGender(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        Gender gender = Gender.valueOf(Gender.class, value);
        return gender.getValue();
    }

    /**
     * 转换餐饮等级到对饮的数据库单字符
     * @param value
     * @return
     */
    public static String transFoodLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        FoodLevel foodLevel = Enum.valueOf(FoodLevel.class, value);
        return foodLevel.getValue();
    }



    /**
     * 将数据库中存储的单字符转化为汉子
     * @param value
     * @return
     */
    public static String  num2Gender(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("1".equals(value.trim())) {
            return Gender.valueOf("男").name();
        }
        if ("0".equals(value.trim())) {
            return Gender.valueOf("女").name();
        }
        return Gender.valueOf("其他").name();
    }

    public static String  num2FoodLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("0".equals(value.trim())) {
            return FoodLevel.valueOf("普通").name();
        }
        if ("1".equals(value.trim())) {
            return FoodLevel.valueOf("精美").name();
        }
        return FoodLevel.valueOf("豪华").name();
    }

    public static String  num2AccommodationLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("6".equals(value.trim())) {
            return AccommodationLevel.valueOf("白金五星").name();
        }
        if ("1".equals(value.trim())) {
            return AccommodationLevel.valueOf("一星").name();
        }
        if ("2".equals(value.trim())) {
            return AccommodationLevel.valueOf("二星").name();
        }
        if ("3".equals(value.trim())) {
            return AccommodationLevel.valueOf("三星").name();
        }
        if ("4".equals(value.trim())) {
            return AccommodationLevel.valueOf("四星").name();
        }
        if ("5".equals(value.trim())) {
            return AccommodationLevel.valueOf("五星").name();
        }
        return AccommodationLevel.valueOf("普通").name();
    }
    public static String transAccommodationLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        AccommodationLevel accommodationLevel = Enum.valueOf(AccommodationLevel.class, value);
        return accommodationLevel.getValue();
    }

    public static String  num2ScenicSpotLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("0".equals(value.trim())) {
            return ScenicSpotLevel.valueOf("A").name();
        }
        if ("1".equals(value.trim())) {
            return ScenicSpotLevel.valueOf("AA").name();
        }
        if ("2".equals(value.trim())) {
            return ScenicSpotLevel.valueOf("AAA").name();
        }
        if ("3".equals(value.trim())) {
            return ScenicSpotLevel.valueOf("AAAA").name();
        }
        if ("4".equals(value.trim())) {
            return ScenicSpotLevel.valueOf("AAAAA").name();
        }
        return ScenicSpotLevel.valueOf("普通").name();
    }
    public static String transScenicSpotLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        ScenicSpotLevel scenicSpotLevel = Enum.valueOf(ScenicSpotLevel.class, value);
        return scenicSpotLevel.getValue();
    }

}
