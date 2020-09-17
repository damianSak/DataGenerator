package com.melon.dataGenerator;

import com.melon.dataGenerator.actions.*;
import com.melon.dataGenerator.models.Account;
import com.melon.dataGenerator.models.Customer;
import com.melon.dataGenerator.models.Department;
import com.melon.dataGenerator.utils.ConsoleInputProvider;
import com.melon.dataGenerator.utils.Headings;

import java.util.*;

public class DataGenerator {

    private Customer customer;
    private Account account;
    private RandomFieldsGenerators randomFieldsGenerators;
    private CustomerNameGenerator customerNameGenerator;
    private PrintTransactions printTransactions;
    private AddAccountAndTransactions addAccountAndTransactions;
    private SaveData saveData;
    private Headings heading;

    public DataGenerator() {
        initializeActions();
    }

    private void initializeActions() {
        this.randomFieldsGenerators = new RandomFieldsGenerators();
        this.customerNameGenerator = new CustomerNameGenerator();
        this.printTransactions = new PrintTransactions();
        this.addAccountAndTransactions = new AddAccountAndTransactions();
        this.saveData = new SaveData();
        this.heading = new Headings();
    }

    private List<String> listOFCustomers = new LinkedList<>();
    private List<String> listOFAccounts = new LinkedList<>();
    private Set<String> listOFDepartment = new LinkedHashSet<>();
    private List<String> listOFTransactions = new LinkedList<>();

    private String customerData = "";
    private String accountData = "";
    private String departmentData = "";
    private String transactionData = "";
    private int transactionId = 0;

    public void start() {
        System.out.println("\nGENERATOR DANYCH CSV\n");
        System.out.println("Podaj ilu klientów ma zostać wygenerowanych: ");
        int customersQuantity = ConsoleInputProvider.readIntFromUserHandlingEmptyInput();
        System.out.println("Podaj maksymalną losową ilość kont dla pojedynczego klienta (minimalnie generowane jest 1 konto): ");
        int accountsQuantity = ConsoleInputProvider.readIntFromUserHandlingEmptyInput();
        System.out.println("Podaj maksymalną losową ilość transakcji dla każdego konta (mininalnie generowana jest 1 transakcja): ");
        int transactionQuantity = ConsoleInputProvider.readIntFromUserHandlingEmptyInput();

        for (int i = 0; i < customersQuantity; i++) {

            customer = new Customer(customerNameGenerator.generateCustomerName(), randomFieldsGenerators.generateFavoriteColor(), randomFieldsGenerators.generateAge());
            for (int j = 0; j < randomFieldsGenerators.generateAccountsForCustomer(accountsQuantity); j++) {
                account = new Account(new Department(randomFieldsGenerators.generateDepartmentName()), randomFieldsGenerators.generateAccountName());
                addAccountAndTransactions.addAccounts(customer.getAccounts(),account);
                accountData = account.getAccountId() + "," + customer.getId() + "," + account.getDepartment().getDepartmentId() + "," + account.getName();
                listOFAccounts.add(accountData);

                departmentData = account.getDepartment().getDepartmentId() + "," + account.getDepartment().getName();
                listOFDepartment.add(departmentData);


                for (int k = 0; k < randomFieldsGenerators.generateAmountOfTransactionForAccount(transactionQuantity); k++) {
                    addAccountAndTransactions.addTransactions(account.getTransactions(),randomFieldsGenerators.generateTransactions());
                    transactionData = transactionId + "," + account.getAccountId() + "," + printTransactions.printTransactionsValue(account.getTransactions(),k);
                    listOFTransactions.add(transactionData);
                    transactionId++;
                }

            }

            customerData = customer.getId() + "," + customer.getName() + "," + customer.getFavouriteColor().toLowerCase() + "," + customer.getAge();
            listOFCustomers.add(customerData);
        }
        System.out.println("\nPliki zostaną zapisane domyślnie na dysku D:\\ \n");
        System.out.println("Podaj nazwę pliku dla danych o klientach:");
        saveData.saveDb(listOFCustomers, heading.getCustomerHeading());

        System.out.println("Podaj nazwę pliku dla danych o kontach klientów: ");
        saveData.saveDb(listOFAccounts, heading.getAccountHeading());

        System.out.println("Podaj nazwę pliku dla danych o departamentach banków: ");
        List<String> sortedListOfDepartment = new LinkedList<>(listOFDepartment);
        Collections.sort(sortedListOfDepartment);
        saveData.saveDb(sortedListOfDepartment, heading.getDepartmentHeading());

        System.out.println("Podaj nazwę pliku dla danych dla transakcji na kontach: ");
        saveData.saveDb(listOFTransactions, heading.getTransactionHeading());
        ConsoleInputProvider.closeScanner();


    }
}
