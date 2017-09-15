package com.javarush.test.level08.lesson06.task02;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/* Провести 10 тысяч вставок, удалений
Для arrayList и linkedList провести 10 тысяч вставок, удалений, а также вызовов get и set.
*/

public class Solution
{
    public static void main(String[] args) throws Exception
    {

        // ArrayList
        ArrayList arrayList = new ArrayList();
        Date dateBefore = new Date();
        insert10000(arrayList);
        Date dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        get10000(arrayList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        set10000(arrayList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        remove10000(arrayList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());


        System.out.println("---------");
        // LinkedList
        LinkedList linkedList = new LinkedList();

        dateBefore = new Date();
        insert10000(linkedList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        get10000(linkedList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        set10000(linkedList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());

        dateBefore = new Date();
        remove10000(linkedList);
        dateAfter = new Date();
        System.out.println(dateAfter.getTime() - dateBefore.getTime());
    }

    public static void insert10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.add(0, i);
        }

    }

    public static void get10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.get(i);
        }

    }

    public static void set10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.set(i, i);
        }

    }

    public static void remove10000(List list)
    {
        //напишите тут ваш код
        for (int i = 0; i < 10000; i++) {
            list.remove(0);
        }

    }
}
