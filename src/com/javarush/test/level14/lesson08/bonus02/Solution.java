package com.javarush.test.level14.lesson08.bonus02;

/* НОД
Наибольший общий делитель (НОД).
Ввести с клавиатуры 2 целых положительных числа.
Вывести в консоль наибольший общий делитель.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        int nod = 1;

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(in.readLine());
        int b = Integer.parseInt(in.readLine());

        while (true) {
            nod = a;
            if (nod > b) nod = b;

            if (a % nod == 0 && b % nod == 0)
                break;
            else
                if (a > b)
                    a = a - b;
                else
                    b = b - a;
        }
        System.out.println(nod);
    }
}
