package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/6.
 */
public enum AccommodationLevel {

    ��ͨ("0"),
    һ��("1"),
    ����("2"),
    ����("3"),
    ����("4"),
    ����("5"),
    �׽�����("6");


    private String value;
    private AccommodationLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
