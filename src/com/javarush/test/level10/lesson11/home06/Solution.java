package com.javarush.test.level10.lesson11.home06;

/* Конструкторы класса Human
Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него. Каждый конструктор должен иметь смысл.
*/

public class Solution
{
    public static void main(String[] args)
    {

    }

    public static class Human
    {
        //напишите тут ваши переменные и конструкторы
        private String name = "Joe Doe";
        private int age = 21;
        private boolean sex = true;
        private Human father = null;
        private Human mother = null;
        private boolean haveChildren = false;

        public Human() {

        }

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Human(String name, int age, boolean sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

        public Human(String name, int age, boolean sex, Human father) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
        }

        public Human(String name, int age, boolean sex, Human father, Human mother, boolean haveChildren) {
            this.name = name;
            this.age = age;
            this.sex = sex;
            this.father = father;
            this.mother = mother;
            this.haveChildren = haveChildren;
        }

        public Human(String name, Human father, Human mother) {
            this.name = name;
            this.father = father;
            this.mother = mother;
        }

        public Human(Human father, Human mother) {
            this.father = father;
            this.mother = mother;
        }

        public Human(boolean sex) {
            this.sex = sex;
        }

    }
}
