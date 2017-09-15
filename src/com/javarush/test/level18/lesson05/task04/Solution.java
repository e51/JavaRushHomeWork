package com.javarush.test.level18.lesson05.task04;

/* Реверс файла
Считать с консоли 2 имени файла: файл1, файл2.
Записать в файл2 все байты из файл1, но в обратном порядке
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

        FileInputStream stream1 = new FileInputStream(filename1);
        FileOutputStream stream2 = new FileOutputStream(filename2);

        if (stream1.available() > 0) {
            byte[] buffer = new byte[stream1.available()];
            int count = stream1.read(buffer);
            byte[] buffer2 = new byte[count];

            for (int i = 0; i < buffer.length; i++) {
                buffer2[i] = buffer[count - 1 - i];
            }

            stream2.write(buffer2, 0, count);
        }

        in.close();
        stream1.close();
        stream2.close();

    }
}
