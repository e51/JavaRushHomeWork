package com.javarush.test.level23.lesson04.task01;

/* Inner
Реализовать метод getTwoSolutions, который должен возвращать массив из 2-х экземпляров класса Solution.
Для каждого экземпляра класса Solution инициализировать поле innerClasses двумя значениями.
Инициализация всех данных должна происходить только в методе getTwoSolutions.
*/
public class Solution {
    public InnerClass[] innerClasses = new InnerClass[2];

    public class InnerClass {
    }

    public static Solution[] getTwoSolutions() {
        Solution solution1 = new Solution();
        InnerClass inner11 = solution1.new InnerClass();
        InnerClass inner12 = solution1.new InnerClass();

        solution1.innerClasses[0] = inner11;
        solution1.innerClasses[1] = inner12;

        Solution solution2 = new Solution();
        InnerClass inner121 = solution2.new InnerClass();
        InnerClass inner122 = solution2.new InnerClass();

        solution2.innerClasses[0] = inner121;
        solution2.innerClasses[1] = inner122;


        return new Solution[] {solution1, solution2};
    }
}
