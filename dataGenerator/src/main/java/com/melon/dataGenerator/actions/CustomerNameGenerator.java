package com.melon.dataGenerator.actions;

import com.melon.dataGenerator.utils.CSVFileProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerNameGenerator {
    private List<String> names;
    private List<String> surnames;

    public CustomerNameGenerator() {
        this.names = new ArrayList<>();
        this.surnames = new ArrayList<>();
        loadSurnames();
        loadNames();
    }

    private void loadNames() {
        File file = CSVFileProvider.getCorrectFile("babynames-clean.CSV");
        String line;
        boolean isHeader = true;
        if (file.exists()) {
            try (Scanner scan = new Scanner(file)) {

                while (scan.hasNextLine()) {
                    if (!isHeader) {
                        line = scan.nextLine();
                        String[] splittedLine = line.split(",");
                        this.names.add(splittedLine[0]);
                    }
                    isHeader = false;
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        } else {
            System.out.println("nie można odczytać pliku");
        }

    }

    private void loadSurnames() {
        File file = CSVFileProvider.getCorrectFile("Names_2010Census.CSV");
        String line;
        if (file.exists()) {
            try (Scanner scan = new Scanner(file)) {

                while (scan.hasNextLine()) {
                    line = scan.nextLine();
                    String[] splittedLine = line.split(",");

                    String surname = splittedLine[0].toLowerCase();
                    String firstLetter = surname.substring(0, 1).toUpperCase();
                    String restOfLetters = surname.substring(1);
                    this.surnames.add(firstLetter + restOfLetters);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("nie można odczytać pliku");
        }
    }

    public String generateCustomerName() {

        Random random = new Random();
        return names.get(random.nextInt(names.size())) + " " + surnames.get(random.nextInt(surnames.size()));
    }
}
