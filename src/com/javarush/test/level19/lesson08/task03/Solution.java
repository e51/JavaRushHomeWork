package com.javarush.test.level19.lesson08.task03;

/* Выводим только цифры
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна выводить только цифры
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток
Вывести модифицированную строку в консоль.

Пример вывода:
12345678
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream original = System.out;

        ByteArrayOutputStream stream = new ByteArrayOutputStream();

        PrintStream fakeOut = new PrintStream(stream);

        System.setOut(fakeOut);

        testString.printSomething();

        System.setOut(original);

        Reader reader = new InputStreamReader(new ByteArrayInputStream(stream.toByteArray()));

        int data;
        while (reader.ready()) {
            data = reader.read();
            if (Character.isDigit((char) data)) {
                System.out.print((char) data);
            }
        }
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
