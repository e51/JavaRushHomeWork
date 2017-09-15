package com.javarush.test.level16.lesson13.bonus02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* Клубок
1. Создай 5 различных своих нитей c отличным от Thread типом:
1.1. нить 1 должна бесконечно выполняться;
1.2. нить 2 должна выводить "InterruptedException" при возникновении исключения InterruptedException;
1.3. нить 3 должна каждые полсекунды выводить "Ура";
1.4. нить 4 должна реализовать интерфейс Message, при вызове метода showWarning нить должна останавливаться;
1.5. нить 5 должна читать с консоли цифры пока не введено слово "N", а потом вывести в консоль сумму введенных цифр.
2. В статическом блоке добавь свои нити в List<Thread> threads в перечисленном порядке.
3. Нити не должны стартовать автоматически.
Подсказка: Нить 4 можно проверить методом isAlive()
*/

public class Solution {
    public static List<Thread> threads = new ArrayList<Thread>(5);

    static {
        threads.add(new Thread1());
        threads.add(new Thread2());
        threads.add(new Thread3());
        threads.add(new Thread4());
        threads.add(new Thread5());
    }

//    public static void main(String[] args) throws InterruptedException {
//        threads.get(0).start(); // бесконечный цикл
//        threads.get(1).start(); // Exception
//        threads.get(2).start(); // Ура
////        threads.get(3).start(); // showWarning
//        threads.get(4).start(); // numbers
////        System.out.println(threads.get(0).isAlive());
//        System.out.println(threads.get(3).isAlive());
////        Thread.sleep(1000);
////        System.out.println(threads.get(0).isAlive());
////        threads.get(1).interrupt();
////
//        ((Message)threads.get(3)).showWarning();
//        Thread.sleep(1000);
//        System.out.println(threads.get(3).isAlive());
//    }

    public static class Thread1 extends Thread {
        public void run() {
            while(true) {
                // бесконечный цикл
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            while (true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
//                    return;
                }
            }
        }
    }

    public static class Thread3 extends Thread {
        public void run() {

            while (true) {
                System.out.println("Ура");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        }
    }

    public static class Thread4 extends Thread implements Message {
        public void run() {
            while(true) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        @Override
        public void showWarning() {
//            Thread.currentThread().interrupt();
//            threads.get(3).interrupt();
//            throw new InterruptedException();
//            this.interrupt();
            try{
                this.interrupt();
                this.join();
            } catch (Exception e) {}
        }
    }

    public static class Thread5 extends Thread {
        public void run() {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String value = null;
            int result = 0;
            try {
                while (!"N".equals(value = in.readLine())) {
                    if (value.matches("\\-?\\d*")) {
                        result += Integer.valueOf(value);
                    }
                }
            } catch (IOException e) {
            }

            try {
                in.close();
            } catch (IOException e) {
            }

            System.out.println(result);

        }
    }
}
