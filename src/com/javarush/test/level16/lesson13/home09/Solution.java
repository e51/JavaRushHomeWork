package com.javarush.test.level16.lesson13.home09;

/* Только по-очереди!
1. В классе Solution создать нить public static Read3Strings унаследовавшись от Thread.
2. В методе run реализовать чтение с консоли трех строк.
3. Три подряд введенных строки должны считываться в одной нити и объединяться в одну строку через пробел.
4. В методе main вывести результат для каждой нити.
5. Используйте join

Пример:
Входные данные
a
b
c
d
e
f
Выходные данные:
a b c
d e f
*/

import java.io.*;

public class Solution {
    public static volatile BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws InterruptedException {
        Read3Strings t1 = new Read3Strings();
        Read3Strings t2 = new Read3Strings();
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        System.out.println(t1.getResult());
        System.out.println(t2.getResult());
    }

    public static class Read3Strings extends Thread {
        private String result;

        public Read3Strings() {
        }

        public void run() {
            try {
                result = Solution.reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (int i = 0; i < 2; i++) {
                try {
                    result += " " + Solution.reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

        public String getResult() {
            return result;
        }
    }
}
