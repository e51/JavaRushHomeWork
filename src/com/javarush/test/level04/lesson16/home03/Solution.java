package com.javarush.test.level04.lesson16.home03;

import java.io.*;

/* Посчитать сумму чисел
Вводить с клавиатуры числа и считать их сумму. Если пользователь ввел -1, вывести на экран сумму и завершить программу.  -1 должно учитываться в сумме.
*/

public class Solution
{
    public static void main(String[] args)   throws Exception
    {
        //напишите тут ваш код
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int intSum = 0;

        while (true) {
            String strNum = in.readLine();
            int a = Integer.parseInt(strNum);
            intSum += a;
            if (a == -1) break;

        }
        System.out.println(intSum);


    }
}
