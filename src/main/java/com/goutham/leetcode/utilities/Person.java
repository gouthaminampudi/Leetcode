package com.goutham.leetcode.utilities;

public class Person {
    String name;
    int age;
    String gender;

    public Person(String name, int age, String gender){
        super();
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Person(){
        super();
    }


    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String getGender(){
        return this.gender;
    }

    public String toString(){

        return "Name: " + getName() +
               ", Age: "  + getAge() +
               ", Gender: " + getGender();
    }
}
