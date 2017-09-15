package com.javarush.test.level18.lesson05.task03;

/* Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();
        String filename3 = in.readLine();

        FileInputStream stream1 = new FileInputStream(filename1);
        FileOutputStream stream2 = new FileOutputStream(filename2);
        FileOutputStream stream3 = new FileOutputStream(filename3);

        if (stream1.available() > 0) {
            int first = 0;
            int second = 0;
            int delta = 0;
            if (stream1.available() % 2 != 0) {
                delta = 1;
            }

            first = (stream1.available() + delta) / 2;
            second = stream1.available() - first;

            byte[] buffer1 = new byte[first];
            int count = stream1.read(buffer1);
            stream2.write(buffer1, 0, count);

            byte[] buffer2 = new byte[second];
            count = stream1.read(buffer2);
            stream3.write(buffer2, 0, count);

        }

        in.close();
        stream1.close();
        stream2.close();
        stream3.close();

    }
}
