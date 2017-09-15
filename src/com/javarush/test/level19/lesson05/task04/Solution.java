package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

//        Reader file1 = new FileReader(filename1);
//        Writer file2 = new FileWriter(filename2);
        Reader file1 = new BufferedReader(new FileReader(filename1));
        Writer file2 = new BufferedWriter(new FileWriter(filename2));

//        long time0 = System.currentTimeMillis();
        int data;
        while (file1.ready()) {
            data = file1.read();
            if (((char) data) == '.' ) {
                file2.write("!");
            } else {
                file2.write(data);
            }
        }

        file2.flush();
        file2.close();
        file1.close();
        in.close();

//        long time1 = System.currentTimeMillis();
//        System.out.println(time1 - time0);

    }
}
