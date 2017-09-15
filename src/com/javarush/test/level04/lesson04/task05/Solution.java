package com.javarush.test.level04.lesson04.task05;

/* Положительное и отрицательное число
Ввести с клавиатуры число. Если число положительное, то увеличить его в два раза. Если число отрицательное, то прибавить единицу.
Вывести результат на экран.
*/

import java.io.*;

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String strNum = reader.readLine();
        int intNum = Integer.parseInt(strNum);

        if (intNum > 0) {
            intNum *= 2;
            System.out.println(intNum);
        }
        else {
            intNum += 1;
            System.out.println(intNum);
        }

    }

}