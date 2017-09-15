package com.javarush.test.level18.lesson10.home07;

/* Поиск данных внутри файла
Считать с консоли имя файла
Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
Программа запускается с одним параметром: id (int)
Закрыть потоки. Не использовать try-with-resources

В файле данные разделены пробелом и хранятся в следующей последовательности:
id productName price quantity

где id - int
productName - название товара, может содержать пробелы, String
price - цена, double
quantity - количество, int

Информация по каждому товару хранится в отдельной строке
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();

        int id = Integer.valueOf(args[0]);

        BufferedReader file1 = new BufferedReader(new FileReader(filename1));

        String str = null;

        while ((str = file1.readLine()) != null) {
            for (String x : str.split(" ")) {
                if (Integer.valueOf(x).equals(new Integer(id))) {
                    System.out.println(str);
                }
                break;
            };
        }

        file1.close();
        in.close();

    }
}
