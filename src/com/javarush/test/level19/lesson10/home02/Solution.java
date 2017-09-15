package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader(args[0]));
//        BufferedReader file = new BufferedReader(new FileReader("C:/TEMP/1/sal.txt"));

        HashMap<String, Double> map = new HashMap<>();

        while (file.ready()) {
            String[] arr = file.readLine().split(" ");
            String name = arr[0];
            double value = 0;

            if (map.get(name) != null) {
                value = map.get(name);
            }

            map.put(name, value + Double.valueOf(arr[1]));

        }

        file.close();


        double maxVal = Collections.max(map.values());

        for (Map.Entry<String, Double> entry : map.entrySet()) {
            if (entry.getValue() == maxVal) {
                System.out.println(entry.getKey());
            }
        }
    }
}
