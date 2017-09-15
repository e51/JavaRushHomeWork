package com.javarush.test.level06.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Задача по алгоритмам
Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
Пример ввода:
3
2
15
6
17
Пример вывода:
2
3
6
15
17
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));

        int arr[] = new int[5];

        //напишите тут ваш код
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }

        // Сортировка методом "пузырька"
        for (int i = 0; i < 5 - 1; i++) {
            for (int j = 0; j < 5 - 1 - i; j++) {
                if (arr[j] > arr[j+1]) {
                    int buf = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = buf;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(arr[i]);
        }
    }
}
