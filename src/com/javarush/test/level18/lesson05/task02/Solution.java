package com.javarush.test.level18.lesson05.task02;

/* Подсчет запятых
С консоли считать имя файла
Посчитать в файле количество символов ',', количество вывести на консоль
Закрыть потоки. Не использовать try-with-resources

Подсказка: нужно сравнивать с ascii-кодом символа ','
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        InputStream file = new FileInputStream(filename);

        int count = 0;

        while (file.available() > 0) {
            int i = file.read();

            if (((char) i) == ',') {
                count++;
            }
        }

        in.close();
        file.close();

        System.out.println(count);
    }
}
