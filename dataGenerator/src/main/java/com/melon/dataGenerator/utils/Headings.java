package com.melon.dataGenerator.utils;

public class Headings {
    private  String customerHeading = "Id,name,favourite_color,age";
    private  String accountHeading = "Id,customerId,departmentId,account_name";
    private  String departmentHeading = "Id,department_name";
    private  String transactionHeading = "Id,accountId,transactions_value(+/-)";

    public String getCustomerHeading() {
        return customerHeading;
    }

    public String getAccountHeading() {
        return accountHeading;
    }

    public String getDepartmentHeading() {
        return departmentHeading;
    }

    public String getTransactionHeading() {
        return transactionHeading;
    }
}
