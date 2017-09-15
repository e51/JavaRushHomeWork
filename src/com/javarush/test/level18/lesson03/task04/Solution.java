package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        FileInputStream file = new FileInputStream(filename);

        Map<Integer, Integer> map = new HashMap<>();

        while (file.available() > 0) {
            int i = file.read();
            int count = 1;      // предполагаем, что байт встретился в первый раз

            if (map.containsKey(Integer.valueOf(i))) {  // если байт уже встречался - изменить количество
                count += map.get(Integer.valueOf(i));
            }
            map.put(Integer.valueOf(i), count);     // добавить байт в список (обновить уже имеющееся значение)
        }

        // Вариант 1
        // не придумал ничего лучше, как выгрузить values в массив и взять минимальное значение через сортировку
//        Integer[] arr = map.values().toArray(new Integer[0]);
//        Arrays.sort(arr);
//        int minCount = arr[0];

        // Вариант 2
        int minCount = Collections.min(map.values());

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
//            System.out.println(entry.getKey() + " : " + entry.getValue());
            if (entry.getValue() == minCount) {     // вывести все байты из списка, у которых value равно minCount
//                System.out.println(entry.getKey() + " : " + entry.getValue());
                System.out.print(entry.getKey() + " ");
            }
        }

        file.close();
    }
}
