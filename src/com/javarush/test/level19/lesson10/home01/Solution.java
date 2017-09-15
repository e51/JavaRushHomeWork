package com.javarush.test.level19.lesson10.home01;

/* Считаем зарплаты
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Все данные вывести в консоль, предварительно отсортировав в возрастающем порядке по имени
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 2
Сидоров 6
Иванов 1.35
Петров 3.1

Пример вывода:
Иванов 1.35
Петров 5.1
Сидоров 6.0
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file = new BufferedReader(new FileReader("C:/TEMP/1/sal.txt"));

        TreeMap<String, Double> map = new TreeMap<>();

        while (file.ready()) {
            String[] arr = file.readLine().split(" ");
            String name = arr[0];
            double value = 0;

            if (map.get(name) != null) {
                value = map.get(name);
            }
//            for (String key : map.keySet()) {
//                if (name.equals(key)) {
//                    value = map.get(key);
//                }
//            }

            map.put(name, value + Double.valueOf(arr[1]));

        }

        file.close();

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

//        System.out.println(map);


    }
}
