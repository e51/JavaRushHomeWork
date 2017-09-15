package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader file1 = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file1 = new BufferedReader(new FileReader("C:/TEMP/1/f1.txt"));

        PrintWriter file2 = new PrintWriter(args[1]);
//        PrintWriter file2 = new PrintWriter("C:/TEMP/1/f2.txt");

        while (file1.ready()) {
            String str = file1.readLine();
            String[] arr = str.split(" ");

            for (String word : arr) {
                boolean isDigit = false;
                char[] chars = word.toCharArray();

                for (char c : chars) {
                    if (Character.isDigit(c)) {
                        isDigit = true;
                        break;
                    }
                }

                if (isDigit) {
                    file2.print(word + " ");
                }
            }

        }

        file2.close();
        file1.close();


    }
}
