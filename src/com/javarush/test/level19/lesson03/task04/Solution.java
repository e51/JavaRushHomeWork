package com.javarush.test.level19.lesson03.task04;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* И еще один адаптер
Адаптировать Scanner к PersonScanner.
Классом-адаптером является PersonScannerAdapter.
Данные в файле хранятся в следующем виде:
Иванов Иван Иванович 31 12 1950

В файле хранится большое количество людей, данные одного человека находятся в одной строке. Метод read() должен читать данные одного человека.
*/

public class Solution {

//    public static void main(String[] args) throws IOException {
//        Scanner scanner = new Scanner(new File("C:\\TEMP\\1\\ivan.txt"));
////        Scanner scanner = new Scanner("Иванов Иван Иванович 31 12 1950");
//        PersonScanner ps = new PersonScannerAdapter(scanner);
//        System.out.println(ps.read());
//
//    }

    public static class PersonScannerAdapter implements PersonScanner {
        private Scanner component;

        public PersonScannerAdapter(Scanner component) {
            this.component = component;
        }

        @Override
        public Person read() throws IOException {
//            System.out.println(component.nextLine());
            String[] arr = component.nextLine().split(" ");
//            System.out.println(Arrays.toString(arr));

            Calendar birthDate = new GregorianCalendar(Integer.parseInt(arr[5]), Integer.parseInt(arr[4]) - 1, Integer.parseInt(arr[3]));

//            return new Person(arr[1], arr[2], arr[0], new Date(Integer.valueOf(arr[5]) - 1900, Integer.valueOf(arr[4]) - 1, Integer.valueOf(arr[3])));
            return new Person(arr[1], arr[2], arr[0], birthDate.getTime());
        }

        @Override
        public void close() throws IOException {
            component.close();
        }
    }
}
