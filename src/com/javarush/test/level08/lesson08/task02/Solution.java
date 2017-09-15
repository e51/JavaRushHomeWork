package com.javarush.test.level08.lesson08.task02;

import java.util.HashSet;
import java.util.Set;

/* Удалить все числа больше 10
Создать множество чисел(Set<Integer>), занести туда 20 различных чисел.
Удалить из множества все числа больше 10.
*/

public class Solution
{
    public static HashSet<Integer> createSet()
    {
        //напишите тут ваш код
        HashSet<Integer> list = new HashSet<Integer>();

        for (int i = 0; i < 20; i++) {
            list.add(i);
        }

        return list;

    }

    public static HashSet<Integer> removeAllNumbersMoreThan10(HashSet<Integer> set)
    {
        HashSet<Integer> tmp = new HashSet<Integer>();

        //напишите тут ваш код
        for (Integer x : set) {
            if (x <= 10)
                tmp.add(x);
        }

        return tmp;

    }
}
