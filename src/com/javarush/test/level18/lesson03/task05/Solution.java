package com.javarush.test.level18.lesson03.task05;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;




/* Сортировка байт
Ввести с консоли имя файла
Считать все байты из файла.
Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
Вывести на экран
Закрыть поток ввода-вывода

Пример байт входного файла
44 83 44

Пример вывода
44 83
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        FileInputStream file = new FileInputStream(filename);
        Set<Integer> set = new TreeSet<>();

        while (file.available() > 0) {
            int i = file.read();
            set.add(Integer.valueOf(i));
        }

        for (Integer x : set) {
            System.out.print(x + " ");
        }

        file.close();
    }
}
