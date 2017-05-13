package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/12.
 */
public enum Condition {

    新增("0"),
    已审核("1"),
    已作废("2"),
    正在执行("3"),
    已结束("4");

    private String value;
    private Condition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
