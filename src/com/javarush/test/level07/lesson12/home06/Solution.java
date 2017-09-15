package com.javarush.test.level07.lesson12.home06;

/* Семья
Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human). Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей. Вывести объекты на экран.
Примечание:
Если написать свой метод String toString() в классе Human, то именно он будет использоваться при выводе объекта на экран.
Пример вывода:
Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
Имя: Катя, пол: женский, возраст: 55
Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
…
*/

public class Solution
{
    public static void main(String[] args)
    {
        //напишите тут ваш код
        Human grandpa1 = new Human();
        Human grandpa2 = new Human();
        Human grandma1 = new Human();
        Human grandma2 = new Human();

        Human father = new Human();
        Human mother = new Human();

        Human child1 = new Human();
        Human child2 = new Human();
        Human child3 = new Human();

        grandpa1.name = "Иван";
        grandpa1.age = 70;
        grandpa2.name = "Степан";
        grandpa2.age = 72;
        grandma1.name = "Софья";
        grandma1.age = 65;
        grandma1.sex = false;
        grandma2.name = "Аля";
        grandma2.age = 64;
        grandma2.sex = false;

        father.name = "Борис";
        father.age = 40;
        mother.name = "Кристина";
        mother.age = 30;
        mother.sex = false;

        child1.name = "Петя";
        child1.age = 7;
        child2.name = "Коля";
        child2.age = 5;
        child3.name = "Маша";
        child3.age = 6;
        child3.sex = false;

        child1.father = father;
        child1.mother = mother;
        child2.father = father;
        child2.mother = mother;
        child3.father = father;
        child3.mother = mother;

        father.father = grandpa1;
        father.mother = grandma1;

        mother.father = grandpa2;
        mother.mother = grandma2;

        System.out.println(father);
        System.out.println(mother);
        System.out.println(grandpa1);
        System.out.println(grandma1);
        System.out.println(grandpa2);
        System.out.println(grandma2);
        System.out.println(child1);
        System.out.println(child2);
        System.out.println(child3);
    }

    public static class Human
    {
        //напишите тут ваш код
        private String name = "Joe Doe";
        private boolean sex = true;
        private int age = 1;
        private Human father;
        private Human mother;

        public String toString()
        {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }

}
