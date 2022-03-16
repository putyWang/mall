package com.bjpowernode.sms.beans;

import java.io.Serializable;

public class Student implements Serializable {
    private Integer id;
    private String passWord;
    private String num;
    private String name;
    private int age;
    private int score;

    public Student() {
    }

    public Student(Integer id, String passWord, String num, String name, int age, int score) {
        this.id = id;
        this.passWord = passWord;
        this.num = num;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
