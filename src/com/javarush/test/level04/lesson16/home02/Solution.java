package com.javarush.test.level04.lesson16.home02;

import java.io.*;

/* Среднее такое среднее
Ввести с клавиатуры три числа, вывести на экран среднее из них. Т.е. не самое большое и не самое маленькое.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
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

        System.out.println(a + b + c - max - min);
    }
}
