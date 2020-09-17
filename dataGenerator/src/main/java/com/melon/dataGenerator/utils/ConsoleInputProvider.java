package com.melon.dataGenerator.utils;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.Scanner;

public class ConsoleInputProvider {

    private static Scanner scanner = new Scanner(System.in);

    public static int readIntFromUserHandlingEmptyInput() {
        String number;
        do {
            number = scanner.nextLine();

            if (number.isEmpty()) {
                System.out.println("Nie wprowadzono żadnej liczby");
            } else if (!NumberUtils.isParsable(number)) {
                System.out.println("Wprowadzona wartość nie jest liczbą całkowitą, podaj własciwą liczbę");
            }
        } while (number.isEmpty() || !NumberUtils.isParsable(number));
        return Integer.parseInt(number);
    }

    public static String readStringFromUserHandlingEmptyInput() {
        String string;
        do {
            string = scanner.nextLine().trim();
            if (string.isEmpty()) {
                System.out.println("Nie wprowadzono żadnego słowa");
            }

        } while (string.isEmpty());
        return string;
    }

    public static void closeScanner() {
        scanner.close();
    }
}
