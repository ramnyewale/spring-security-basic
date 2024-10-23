package com.spring.security.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
//@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private int age;

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
