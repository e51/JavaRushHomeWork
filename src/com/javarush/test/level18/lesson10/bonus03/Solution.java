package com.javarush.test.level18.lesson10.bonus03;

/* Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-u  - обновляет данные товара с заданным id
-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();
//        String filename = "C:/TEMP/1/products.txt";

        BufferedReader file = new BufferedReader(new FileReader(filename));

        ArrayList<String> list = new ArrayList<>();

        while (file.ready()) {
            String line = file.readLine();
//            int id = Integer.valueOf(line.substring(0, 8).trim());
            String id = line.substring(0, 8).trim();

            if (id.equals(args[1])) {
                if ("-d".equals(args[0])) {
                    // NOP
                }
                if ("-u".equals(args[0])) {
                    String str = String.format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s", id, args[2], args[3], args[4]);
                    list.add(str);
                }

            } else {
                list.add(line);
            }
        }

        file.close();

//        BufferedWriter out = new BufferedWriter(new FileWriter(filename, false));
        PrintWriter fileWriter = new PrintWriter(filename);

        for (String string : list) {
            fileWriter.println(string);
//            out.write(string);
        }

//        for (int i = 1; i < args.length; i = i + 3) {
//            String str = String.format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s\n", ++maxID, args[0 + i], args[1 + i], args[2 + i]);
//            out.write(str);
//        }

        fileWriter.flush();
        fileWriter.close();

//        out.flush();
//        out.close();



        in.close();
    }


}
