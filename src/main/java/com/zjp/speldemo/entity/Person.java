package com.zjp.speldemo.entity;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * ClassName: Person
 * Package: com.zjp.speldemo.entity
 * Description:
 *
 * @author zjp
 * @version 1.0
 * @data: 2024/11/5 8:58
 */
@Component
public class Person {
    @Value("#{'John Doe'}")
    private String name;

    @Value("#{25 + 5}")
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
