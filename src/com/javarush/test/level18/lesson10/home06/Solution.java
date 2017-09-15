package com.javarush.test.level18.lesson10.home06;

/* Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете). Пример: ','=44, 's'=115, 't'=116
Вывести на консоль отсортированный результат:
[символ1]  частота1
[символ2]  частота2
Закрыть потоки. Не использовать try-with-resources

Пример вывода:
, 19
- 7
f 361
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream file = new FileInputStream(args[0]);

        Map<Integer, Integer> map = new TreeMap<>();

        while (file.available() > 0) {
            int i = file.read();
            int count = 1;      // предполагаем, что байт встретился в первый раз

            if (map.containsKey(Integer.valueOf(i))) {  // если байт уже встречался - изменить количество
                count += map.get(Integer.valueOf(i));
            }
            map.put(Integer.valueOf(i), count);     // добавить байт в список (обновить уже имеющееся значение)
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(String.valueOf((char) (int) entry.getKey()) + " " + entry.getValue());
        }

        file.close();
    }
}
