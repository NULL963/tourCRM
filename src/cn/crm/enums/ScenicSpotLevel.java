package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/7.
 */
public enum ScenicSpotLevel {
    A("0"),
    AA("1"),
    AAA("2"),
    AAAA("3"),
    AAAAA("4"),
    ∆’Õ®("5");


    private String value;
    private ScenicSpotLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
