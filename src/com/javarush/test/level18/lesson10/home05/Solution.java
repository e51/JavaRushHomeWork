package com.javarush.test.level18.lesson10.home05;

/* Округление чисел
Считать с консоли 2 имени файла
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415
Округлить числа до целых и записать через пробел во второй файл
Закрыть потоки. Не использовать try-with-resources
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename1 = in.readLine();
        String filename2 = in.readLine();

        BufferedReader file1 = new BufferedReader(new FileReader(filename1));
        FileWriter file2 = new FileWriter(filename2);

        String inputString = null;

        while ((inputString = file1.readLine()) != null) {
            for (String x : inputString.split(" ")) {
//            System.out.println( Math.round(Double.valueOf(x)));
                file2.write(String.valueOf(Math.round(Double.valueOf(x))) + " ");
            };
        }

        file2.close();
        file1.close();
        in.close();

    }
}
