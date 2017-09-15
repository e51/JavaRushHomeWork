package com.javarush.test.level19.lesson05.task05;

/* Пунктуация
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Удалить все знаки пунктуации, включая символы новой строки. Результат вывести во второй файл.
http://ru.wikipedia.org/wiki/%D0%9F%D1%83%D0%BD%D0%BA%D1%82%D1%83%D0%B0%D1%86%D0%B8%D1%8F
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

        Reader file1 = new BufferedReader(new FileReader(filename1));
        Writer file2 = new BufferedWriter(new FileWriter(filename2));

        int data;
        String str;
        while (file1.ready()) {
            data = file1.read();

            str = Character.toString((char) data);

            if (str.matches("\\p{Punct}")) {
                /*NOP*/
            } else {
                file2.write(data);
            }
        }

        file2.flush();
        file2.close();
        file1.close();
        in.close();

    }
}
