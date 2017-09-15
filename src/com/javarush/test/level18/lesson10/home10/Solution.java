package com.javarush.test.level18.lesson10.home10;

/* Собираем файл
Собираем файл из кусочков
Считывать с консоли имена файлов
Каждый файл имеет имя: [someName].partN. Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end"
В папке, где находятся все прочтенные файлы, создать файл без приставки [.partN]. Например, Lion.avi
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        String part1 = null;
        FileInputStream is = null;
        FileOutputStream os = null;
        List<String> list = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();

        while (!"end".equals(str = in.readLine())) {
            list.add(str);
            set.add(Integer.valueOf(str.substring(str.lastIndexOf('.') + 1).replace("part", "")));
        }

//        System.out.println(set);
//        System.out.println(list);

        part1 = list.get(0).substring(0, list.get(0).lastIndexOf('.') + 1) + "part";
//        System.out.println(part1);

        os = new FileOutputStream(list.get(0).substring(0, part1.lastIndexOf('.')));

//        System.out.println(list.get(0).substring(0, part1.lastIndexOf('.')));
//        System.exit(0);

        for (Integer x : set) {
            is = new FileInputStream(part1 + x);
            if (is.available() > 0) {
                byte[] buff = new byte[is.available()];
                int count = is.read(buff);

                os.write(buff, 0, count);
            }
            is.close();
        }

        os.close();
        in.close();
    }

}

