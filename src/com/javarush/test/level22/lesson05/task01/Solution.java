package com.javarush.test.level22.lesson05.task01;

import java.util.TooManyListenersException;

/* Найти подстроку
Метод getPartOfString должен возвращать подстроку начиная с символа после 1-го пробела и до конца слова,
которое следует после 4-го пробела.
Пример: "JavaRush - лучший сервис обучения Java."
Результат: "- лучший сервис обучения"
На некорректные данные бросить исключение TooShortStringException (сделать исключением).
Сигнатуру метода getPartOfString не менять.
Метод main не участвует в тестировании.
*/
public class Solution {
    public static String getPartOfString(String string) {
        int count = 0;
        int startIndex = 0;
        int endIndex = 0;
        int position = -1;

        // !!!!! А можно было решить через .split() !!!!!!

        if (string == null) {
            throw new TooShortStringException();
        }

        while (true) {
            if ((position = string.indexOf(" ", position + 1)) > 0) {
                count++;
                if (count == 1) {
                    startIndex = position + 1;
                }
                if (count == 5) {
                    endIndex = position;
                    break;
                }
            } else {
                if (count == 4) {
                    endIndex = string.length();
                    break;
                } else {
                    throw new TooShortStringException();
                }
            }
        }

        return string.substring(startIndex, endIndex);
    }

    public static class TooShortStringException extends RuntimeException {
    }

    public static void main(String[] args) {
        String str = "JavaRush - лучший сервис обучения Java.";
//        String str = "JavaRush - лучший";
//        String str = "JavaRush - лучший сервис обучения";

        System.out.println(getPartOfString(str));
    }

}
