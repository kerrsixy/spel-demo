package com.zjp.speldemo.entity;

/**
 * ClassName: Address
 * Package: com.zjp.speldemo.entity
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 8:45
 */
public class Address {
    private String city;

    public Address(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}