package com.javarush.test.level20.lesson07.task02;

import java.io.*;

/* OutputToConsole
Класс OutputToConsole должен сериализоваться с помощью интерфейса Externalizable.
Подумайте, какие поля не нужно сериализовать.
Исправьте ошибку.
Сигнатуры методов менять нельзя.
*/
public class Solution {
    public static String greeting = "Hello world";

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        OutputToConsole otc = new OutputToConsole(2);
//
//        otc.outputToConsole(2);
//
//        FileOutputStream file = new FileOutputStream("C:\\TEMP\\1\\otc.slz");
//        ObjectOutputStream outputStream = new ObjectOutputStream(file);
//        outputStream.writeObject(otc);
//        file.close();
//        outputStream.close();
//
////        OutputToConsole otc2 = new OutputToConsole(3);
////        otc2.i = 10;
//        FileInputStream fileInputStream = new FileInputStream("C:\\TEMP\\1\\otc.slz");
//        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
//        Object object = objectInputStream.readObject();
//        fileInputStream.close();
//        objectInputStream.close();
//
//        OutputToConsole otc2 = (OutputToConsole) object;
//
//        otc.outputToConsole(2);
//        otc2.outputToConsole(3);
//
//    }

    /**
     * OutputToConsole is the inner base class for improving your attentiveness.
     * An OutputToConsole object encapsulates the information needed
     * for the displaying [greeting] variable to the console by character.
     * @author JavaRush
     */
    public static class OutputToConsole implements Externalizable {
        private int i = 8;

        /**
         * @param out A stream for an externalization
         * @throws java.io.IOException
         */
        @Override
        public void writeExternal(ObjectOutput out) throws IOException {
            out.writeInt(i);
        }

        /**
         * @param in A stream for a de-externalization
         * @throws java.io.IOException
         * @throws ClassNotFoundException
         */
        @Override
        public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
            i = in.readInt();
        }

        /**
         * Class constructor specifying fake private field [i].
         */
        public OutputToConsole(int ii) {
            this.i = ii;
        }

        public OutputToConsole() {

        }

        /**
         * Outputs to the console a static field of Solution class [greeting].
         * Has to use [charAt] method of String class
         */
        public void outputToConsole(int ii) {
            for (int i = 0; i < greeting.length(); i++) {
                System.out.write(greeting.charAt(i));
            }
        }
    }
}
