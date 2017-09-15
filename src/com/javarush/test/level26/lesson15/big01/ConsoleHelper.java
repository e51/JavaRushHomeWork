package com.javarush.test.level26.lesson15.big01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 18.12.2016.
 */
public class ConsoleHelper {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() {
        try {
            return in.readLine();
        } catch (IOException ignore) { /* NOP */ }

        return null;
    }

    public static String askCurrencyCode() {
        String value = null;
        while (true) {
            value = readString();
            if (value.length() != 3) {
                writeMessage("Error code. Try again, please.");
            } else {
                break;
            }
        }

        return value.toUpperCase();
    }

    public static String[] getValidTwoDigits(String currencyCode) {
        String value = null;
        String[] values;
        while (true) {
            value = readString();
            values = value.split(" ");
            boolean valuesOK = true;
            for (String string : values) {
                try {
                    int val = Integer.valueOf(string);
                    if (val <= 0) {
                        valuesOK = false;
                    }
                } catch (NumberFormatException e) {
                    valuesOK = false;
                    break;
                }
            }
            if (!valuesOK) {
                writeMessage("Error input. Please, try again");
            } else {
                break;
            }
        }

        return values;
    }
}
