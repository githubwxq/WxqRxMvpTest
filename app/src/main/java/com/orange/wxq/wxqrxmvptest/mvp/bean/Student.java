package com.orange.wxq.wxqrxmvptest.mvp.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/3.
 */
public class Student {

    private int age;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    private String name1;

    public Student(int age, String name) {
        this.age = age;
        this.name1 = name;
    }

    public ArrayList<Course> getCourse() {
        return course;
    }

    public void setCourse(ArrayList<Course> course) {
        this.course = course;
    }

    private ArrayList<Course> course=new ArrayList<Course>();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }






}
