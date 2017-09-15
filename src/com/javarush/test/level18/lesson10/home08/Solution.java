package com.javarush.test.level18.lesson10.home08;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit"
Передайте имя файла в нить ReadThread
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки. Не использовать try-with-resources
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        while (!"exit".equals(str = in.readLine())) {
            new ReadThread(str).start();
        }
        in.close();
    }

    public static class ReadThread extends Thread {
        private String fileName;

        public ReadThread(String fileName) {
            //implement constructor body
            this.fileName = fileName;
        }
        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            FileInputStream is = null;
            Map<Integer, Integer> map = new HashMap<>();

            try {
                is = new FileInputStream(fileName);
            } catch (FileNotFoundException e) {
                return;
            }

            try {
                while (is.available() > 0) {
                    int i = is.read();
                    int count = 1;      // предполагаем, что байт встретился в первый раз

                    if (map.containsKey(Integer.valueOf(i))) {  // если байт уже встречался - изменить количество
                        count += map.get(Integer.valueOf(i));
                    }
                    map.put(Integer.valueOf(i), count);     // добавить байт в список (обновить уже имеющееся значение)

                }
            } catch (IOException e) {
                return;
            }

            int maxCount = Collections.max(map.values());

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == maxCount) {
                    resultMap.put(fileName, entry.getKey());
                }
            }

            try {
                is.close();
            } catch (IOException e) {
                return;
            }
        }

    }
}
