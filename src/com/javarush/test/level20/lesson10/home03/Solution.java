package com.javarush.test.level20.lesson10.home03;

import java.io.*;

/* Найти ошибки
Почему-то при сериализации/десериализации объекта класса B возникают ошибки.
Найдите проблему и исправьте ее.
Класс A не должен реализовывать интерфейсы Serializable и Externalizable.
Сигнатура класса В не содержит ошибку :)
Метод main не участвует в тестировании.
*/
public class Solution implements Serializable {
    public static class A {
        protected String name = "A";

        public A() {

        }

        public A(String name) {
            this.name += name;
        }
    }

    public class B extends A implements Serializable {

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Solution solution = new Solution();
        B b = solution.new B("txt");

        //save cat to file
        FileOutputStream fileOutput = new FileOutputStream("C:/TEMP/1/b.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(b);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream("C:/TEMP/1/b.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = (B) objectStream.readObject();
        fiStream.close();
        objectStream.close();

    }

}
