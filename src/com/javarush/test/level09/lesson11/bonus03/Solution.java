package com.javarush.test.level09.lesson11.bonus03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Задача по алгоритмам
Задача: Пользователь вводит с клавиатуры список слов (и чисел). Слова вывести в возрастающем порядке, числа - в убывающем.
Пример ввода:
Вишня
1
Боб
3
Яблоко
2
0
Арбуз
Пример вывода:
Арбуз
3
Боб
2
Вишня
1
0
Яблоко
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true)
        {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array)
        {
            System.out.println(x);
        }
    }

    public static void sort(String[] array)
    {
        //напишите тут ваш код
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        ArrayList<Integer> strings = new ArrayList<Integer>();

        //запомнить, в каких ячейках массива - числа, в каких - строки.
        for (int i = 0; i < array.length; i++) {
            if (isNumber(array[i]))
                numbers.add(i);
            else
                strings.add(i);
        }

        //sort numbers
        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = 0; j < numbers.size() - 1 - i; j++) {
                if (Integer.valueOf(array[numbers.get(j)]) < Integer.valueOf(array[numbers.get(j+1)])) {
                    String buf = array[numbers.get(j+1)];
                    array[numbers.get(j+1)] = array[numbers.get(j)];
                    array[numbers.get(j)] = buf;
                }
            }
        }

        //sort strings
        for (int i = 0; i < strings.size() - 1; i++) {
            for (int j = 0; j < strings.size() - 1 - i; j++) {
                if (isGreaterThan(array[strings.get(j)], array[strings.get(j+1)])) {
                    String buf = array[strings.get(j+1)];
                    array[strings.get(j+1)] = array[strings.get(j)];
                    array[strings.get(j)] = buf;
                }
            }
        }
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b)
    {
        return a.compareTo(b) > 0;
    }


    //строка - это на самом деле число?
    public static boolean isNumber(String s)
    {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            char c = chars[i];
            if ((i != 0 && c == '-') //есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
