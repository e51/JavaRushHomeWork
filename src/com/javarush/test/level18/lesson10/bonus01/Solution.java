package com.javarush.test.level18.lesson10.bonus01;

/* Шифровка
Придумать механизм шифровки/дешифровки

Программа запускается с одним из следующих наборов параметров:
-e fileName fileOutputName
-d fileName fileOutputName
где
fileName - имя файла, который необходимо зашифровать/расшифровать
fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
-e - ключ указывает, что необходимо зашифровать данные
-d - ключ указывает, что необходимо расшифровать данные
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        if ("-e".equals(args[0])) {
            crypt(args[1], args[2], 1);
        }
        if ("-d".equals(args[0])) {
            crypt(args[1], args[2], -1);
        }
    }

    private static void crypt(String fileIn, String fileOut, int extraData) throws IOException {
        FileInputStream file1 = new FileInputStream(fileIn);
        FileOutputStream file2 = new FileOutputStream(fileOut);

        while (file1.available() > 0) {
            int i = file1.read();
            i = i + extraData;

            if (i == 256) {
                i = 0;
            }
            if (i == -1) {
                i = 255;
            }

            file2.write(i);
        }

        file1.close();
        file2.close();

    }

}
