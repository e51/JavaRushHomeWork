package com.javarush.test.level18.lesson03.task02;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Минимальный байт
Ввести с консоли имя файла
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        FileInputStream file = new FileInputStream(filename);
        int minValue;
        if (file.available() > 0) {
            minValue = file.read();

            while (file.available() > 0) {
                int i = file.read();
                if (i < minValue) {
                    minValue = i;
                }
            }

            System.out.println(minValue);
        }

        file.close();
    }
}
