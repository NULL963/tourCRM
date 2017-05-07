package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/6.
 */
public enum AccommodationLevel {

    普通("0"),
    一星("1"),
    二星("2"),
    三星("3"),
    四星("4"),
    五星("5"),
    白金五星("6");


    private String value;
    private AccommodationLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
