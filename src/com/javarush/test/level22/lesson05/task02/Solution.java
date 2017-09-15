package com.javarush.test.level22.lesson05.task02;

import java.util.Arrays;

/* Между табуляциями
Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
На некорректные данные бросить исключение TooShortStringException.
Класс TooShortStringException не менять.
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;
        int position = -1;

        if (string == null) {
            throw new TooShortStringException();
        }

//        System.out.println(string.length());

        while (true) {
            if ((position = string.indexOf('\t', position + 1)) != -1) {
//                System.out.println(string.indexOf('\t'));

                count++;
                if (count == 1) {
                    startIndex = position + 1;
                }
                if (count == 2) {
                    endIndex = position;
                    break;
                }
            } else {
//                System.out.println(string.indexOf('\t'));
//                System.out.println(position);
                throw new TooShortStringException();
            }
        }

        return string.substring(startIndex, endIndex);

    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("tab0\ttab\ttab1\t"));       //tab
        System.out.println(getPartOfString("\t\t"));                    //
        System.out.println(getPartOfString("123\t123"));                //Exception
        System.out.println(getPartOfString(null));                      //Exception
    }
}
