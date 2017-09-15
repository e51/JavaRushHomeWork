package com.javarush.test.level21.lesson08.task03;

/* Запретить клонирование
Разрешите клонировать класс А
Запретите клонировать класс B
Разрешите клонировать класс C
Метод main не участвует в тестировании.
*/
public class Solution {
    public static class A implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        private String name;

        @Override
        public Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
//            return super.clone();

        }

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

    public static class C extends B {
        private C dublicate() {
            return new C(getI(), getJ(), getName());
        }

        @Override
        public Object clone() throws CloneNotSupportedException {
            return dublicate();
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }


//    public static void main(String[] args) throws CloneNotSupportedException {
//        A a = new A(1, 2);
//        B b = new B(11, 22, "name");
//        C c = new C(111, 222, "name");
//
//        A a2 = (A) a.clone();
//        System.out.println(a.getI());
//        System.out.println(a2.getI());
//
////        B b2 = (B) b.clone();
//
//        C c2 = (C) c.clone();
//
//        System.out.println(c2.getI());
//        System.out.println(c2.getName());
//    }
}
