package com.javarush.test.level22.lesson09.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* Обращенные слова
В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
Порядок слов first/second не влияет на тестирование.
Использовать StringBuilder.
Пример содержимого файла
рот тор торт о
о тот тот тот
Вывод:
рот тор
о о
тот тот
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String filename = in.readLine();

        BufferedReader file = new BufferedReader(new FileReader(filename));
//        BufferedReader file = new BufferedReader(new FileReader("C:/TEMP/1/words.txt"));

        ArrayList<String> list = new ArrayList<>();

        while (file.ready()) {
            String[] strings = file.readLine().split(" ");
            list.addAll(Arrays.asList(strings));
        }

//        System.out.println(list);

        boolean got = false;
        for (int i = 0; i < list.size(); i++) {

            got = false;
            // Проверка по result
            for (Pair pair : result) {
                String first = pair.getFirst();
                String second = pair.getSecond();
                if (first.equals(list.get(i)) || second.equals(list.get(i))) {
                    // уже есть это слово в result
                    got = true;
                }
            }

            if (got) continue;

            for (int j = i + 1; j < list.size(); j++) {
                StringBuilder str = new StringBuilder(list.get(j)).reverse();
                if (list.get(i).equals(str.toString())) {
                    // Есть совпадение
                    result.add(new Pair(list.get(i), list.get(j)));
                    break;
                }
            }
        }

//        System.out.println(result);
    }

    public static class Pair {
        String first;
        String second;

        public Pair(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public String getSecond() {
            return second;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
