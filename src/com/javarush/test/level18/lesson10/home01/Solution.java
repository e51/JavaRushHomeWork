package com.javarush.test.level18.lesson10.home01;

/* Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв)
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        final String letters = "abcdefghijklmnopqrstuvwxyz";

//        FileReader file = new FileReader(args[0]);
        FileInputStream file = new FileInputStream(args[0]);
        int count = 0;

        while (file.available() > 0) {
            int i = file.read();
            Character c = (char) i;
            String str = String.valueOf(c).toLowerCase();
            if (letters.indexOf(str) != -1) {
                count++;
            };
        }
        System.out.println(count);
        file.close();
    }
}
