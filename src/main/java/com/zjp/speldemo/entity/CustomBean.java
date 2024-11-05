package com.zjp.speldemo.entity;

/**
 * ClassName: CustomBean
 * Package: com.zjp.speldemo.entity
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 11:09
 */
public class CustomBean {

    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "CustomBean{" +
                "value='" + value + '\'' +
                '}';
    }
}
