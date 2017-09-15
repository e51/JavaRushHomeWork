package com.javarush.test.level17.lesson10.bonus02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* CRUD 2
CrUD Batch - multiple Creation, Updates, Deletion
!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!

Программа запускается с одним из следующих наборов параметров:
-c name1 sex1 bd1 name2 sex2 bd2 ...
-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
-d id1 id2 id3 id4 ...
-i id1 id2 id3 id4 ...
Значения параметров:
name - имя, String
sex - пол, "м" или "ж", одна буква
bd - дата рождения в следующем формате 15/04/1990
-с  - добавляет всех людей с заданными параметрами в конец allPeople, выводит id (index) на экран в соответствующем порядке
-u  - обновляет соответствующие данные людей с заданными id
-d  - производит логическое удаление всех людей с заданными id
-i  - выводит на экран информацию о всех людях с заданными id: name sex bd

id соответствует индексу в списке
Формат вывода даты рождения 15-Apr-1990
Все люди должны храниться в allPeople
Порядок вывода данных соответствует вводу данных
Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();
    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут

//        System.out.println(allPeople);


        if ("-c".equals(args[0])) {
            Person person = null;
            synchronized (allPeople) {
                for (int i = 1; i < args.length; i = i + 3) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                    if ("ж".equals(args[i + 1])) {
                        person = Person.createFemale(args[i], simpleDateFormat.parse(args[i + 2]));
                    } else {
                        person = Person.createMale(args[i], simpleDateFormat.parse(args[i + 2]));
                    }

                    allPeople.add(person);
                    System.out.println(allPeople.size() - 1);
                }
            }
        }

        if ("-u".equals(args[0])) {

            synchronized (allPeople) {
                for (int i = 1; i < args.length; i = i + 4) {

                    Person person = allPeople.get(Integer.valueOf(args[i]).intValue());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

                    person.setName(args[i + 1]);

                    if ("ж".equals(args[i + 2])) {
                        person.setSex(Sex.FEMALE);
                    } else {
                        person.setSex(Sex.MALE);
                    }

                    person.setBirthDay(simpleDateFormat.parse(args[i + 3]));
                }
            }
        }

        if ("-d".equals(args[0])) {
//            allPeople.remove(Integer.valueOf(args[1]).intValue());
            synchronized (allPeople) {

                for (int i = 1; i < args.length; i++) {
                    int id = Integer.parseInt(args[i]);
                    allPeople.get(id).setSex(null);
                    allPeople.get(id).setBirthDay(null);
                    allPeople.get(id).setName(null);
                }
            }
        }

        if ("-i".equals(args[0])) {
            synchronized (allPeople) {

                for (int i = 1; i < args.length; i++) {
                    Person person = allPeople.get(Integer.valueOf(args[i]));
                    System.out.printf("%2$s %3$s %1$te-%1$tb-%1$tY\n", person.getBirthDay(), person.getName(), person.getSex() == Sex.MALE ? "м" : "ж");
                }
            }

        }



//        System.out.println(allPeople);

    }
}
