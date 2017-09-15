package com.javarush.test.level04.lesson06.task02;

/* Максимум четырех чисел
Ввести с клавиатуры четыре числа, и вывести максимальное из них.
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

        strNum = in.readLine();
        int d = Integer.parseInt(strNum);

        int max = a;

        if (max < b) max = b;
        if (max < c) max = c;
        if (max < d) max = d;

        System.out.println(max);


    }
}
