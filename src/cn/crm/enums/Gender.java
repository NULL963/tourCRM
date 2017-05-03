package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/2.
 */
public enum Gender {
    男("1"),
    女("0"),
    其他("2");



    //value 与性别相对应的数字值
    private String value;

    private Gender(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }


}
