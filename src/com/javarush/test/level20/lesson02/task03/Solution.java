package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

//    public static void main(String[] args) throws Exception {
//        Solution sol = new Solution();
//        sol.fillInPropertiesMap();
//        sol.save(new FileOutputStream("C:\\TEMP\\1\\prop2.properties"));
//    }

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();
//        String filename = "C:\\TEMP\\1\\prop.properties";
        in.close();

        load(new FileInputStream(filename));
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();

        prop.putAll(properties);

        prop.store(outputStream, null);

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        Properties prop = new Properties();

        prop.load(inputStream);

//        prop.list(System.out);

        properties.clear();

        properties.putAll((Map) prop);
    }
}
