package com.javarush.test.level24.lesson04.home01;

import com.javarush.test.level05.lesson07.task05.Rectangle;
import com.javarush.test.level24.lesson04.home01.HasHeight;
import com.javarush.test.level24.lesson04.home01.HasWidth;
import com.javarush.test.level24.lesson04.home01.Point;

/* Рефакторинг
В классе Rectangle:
1. Измените методы getHeight и getWidth, чтобы они возвращали HasHeight и HasWidth соответственно.
2. Для этого внутри методов getHeight и getWidth создайте локальные классы - реализации интерфейсов.
3. Переименуйте getHeight в castToHasHeight, getWidth в castToHasWidth (на имени метода нажмите Shift+F6).
4. Уберите наследование интерфейсов в классе  Rectangle.
Методы интерфейсов не менять.
*/
public class Solution {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1, 2, 3, 4);
        System.out.println(getHeight(rectangle));
        System.out.println(getWidth(rectangle));
        /////////////////////expected//////////////////
        //System.out.println(getHeight(rectangle.castToHasHeight()));
        //System.out.println(getWidth(rectangle.castToHasWidth()));
    }

    public static double getHeight(Rectangle rectangle) {
        return rectangle.castToHasHeight();
    }

    public static double getWidth(Rectangle rectangle) {
        return rectangle.castToHasWidth();
    }


    public static class Rectangle {
        private Point point1;
        private Point point2;

        public Rectangle(double x1, double y1, double x2, double y2) {
            point1 = new Point(x1, y1);
            point2 = new Point(x2, y2);
        }

        public double castToHasHeight() {
            return Math.abs(point1.getY() - point2.getY());
        }

        public double castToHasWidth() {
            return Math.abs(point1.getX() - point2.getX());
        }
    }
}
