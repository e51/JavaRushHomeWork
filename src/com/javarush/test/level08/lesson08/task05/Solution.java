package com.javarush.test.level08.lesson08.task05;

import java.util.*;

/* Удалить людей, имеющих одинаковые имена
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
Удалить людей, имеющих одинаковые имена.
*/

public class Solution
{
    public static HashMap<String, String> createMap()
    {
        //напишите тут ваш код
        HashMap<String, String> map = new HashMap<String, String>();

        map.put("Stallone", "Silvester");
        map.put("Moore", "Jacky");
        map.put("Geere", "Richard");
        map.put("DiCaprio", "Leo");
        map.put("Farmer", "Melene");
        map.put("Hoskins", "Leo");
        map.put("Willis", "Bruce");
        map.put("Chan", "Jacky");
        map.put("Seagal", "Steven");
        map.put("Norris", "Chuck");

//        System.out.println(map);
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
    {
        //напишите тут ваш код
        HashMap<String, String> copy = new HashMap<String, String>(map);

        for (Map.Entry<String, String> pair1 : copy.entrySet()) {
            int count = 0;
            String value = pair1.getValue();        //значение
            for (Map.Entry<String, String> pair2: map.entrySet()) {
                if (pair2.getValue().equals(value))
                    count++;
            }

            if (count > 1)
                removeItemFromMapByValue(map, value);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
    {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet())
        {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

        System.out.println(map.size());
    }
}
