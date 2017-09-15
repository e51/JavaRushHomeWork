package com.javarush.test.level13.lesson11.home04;

/* Запись в файл
1. Прочесть с консоли имя файла.
2. Считывать строки с консоли, пока пользователь не введет строку "exit".
3. Вывести абсолютно все введенные строки в файл, каждую строчку с новой стороки.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        OutputStream f = null;

        try {
            f = new FileOutputStream(fname);
        } catch (Exception e) {
            System.out.println("Ошибка при открытии файла");
            System.exit(1);
        }

        String str = null;
        do {
            str = reader.readLine();
            for (char c : str.toCharArray()) {
                f.write(c);
            }
            f.write('\n');
        } while (!"exit".equals(str));

        f.close();
        reader.close();
    }
}
