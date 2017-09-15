package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    Solution() {}
    Solution(int a, int b) {}
    Solution(int a, int b, int c) {}

    public Solution(byte a) {}
    public Solution(byte a, byte b) {}
    public Solution(byte a, byte b, byte c) {}

    protected Solution(short a) {}
    protected Solution(short a, short b) {}
    protected Solution(short a, short b, short c) {}

    private Solution(String a) {}
    private Solution(String a, String b) {}
    private Solution(String a, String b, String c) {}

}

