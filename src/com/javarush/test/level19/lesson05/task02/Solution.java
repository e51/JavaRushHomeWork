package com.javarush.test.level19.lesson05.task02;

/* Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();
//        String filename = "C:\\TEMP\\1\\world.txt";

        Scanner sc = new Scanner(new File(filename));

        String str;
        int count = 0;
        while (sc.hasNext()) {
            str = sc.next();

            if (str.matches("world[\\W]?")) {
                count++;
//                System.out.println(str);
            }
        }

        System.out.println(count);
        sc.close();
        in.close();

    }
}
