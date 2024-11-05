package com.zjp.speldemo.entity;

/**
 * ClassName: Customer
 * Package: com.zjp.speldemo.entity
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 8:45
 */
public class Customer {
    private String name;
    private int age;
    private Address address;

    private Customer() {
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}