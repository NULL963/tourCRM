package cn.crm.enums;

/**
 * Created by LEMON on 2017/5/12.
 */
public enum Condition {

    ����("0"),
    �����("1"),
    ������("2"),
    ����ִ��("3"),
    �ѽ���("4");

    private String value;
    private Condition(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
