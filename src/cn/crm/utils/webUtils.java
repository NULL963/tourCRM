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
     * ��Դ���������ת�뵽Ŀ�������
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
                        throw new ConversionException("��֧��String����֮���ת��");
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
     * ��to1
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
     * ת�������ȼ������������ݿⵥ�ַ�
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
     * �����ݿ��д洢�ĵ��ַ�ת��Ϊ����
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
            return Gender.valueOf("��").name();
        }
        if ("0".equals(value.trim())) {
            return Gender.valueOf("Ů").name();
        }
        return Gender.valueOf("����").name();
    }

    public static String  num2FoodLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("0".equals(value.trim())) {
            return FoodLevel.valueOf("��ͨ").name();
        }
        if ("1".equals(value.trim())) {
            return FoodLevel.valueOf("����").name();
        }
        return FoodLevel.valueOf("����").name();
    }

    public static String  num2AccommodationLevel(String value) {
        if (value == null) {
            return null;
        }
        if ("".equals(value.trim())) {
            return null;
        }
        if ("6".equals(value.trim())) {
            return AccommodationLevel.valueOf("�׽�����").name();
        }
        if ("1".equals(value.trim())) {
            return AccommodationLevel.valueOf("һ��").name();
        }
        if ("2".equals(value.trim())) {
            return AccommodationLevel.valueOf("����").name();
        }
        if ("3".equals(value.trim())) {
            return AccommodationLevel.valueOf("����").name();
        }
        if ("4".equals(value.trim())) {
            return AccommodationLevel.valueOf("����").name();
        }
        if ("5".equals(value.trim())) {
            return AccommodationLevel.valueOf("����").name();
        }
        return AccommodationLevel.valueOf("��ͨ").name();
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
        return ScenicSpotLevel.valueOf("��ͨ").name();
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
