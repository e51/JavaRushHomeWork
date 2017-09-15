package com.javarush.test.level07.lesson04.task05;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* Один большой массив и два маленьких
1. Создать массив на 20 чисел.
2. Ввести в него значения с клавиатуры.
3. Создать два массива на 10 чисел каждый.
4. Скопировать большой массив в два маленьких: половину чисел в первый маленький, вторую половину во второй маленький.
5. Вывести второй маленький массив на экран, каждое значение выводить с новой строки.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        int[] array20 = new int[20];
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < array20.length; i++) {
            array20[i] = Integer.parseInt(in.readLine());
        }

        int array1[] = new int[10];
        int array2[] = new int[10];

        for (int i = 0; i < array20.length; i++) {
            if (i < 10)
                array1[i] = array20[i];
            else
                array2[i-10] = array20[i];
        }

        for (int i = 0; i < array2.length; i++) {
            System.out.println(array2[i]);
        }

    }
}
