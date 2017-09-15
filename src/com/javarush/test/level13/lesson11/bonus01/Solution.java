package com.javarush.test.level13.lesson11.bonus01;

/* Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
*/

import java.io.*;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution
{
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fname = reader.readLine();
        reader.close();
        SortedSet<Integer> set = new TreeSet<Integer>();
        DataInputStream dis = null;

        try {
            dis = new DataInputStream(new FileInputStream(fname));
        } catch (Exception e) {
            System.out.println("Ошибка при открытии файла");
            System.exit(1);
        }

        while (dis.available() > 0) {
            int a = Integer.valueOf(dis.readLine());
            if (a % 2 == 0)
                set.add(a);
        }

        for (int x : set) {
            System.out.println(x);
        }

        dis.close();
    }
}
