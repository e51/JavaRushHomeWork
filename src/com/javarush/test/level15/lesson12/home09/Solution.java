package com.javarush.test.level15.lesson12.home09;

/* Парсер реквестов
Считать с консоли URl ссылку.
Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
URL содержит минимум 1 параметр.
Если присутствует параметр obj, то передать его значение в нужный метод alert.
alert(double value) - для чисел (дробные числа разделяются точкой)
alert(String value) - для строк

Пример 1
Ввод:
http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
Вывод:
lvl view name

Пример 2
Ввод:
http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
Вывод:
obj name
double 3.14
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String value = in.readLine();

        value = value.substring(value.indexOf('?') + 1);
//        System.out.println(value);
        String[] arr = value.split("&");
//        System.out.println(Arrays.toString(arr));

        for (String s : arr) {
            String[] arr2 = s.split("=");
            System.out.print(arr2[0] + " ");
        }
        System.out.println();

        for (String s : arr) {
            String[] arr2 = s.split("=");
            if (arr2[0].equals("obj")) {
                if (!arr2[1].matches("\\-?\\d*(\\.\\d{0,})?")) {
                    // Строка
                    alert(arr2[1]);
                } else {
                    alert(Double.valueOf(arr2[1]));
                }
            }
        }
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
