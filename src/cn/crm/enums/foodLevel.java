package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/5.
 */
public enum FoodLevel {

    普通("0"),
    精美("1"),
    豪华("2");

    private String value;
    private FoodLevel(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
