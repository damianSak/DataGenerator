package com.melon.dataGenerator.actions;

import com.melon.dataGenerator.utils.ConsoleInputProvider;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

public class SaveData {

    public void saveDb(Collection<String> rows, String heading) {
        File file;

        String fileName;

            do {
                fileName = ConsoleInputProvider.readStringFromUserHandlingEmptyInput();
                file = new File("D:\\" + fileName + ".CSV");
                if (file.exists()) {
                    System.out.println("Plik z podaną nazwa juz istniene, podaj inną nazwę: ");
                } else {
                    System.out.println("Na dysku 'D' utworzono nowy plic CSV o nazwię " + "' " + fileName + " '");
                }
            } while (file.exists());
            try {
                FileWriter writer = new FileWriter("D:\\" + fileName + ".CSV");
                writer.write(heading+"\n");
                for (String row : rows) {
                    writer.write(row+"\n");
                }

                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }



    }
}
