package com.javarush.test.level19.lesson05.task01;

/* Четные байты
Считать с консоли 2 имени файла.
Вывести во второй файл все байты с четным индексом.
Пример: второй байт, четвертый байт, шестой байт и т.д.
Закрыть потоки ввода-вывода.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file1 = in.readLine();
        String file2 = in.readLine();

        InputStream f1 = new FileInputStream(file1);
        OutputStream f2 = new FileOutputStream(file2);

        int data;
        int counter = 1;
        while ((data = f1.read()) != -1) {
            if (counter % 2 == 0) {
                f2.write(data);
                counter = 0;
            }
            counter++;
        }

        f2.flush();
        f2.close();
        f1.close();
        in.close();
    }
}
