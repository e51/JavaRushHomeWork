package com.javarush.test.level18.lesson10.home02;

/* Пробелы
В метод main первым параметром приходит имя файла.
Вывести на экран соотношение количества пробелов к количеству всех символов. Например, 10.45
1. Посчитать количество всех символов.
2. Посчитать количество пробелов.
3. Вывести на экран п2/п1*100, округлив до 2 знаков после запятой
4. Закрыть потоки. Не использовать try-with-resources
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);
        int countTotal = 0;
        int countSpaces = 0;

        while (file.available() > 0) {
            char c = (char) file.read();
            if (c == ' ') {
                countSpaces++;
            }
            countTotal++;
        }
        System.out.println(String.format("%(.2f", countSpaces * 1.0 / countTotal * 100));
        file.close();
    }
}
