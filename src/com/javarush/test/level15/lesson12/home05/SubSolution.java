package com.javarush.test.level15.lesson12.home05;

/**
 * Created by user on 14.03.2016.
 */
public class SubSolution extends Solution {
    SubSolution() {        super();    }
    SubSolution(int a, int b) {        super(a, b);    }
    SubSolution(int a, int b, int c) {        super(a, b, c);    }

    public SubSolution(byte a) {        super(a);    }
    public SubSolution(byte a, byte b) {        super(a, b);    }
    public SubSolution(byte a, byte b, byte c) {        super(a, b, c);    }

    protected SubSolution(short a) {        super(a);    }
    protected SubSolution(short a, short b) {        super(a, b);    }
    protected SubSolution(short a, short b, short c) {        super(a, b, c);    }

    private SubSolution(String a) { super(); }
    private SubSolution(String a, String b) {        super();    }
    private SubSolution(String a, String b, String c) {        super();    }

}
