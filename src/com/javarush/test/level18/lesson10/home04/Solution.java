package com.javarush.test.level18.lesson10.home04;

/* Объединение файлов
Считать с консоли 2 имени файла
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

        FileInputStream file1 = new FileInputStream(filename1);
        FileInputStream file2 = new FileInputStream(filename2);

        byte[] buffer1 = new byte[file1.available()];
        byte[] buffer2 = new byte[file2.available()];

        file1.read(buffer1);
        file2.read(buffer2);

        file1.close();
        file2.close();

        FileOutputStream file1and2 = new FileOutputStream(filename1, false);

        file1and2.write(buffer2);
        file1and2.write(buffer1);

        file1and2.close();
        in.close();
    }
}
