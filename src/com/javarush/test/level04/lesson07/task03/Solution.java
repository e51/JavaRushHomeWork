package com.javarush.test.level04.lesson07.task03;

/* Положительные числа
Ввести с клавиатуры три целых числа. Вывести на экран количество положительных чисел в исходном наборе.
Пример для чисел -4 6 6:
2
Пример для чисел -6 -6 -3:
0
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

        int count = 0;

        if (a > 0) count++;
        if (b > 0) count++;
        if (c > 0) count++;

        System.out.println(count);
    }
}
