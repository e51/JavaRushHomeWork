package com.javarush.test.level04.lesson06.task03;

/* Сортировка трех чисел
Ввести с клавиатуры три числа, и вывести их в порядке убывания.
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

        int max = 0, min = 0;

        if (a >= b && a >= c) max = a;
        if (b >= a && b >= c) max = b;
        if (c >= a && c >= b) max = c;

        if (a <= b && a <= c) min = a;
        if (b <= a && b <= c) min = b;
        if (c <= a && c <= b) min = c;

        System.out.println(max);
        System.out.println(a + b + c - max - min);
        System.out.println(min);


    }
}
