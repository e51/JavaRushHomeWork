package com.javarush.test.level21.lesson05.task02;

import java.util.HashSet;
import java.util.Set;

/* Исправить ошибку
Сравнение объектов Solution не работает должным образом. Найти ошибку и исправить.
Метод main не участвует в тестировании.
*/
public class Solution {
    private final String first, last;

    public Solution(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public int hashCode() {
        if (first == null || last == null) return 0;
        return 31 * first.hashCode() + last.hashCode();

//        return super.hashCode();
    }

    public boolean equals(Object o) {
        if (o == this) { return true; }
        if (o == null) return false;
//        if (obj.getClass() != this.getClass()) return false;

        if (!(o instanceof Solution))
            return false;
        Solution n = (Solution) o;
        return (first == n.first || (first != null && first.equals(n.first))) && (last == n.last || (last != null && last.equals(n.last)));

//        return n.first.equals(first) && n.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Mickey", "Mouse"));
        System.out.println(s.contains(new Solution("Mickey", "Mouse")));
    }
}
