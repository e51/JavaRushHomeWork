package com.javarush.test.level19.lesson10.home03;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* Хуан Хуанович
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя день месяц год
где [имя] - может состоять из нескольких слов, разделенных пробелами, и имеет тип String
[день] - int, [месяц] - int, [год] - int
данные разделены пробелами

Заполнить список PEOPLE импользуя данные из файла
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Иванов Иван Иванович 31 12 1987
Вася 15 5 2013
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file = new BufferedReader(new FileReader("C:/TEMP/1/sal.txt"));

        while (file.ready()) {
            String[] arr = file.readLine().split(" ");
            int size = arr.length - 1;
            Date fileDate = new Date(Integer.valueOf(arr[size]) - 1900, Integer.valueOf(arr[size - 1]) - 1, Integer.valueOf(arr[size - 2]));
            String name = "";
            for (int i = 0; i < size - 2; i++) {
                name = name + arr[i] + " ";
            }

            PEOPLE.add(new Person(name.trim(), fileDate));

        }

        file.close();

//        for (Person person : PEOPLE) {
//            System.out.println(person.getName() + " / " + person.getBirthday());
//        }

    }

}
