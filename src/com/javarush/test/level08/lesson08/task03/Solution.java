package com.javarush.test.level08.lesson08.task03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/* Одинаковые имя и фамилия
Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
*/

public class Solution
{

//    public static void main(String[] args) throws IOException {
//        HashMap<String, String> map = createMap();
//        System.out.println(getCountTheSameFirstName(map, "Steve"));
//        System.out.println(getCountTheSameLastName(map, "Stallone1"));
//
//    }


    public static HashMap<String, String> createMap() throws IOException {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();
//        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 10; i++) {
//            map.put(in.readLine(), in.readLine());
            map.put("lastName" + i, "name" + i);
        }

        return map;

    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getValue().equals(name)) {
                count++;
            }
        }

        return count;

    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName)
    {
        //напишите тут ваш код
        int count = 0;
        for (Map.Entry<String, String> pair : map.entrySet()) {
            if (pair.getKey().equals(lastName)) {
                count++;
            }
        }

        return count;

    }
}
