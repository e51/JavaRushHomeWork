package com.javarush.test.level08.lesson11.home06;

/* Вся семья в сборе
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
*/

import java.util.ArrayList;
import java.util.Collections;

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код

        Human children1 = new Human("Вася", true, 5, new ArrayList<Human>());
        Human children2 = new Human("Петя", true, 7, new ArrayList<Human>());
        Human children3 = new Human("Маша", false, 6, new ArrayList<Human>());

        Human father = new Human("Григорий", true, 35, new ArrayList<Human>());
        father.addChildren(children1);
        father.addChildren(children2);
        father.addChildren(children3);

        Human mother = new Human("Василиса", false, 25, new ArrayList<Human>());
        mother.addChildren(children1);
        mother.addChildren(children2);
        mother.addChildren(children3);

        Human grandpa1 = new Human("Эдуард 1й", true, 65, new ArrayList<Human>());
        Human grandpa2 = new Human("Георгий 2й", true, 71, new ArrayList<Human>());
        Human granma1 = new Human("Елизавета 1", false, 68, new ArrayList<Human>());
        Human granma2 = new Human("Екатерина 2", false, 67, new ArrayList<Human>());

        grandpa1.addChildren(father);
        granma1.addChildren(father);

        grandpa2.addChildren(mother);
        granma2.addChildren(mother);

        System.out.println(children1);
        System.out.println(children2);
        System.out.println(children3);
        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandpa1);
        System.out.println(granma1);
        System.out.println(grandpa2);
        System.out.println(granma2);
    }

    public static class Human
    {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public void addChildren(Human human) {
            this.children.add(human);
        }

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0)
            {
                text += ", дети: "+this.children.get(0).name;

                for (int i = 1; i < childCount; i++)
                {
                    Human child = this.children.get(i);
                    text += ", "+child.name;
                }
            }

            return text;
        }
    }

}
