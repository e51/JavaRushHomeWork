package com.javarush.test.level17.lesson10.home09;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* Транзакционность
Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
1. Считать с консоли 2 имени файла
2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
В методе joinData:
3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки, которые есть в forRemoveLines
4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
4.1. очистить allLines от данных
4.2. выбросить исключение CorruptedDataException
Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String file1 = in.readLine();
        String file2 = in.readLine();
//        String file1 = "C:/TEMP/1/file1.txt";
//        String file2 = "C:/TEMP/1/file2.txt";

        BufferedReader in1 = new BufferedReader(new FileReader(file1));
        while (in1.ready()) {
            allLines.add(in1.readLine());
        }

        BufferedReader in2 = new BufferedReader(new FileReader(file2));
        while (in2.ready()) {
            forRemoveLines.add(in2.readLine());
        }

        in1.close();
        in2.close();
        in.close();

        System.out.println(allLines);
        System.out.println(forRemoveLines);

        new Solution().joinData();

        System.out.println(allLines);
        System.out.println(forRemoveLines);


    }

    public void joinData () throws CorruptedDataException {

        if (forRemoveLines.size() > allLines.size()) {
            allLines.clear();
            throw new CorruptedDataException();
        }

        for (String string : forRemoveLines) {
            if (allLines.contains(string)) {
                allLines.remove(string);
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }


    }
}
