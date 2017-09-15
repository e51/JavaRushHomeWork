package com.javarush.test.level07.lesson06.task03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* Самая короткая строка
1. Создай список строк.
2. Считай с клавиатуры 5 строк и добавь в список.
3. Используя цикл, найди самую короткую строку в списке.
4. Выведи найденную строку на экран.
5. Если таких строк несколько, выведи каждую с новой строки.
*/
public class Solution
{
    public static void main(String[] args) throws Exception
    {
        //напишите тут ваш код
        ArrayList<String> strList = new ArrayList<String>();
        ArrayList<Integer> intList = new ArrayList<Integer>();

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        int intMaxLength = -1;
        for (int i = 0; i < 5; i++) {
            String strIn = in.readLine();
            if (intMaxLength < 0)
                intMaxLength = strIn.length();
            else if (strIn.length() < intMaxLength)
                intMaxLength = strIn.length();
            strList.add(strIn);
        }

        for (int i = 0; i < strList.size(); i++) {
            String strTmp = strList.get(i);
            if (strTmp.length() == intMaxLength)
                System.out.println(strTmp);
        }


    }
}
