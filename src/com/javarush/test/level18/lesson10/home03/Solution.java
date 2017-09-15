package com.javarush.test.level18.lesson10.home03;

/* Два в одном
Считать с консоли 3 имени файла
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();
        String filename3 = in.readLine();

        FileOutputStream file1 = new FileOutputStream(filename1, false);
        FileInputStream file2 = new FileInputStream(filename2);
        FileInputStream file3 = new FileInputStream(filename3);

        if (file2.available() > 0) {
            byte[] buffer = new byte[file2.available()];
            int count = file2.read(buffer);
            file1.write(buffer, 0, count);
        }

        file2.close();
        file1.close();

        file1 = new FileOutputStream(filename1, true);

        if (file3.available() > 0) {
            byte[] buffer = new byte[file3.available()];
            int count = file3.read(buffer);
            file1.write(buffer, 0, count);
        }

        in.close();
        file1.close();
        file3.close();

    }
}
