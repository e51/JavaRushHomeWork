package com.javarush.test.level17.lesson10.bonus01;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD
CrUD - Create, Update, Delete
Программа запускается с одним из следующих наборов параметров:
-c name sex bd
-u id name sex bd
-d id
-i id
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
-u  - обновляет данные человека с данным id
-d  - производит логическое удаление человека с id
-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)

id соответствует индексу в списке
Все люди должны храниться в allPeople
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat

Пример параметров: -c Миронов м 15/04/1990
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

//        System.out.println(allPeople);


        if ("-c".equals(args[0])) {
            Person person = null;
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            if ("ж".equals(args[2])) {
                person = Person.createFemale(args[1], simpleDateFormat.parse(args[3]));
            } else {
                person = Person.createMale(args[1], simpleDateFormat.parse(args[3]));
            }

            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        }

        if ("-u".equals(args[0])) {
            Person person = allPeople.get(Integer.valueOf(args[1]).intValue());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            person.setName(args[2]);

            if ("ж".equals(args[3])) {
                person.setSex(Sex.FEMALE);
            } else {
                person.setSex(Sex.MALE);
            }

            person.setBirthDay(simpleDateFormat.parse(args[4]));
        }

        if ("-d".equals(args[0])) {
//            allPeople.remove(Integer.valueOf(args[1]).intValue());
            int id = Integer.parseInt(args[1]);
            allPeople.get(id).setSex(null);
            allPeople.get(id).setBirthDay(null);
            allPeople.get(id).setName(null);
        }

        if ("-i".equals(args[0])) {
            Person person = allPeople.get(Integer.valueOf(args[1]));
            System.out.printf("%2$s %3$s %1$te-%1$tb-%1$tY\n", person.getBirthDay(), person.getName(), person.getSex() == Sex.MALE ? "м" : "ж");
        }



//        System.out.println(allPeople);

    }
}
