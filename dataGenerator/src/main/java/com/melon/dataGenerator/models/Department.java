package com.melon.dataGenerator.models;

public class Department {
    private String name;
    private int departmentId;

    public Department(String name) {
        this.name = name;
        int number = 0;
        switch (this.name) {
            case "North America":
                number = 1;
                break;
            case "South America":
                number = 2;
                break;
            case "Asia":
                number = 3;
                break;
            case "Europe":
                number = 4;
                break;
            case "Africa":
                number = 5;
                break;
            case "Australia":
                number = 6;
                break;
        }
        this.departmentId = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDepartmentId() {
        return departmentId;
    }


}

