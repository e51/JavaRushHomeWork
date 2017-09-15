package com.javarush.test.level05.lesson12.home02;

/* Man and Woman
1. Внутри класса Solution создай public static классы Man и Woman.
2. У классов должны быть поля: name(String), age(int), address(String).
3. Создай конструкторы, в которые передаются все возможные параметры.
4. Создай по два объекта каждого класса со всеми данными используя конструктор.
5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
*/

public class Solution
{
    public static void main(String[] args)
    {
        //создай по два объекта каждого класса тут
        Man man1 = new Man("Stallone", 65, "Los Angeles");
        Man man2 = new Man("Robocop", 38, "NY");
        Woman woman1 = new Woman("Catgirl", 25, "Sex city");
        Woman woman2 = new Woman("Sexgirl", 19, "pornhub");

        //выведи их на экран тут
        man1.toScreen();
        man2.toScreen();

        woman1.toScreen();
        woman2.toScreen();

    }

    //добавьте тут ваши классы
    public static class Man {
        private String name = "Mr.X";
        private int age = 1;
        private String address = "";

        public Man(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void toScreen() {
            System.out.println(name + " " + age + " " + address);
        }
    }

    public static class Woman {
        private String name = "Mrs.X";
        private int age = 1;
        private String address = "";

        public Woman(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public void toScreen() {
            System.out.println(name + " " + age + " " + address);
        }

    }

}
