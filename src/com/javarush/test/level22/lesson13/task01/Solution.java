package com.javarush.test.level22.lesson13.task01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/* StringTokenizer
Используя StringTokenizer разделить query на части по разделителю delimiter.
Пример,
getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
*/
public class Solution {
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> list = new ArrayList<>();
        String[] arr = null;

        StringTokenizer tokenizer = new StringTokenizer(query, delimiter);

        // Should use countTokens() !!!!!
//        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }

        arr = new String[list.size()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }

        return arr; //list.toArray();
    }

//    public static void main(String[] args) {
//        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));
//    }
}
