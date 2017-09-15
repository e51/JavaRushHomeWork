package com.javarush.test.level24.lesson02.task02;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.server.RemoteObject;
import java.util.ArrayDeque;
import java.util.EventListener;

/* Так-с...сопоставим
Исправьте ошибки: переместите методы clone в те классы, в которых они должны быть реализованы.
Лишние методы удалите.
*/
public class Solution implements Cloneable {
    public static class A implements Serializable, Cloneable {
        protected A clone() throws CloneNotSupportedException {
            return (A) super.clone();
        }
    }

    public static class B implements Remote, Cloneable {
        protected final B clone() throws CloneNotSupportedException {
            return (B) super.clone();
        }
    }

    public static class C extends ArrayDeque implements Cloneable {
//        protected ArrayDeque clone() throws CloneNotSupportedException {
//            return super.clone();
//        }


        public C clone() {
            return (C) super.clone();
        }
    }

    public static class D implements EventListener, Cloneable {
        protected D clone() throws CloneNotSupportedException {
            return (D) super.clone();
        }
    }




}
