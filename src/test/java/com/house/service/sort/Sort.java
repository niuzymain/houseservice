package com.house.service.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Sort {
    public static void main(String[] args) {
        Person person1 = new Person();
        Person person2 = new Person();
        Person person3 = new Person();
        Person person4 = new Person();
        person1.setAge(30);
        person2.setAge(20);
        person3.setAge(40);
        person4.setAge(10);
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        personList.add(person4);
        System.out.println("before sort"+personList);
        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge() < o2.getAge()){
                    return 1;
                }
                if(o1.getAge() == o2.getAge()){
                    return 0;
                }
                return -1;
            }
        });
        System.out.println("after sort"+personList);
    }
}
