package com.javarush.test.level18.lesson10.bonus02;

/* Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле

В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины

Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();
//        String filename = "C:/TEMP/1/products.txt";

        BufferedReader file = new BufferedReader(new FileReader(filename));

        int maxID = 0;
        while (file.ready()) {
            String line = file.readLine();
            int id = Integer.valueOf(line.substring(0, 8).trim());
            if (id > maxID) {
                maxID = id;
            }
        }

        file.close();

        BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
//        PrintWriter fileWriter = new PrintWriter(filename);

        for (int i = 1; i < args.length; i = i + 3) {
            String str = String.format("%1$-8.8s%2$-30.30s%3$-8.8s%4$-4.4s\n", ++maxID, args[0 + i], args[1 + i], args[2 + i]);
//            fileWriter.println(str);
            out.write(str);
//            System.out.println(str);
        }

//        fileWriter.flush();
//        fileWriter.close();

        out.flush();
        out.close();



        in.close();
    }
}
