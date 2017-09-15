package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
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
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) { return true; }
        if (obj == null) return false;
        if (obj.getClass() != this.getClass()) return false;

        Solution guest = (Solution) obj;

        return (first == guest.first || (first != null && first.equals(guest.first))) && (last == guest.last || (last != null && last.equals(guest.last)));


//        if (o.first == null && first != null) return false;
//        if (o.last == null && last != null) return false;

//        return o.first.equals(first) && o.last.equals(last);
//        return o.first == null ? true : o.first.equals(first) && o.last == null ? true : o.last.equals(last);
    }

    public static void main(String[] args) {
        Set<Solution> s = new HashSet<>();

        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));

        s.add(new Solution(null, null));
        System.out.println(s.contains(new Solution(null, "5")));

        s.add(new Solution(null, "Duck"));
        System.out.println(s.contains(new Solution(null, "Duck")));

        s.add(new Solution("Donald", null));
        System.out.println(s.contains(new Solution("Donald", null)));

    }
}
