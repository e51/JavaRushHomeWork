package com.javarush.test.level04.lesson04.task10;

/* Три числа
Ввести с клавиатуры три целых числа. Определить, имеется ли среди них хотя бы одна пара равных между собой чисел.
Если такая пара существует, вывести на экран числа через пробел. Если все три числа равны между собой, то вывести все три.
Пример для чисел 1 2 2:
2 2
Пример для чисел 2 2 2:
2 2 2
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String strNum = reader.readLine();        int a = Integer.parseInt(strNum);
        strNum = reader.readLine();        int b = Integer.parseInt(strNum);
        strNum = reader.readLine();        int c = Integer.parseInt(strNum);

        if (a == b) {
            System.out.print(a + " " + a);
            if (a == c) System.out.println(" " + a);
        } else {
            if (a == c)
                System.out.print(a + " " + a);
            else {
                if (b == c) System.out.println(b + " " + c);
            }
        }

    }
}