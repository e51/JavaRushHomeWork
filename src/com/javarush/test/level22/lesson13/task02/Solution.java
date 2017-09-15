package com.javarush.test.level22.lesson13.task02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;

/* Смена кодировки
В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(args[0]));
        PrintWriter out = new PrintWriter(args[1]);

        while (in.ready()) {
            String strIn = new String(in.readLine().getBytes(Charset.forName("Windows-1251")));
            String strOut = new String(strIn.getBytes(Charset.forName("UTF-8")));
            out.write(strOut);
        }

        out.close();
        in.close();
    }
}
