package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/2.
 */
public enum Gender {
    ��("1"),
    Ů("0"),
    ����("2");



    //value ���Ա����Ӧ������ֵ
    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


}
