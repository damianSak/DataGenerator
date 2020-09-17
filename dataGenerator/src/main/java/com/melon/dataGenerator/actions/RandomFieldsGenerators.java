package com.melon.dataGenerator.actions;

import com.melon.dataGenerator.models.Transaction;

import java.util.Random;

public class RandomFieldsGenerators {
    private Random random = new Random();


    public int generateAge() {
        return random.nextInt(83) + 18;

    }

    public String generateDepartmentName() {
        String departmentName = "";
        switch (random.nextInt(6)) {
            case 0:
                departmentName = "North America";
                break;
            case 1:
                departmentName = "South America";
                break;
            case 2:
                departmentName = "Asia";
                break;
            case 3:
                departmentName = "Europe";
                break;
            case 4:
                departmentName = "Africa";
                break;
            case 5:
                departmentName = "Australia";
                break;
        }
        return departmentName;
    }


    public String generateFavoriteColor() {
        String color = "";
        switch (random.nextInt(16)) {
            case 0:
                color = "WHITE";
                break;
            case 1:
                color = "BLUE";
                break;
            case 2:
                color = "RED";
                break;
            case 3:
                color = "GREEN";
                break;
            case 4:
                color = "PURPLE";
                break;
            case 5:
                color = "BLACK";
                break;
            case 6:
                color = "ORANGE";
                break;
            case 7:
                color = "YELLOW";
                break;
            case 8:
                color = "GREY";
                break;
            case 9:
                color = "BROWN";
                break;
            case 10:
                color = "MAGENTA";
                break;
            case 11:
                color = "PINK";
                break;
            case 12:
                color = "LIME";
                break;
            case 13:
                color = "AQUAMARINE";
                break;
            case 14:
                color = "SILVER";
                break;
            case 15:
                color = "TURQUOISE";
                break;
        }
        return color;
    }

    public String generateAccountName() {
        String name = "";
        switch (random.nextInt(6)) {
            case 0:
                name = "Free account";
                break;
            case 1:
                name = "Normal account";
                break;
            case 2:
                name = "Brass account";
                break;
            case 3:
                name = "Silver account";
                break;
            case 4:
                name = "Gold account";
                break;
            case 5:
                name = "Platinum account";
                break;

        }
        return name;
    }

    public Transaction generateTransactions() {

        String type = "";
        switch (random.nextInt(2)) {
            case 0:
                type = "Deposit";
                break;
            case 1:
                type = "Withdraw";
                break;
        }
        int value = random.nextInt(20000) + 100;
        if (type.equals("Withdraw")) {
            value *= -1;
        }


        return new Transaction(type, value);
    }


    public int generateAccountsForCustomer(int upperLimit) {
        return random.nextInt(upperLimit) + 1;
    }

    public int generateAmountOfTransactionForAccount(int upperLimit) {
        return random.nextInt(upperLimit) + 1;
    }
}
