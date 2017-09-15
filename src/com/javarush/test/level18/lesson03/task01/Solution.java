package com.javarush.test.level18.lesson03.task01;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* Максимальный байт
Ввести с консоли имя файла
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        FileInputStream file = new FileInputStream(filename);
        int maxValue;
        if (file.available() > 0) {
            maxValue = file.read();

            while (file.available() > 0) {
                int i = file.read();
                if (i > maxValue) {
                    maxValue = i;
                }
            }

            System.out.println(maxValue);
        }

        file.close();
    }
}
