package com.javarush.test.level19.lesson10.bonus02;

/* Свой FileWriter
Реализовать логику FileConsoleWriter
Должен наследоваться от FileWriter
При записи данных в файл, должен дублировать эти данные на консоль
*/

import java.io.*;

public class FileConsoleWriter extends FileWriter {
//    private FileWriter component;

//    public static void main(String[] args) throws Exception {
//        // Проверка FileConsoleWriter
//        FileWriter f2 = new FileConsoleWriter("C:/TEMP/1/191002.txt");
//
//        f2.write("strnig 1");
//        f2.write("string 2222 2 2 \n");
//        f2.write('c');
//        f2.write("abcde".toCharArray());
//
//        f2.close();
//
//
//    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(cbuf, off, len);
        System.out.print((new String(cbuf)).substring(off, off + len));
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c);
        System.out.print((char) c);
    }

    @Override
    public void write(char[] cbuf) throws IOException {
//        super.write(cbuf);
        write(cbuf, 0, cbuf.length);
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str, off, len);
        System.out.print(str.substring(off, off + len));
    }

    @Override
    public void write(String str) throws IOException {
//        super.write(str);
        write(str, 0, str.length());
    }

    public FileConsoleWriter(String fileName) throws IOException {
        super(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        super(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        super(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        super(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        super(fd);
    }
}
