package com.javarush.test.level19.lesson08.task01;

/* Ридер обертка
В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
Ваша ридер-обертка должна преобразовывать весь текст в заглавные буквы
Вызовите готовый метод printSomething(), воспользуйтесь testString
Верните переменной System.out первоначальный поток.
Вывести модифицированную строку в консоль.
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream original = System.out;

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        PrintStream fakeOut = new PrintStream(outputStream);

        System.setOut(fakeOut);

        testString.printSomething();

        System.setOut(original);

        String str = outputStream.toString().toUpperCase();

        System.out.println(str);

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
