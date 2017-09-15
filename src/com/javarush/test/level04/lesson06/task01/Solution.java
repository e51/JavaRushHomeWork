package com.javarush.test.level04.lesson06.task01;

/* Минимум двух чисел
Ввести с клавиатуры два числа, и вывести на экран минимальное из них.
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

        if (a < b) System.out.println(a);
        else System.out.println(b);

    }
}