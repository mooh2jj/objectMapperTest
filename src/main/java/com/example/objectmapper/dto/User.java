package com.example.objectmapper.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class User {

    private String name;
    private int age;
    private List<Car> cars;


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, int age, List<Car> cars) {
        this.name = name;
        this.age = age;
        this.cars = cars;
    }

}
