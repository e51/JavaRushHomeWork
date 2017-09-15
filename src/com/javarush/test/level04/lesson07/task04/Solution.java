package com.javarush.test.level04.lesson07.task04;

/* Положительные и отрицательные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных и количество отрицательных чисел в исходном наборе,
в следующем виде:
"количество отрицательных чисел: а", "количество положительных чисел: б", где а, б - искомые значения.
Пример для чисел 2 5 6:
количество отрицательных чисел: 0
количество положительных чисел: 3
Пример для чисел -2 -5 6:
количество отрицательных чисел: 2
количество положительных чисел: 1
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String strNum = in.readLine();
        int a = Integer.parseInt(strNum);

        strNum = in.readLine();
        int b = Integer.parseInt(strNum);

        strNum = in.readLine();
        int c = Integer.parseInt(strNum);

        int countPositive = 0, countNegative = 0;

        if (a > 0) countPositive++;
        else countNegative++;
        if (b > 0) countPositive++;
        else countNegative++;
        if (c > 0) countPositive++;
        else countNegative++;

        System.out.println("количество отрицательных чисел: " + countNegative);
        System.out.println("количество положительных чисел: " + countPositive);

    }
}
