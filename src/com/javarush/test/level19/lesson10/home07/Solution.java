package com.javarush.test.level19.lesson10.home07;

/* Длинные слова
В метод main первым параметром приходит имя файла1, вторым - файла2
Файл1 содержит слова, разделенные пробелом.
Записать через запятую в Файл2 слова, длина которых строго больше 6
Закрыть потоки. Не использовать try-with-resources

Пример выходных данных:
длинное,короткое,аббревиатура
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file1 = new BufferedReader(new FileReader("C:/TEMP/1/f1.txt"));

        PrintWriter file2 = new PrintWriter(args[1]);
//        PrintWriter file2 = new PrintWriter("C:/TEMP/1/f2.txt");

        boolean comma = false;
        while (file1.ready()) {
            String str = file1.readLine();
            String[] arr = str.split(" ");

            for (String word : arr) {

                if (word.length() > 6) {
                    if (comma) {
                        file2.print(",");
                    }
                    file2.print(word);
                    comma = true;
                }
            }

        }

        file2.close();
        file1.close();


    }
}
