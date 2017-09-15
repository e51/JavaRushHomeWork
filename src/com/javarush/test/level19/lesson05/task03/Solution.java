package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

        Scanner file1 = new Scanner(new File(filename1));
        Writer file2 = new FileWriter(filename2);

        String str;
        while (file1.hasNext()) {
            str = file1.next();
            try {
                Integer.valueOf(str);
                file2.write(str + " ");
            } catch (NumberFormatException ignore) {
//                e.printStackTrace();
            }
        }

        file2.flush();
        file2.close();
        file1.close();
        in.close();

    }
}
