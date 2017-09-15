package com.javarush.test.level08.lesson11.home05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* Мама Мыла Раму. Теперь с большой буквы
Написать программу, которая вводит с клавиатуры строку текста.
Программа заменяет в тексте первые буквы всех слов на заглавные.
Вывести результат на экран.

Пример ввода:
  мама     мыла раму.

Пример вывода:
  Мама     Мыла Раму.
*/

public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char [] massiv = s.toCharArray();
        massiv[0] = Character.toUpperCase(massiv[0]);
        for (int i = 0; i < massiv.length - 1; i++) {
            if (massiv[i] == ' ' && massiv[i + 1] > ' ') massiv[i + 1] = Character.toUpperCase(massiv[i + 1]);
        }
        System.out.println(massiv);


//        char [] massiv = s.toCharArray();
//        massiv[0] = Character.toUpperCase(massiv[0]);
//        for (int i = 1; i < massiv.length; i++) {
//            if (massiv[i - 1] == ' ' && massiv[i] > ' ') massiv[i] = Character.toUpperCase(massiv[i]);
//        }
//        System.out.println(massiv);


//        char [] massiv = s.toCharArray();
//        for (int i = 0; i < massiv.length-1; i++) {
//            if(massiv[0] > ' ')massiv[0] = Character.toUpperCase(massiv[0]);
//            else if(massiv[i] == ' '&& massiv[i+1]>' ')massiv[i+1] = Character.toUpperCase(massiv[i+1]);
//            else if (massiv[i] == ' '&&i==(massiv.length-1))break;
//        }
//        System.out.println(massiv);//напишите тут ваш код


//        System.exit(0);

//        char [] massiv = s.toCharArray();
//        for (int i = 0; i <= massiv.length-1; i++) {
//            if(massiv[0] > ' ')massiv[0] = Character.toUpperCase(massiv[0]);
//            else if(massiv[i] == ' '&& massiv[i+1]>' ')massiv[i+1] = Character.toUpperCase(massiv[i+1]);
//            else if (massiv[i] == ' '&&i==(massiv.length-1))break;
//        }
//        System.out.println(massiv);//напишите тут ваш код

        System.exit(0);


        //напишите тут ваш код
        boolean toUp = true;
        for (char c : s.toCharArray()) {
            if (c != ' ' && toUp) {
                System.out.print(("" + c).toUpperCase());
                toUp = false;
            } else if (c == ' ') {
                toUp = true;
                System.out.print(c);
            } else {
                System.out.print(c);
            }


        }
    }


}
