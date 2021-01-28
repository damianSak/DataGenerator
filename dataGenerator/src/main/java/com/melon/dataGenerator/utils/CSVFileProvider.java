package com.melon.dataGenerator.utils;

import java.io.File;
import java.net.URL;

public class CSVFileProvider {

    public static File getCorrectFile(String fileName){
        URL url = Thread.currentThread().getContextClassLoader().getResource(fileName);
        return new File(url.getPath());
    }
}
