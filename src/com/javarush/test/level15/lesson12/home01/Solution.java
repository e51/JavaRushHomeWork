package com.javarush.test.level15.lesson12.home01;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Разные методы для разных типов
1. Считать с консоли данные, пока не введено слово "exit".
2. Для каждого значения, кроме "exit", вызвать метод print. Если значение:
2.1. содержит точку '.', то вызвать метод print для Double;
2.2. больше нуля, но меньше 128, то вызвать метод print для short;
2.3. больше либо равно 128, то вызвать метод print для Integer;
2.4. иначе, вызвать метод print для String.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));


        //Проверка на числовое выражение
//        System.out.println(".234".matches("\\-?\\d*(\\.\\d{0,})?"));
//        System.out.println("2.2".matches(".*\\..*"));

        while (true) {
            String value = in.readLine();

            if ("exit".equals(value))
                break;

            if (!value.matches("\\-?\\d*(\\.\\d{0,})?")) {
                // Строка
                print(value);

            } else if (value.matches(".*\\..*")) {
                // Double
                print(Double.valueOf(value));

            } else if (Integer.valueOf(value) > 0 && Integer.valueOf(value) < 128) {
                // Short
                print(Short.valueOf(value));

            } else {
                // Integer
                print(Integer.valueOf(value));

            }


        }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
