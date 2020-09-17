package com.melon.dataGenerator.models;

import java.util.LinkedList;
import java.util.List;

public class Customer {
    private static int id = 0;
    private String name;
    private String favouriteColor;
    private int age;
    private List<Account> accounts;

    public Customer(String name, String favouriteColor, int age) {
        this.id++;
        this.name = name;
        this.favouriteColor = favouriteColor;
        this.age = age;
        this.accounts = new LinkedList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFavouriteColor() {
        return favouriteColor;
    }

    public int getAge() {
        return age;
    }

    public List<Account> getAccounts() {
        return accounts;
    }


}
