package com.javarush.test.level26.lesson15.big01;

import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by user on 18.12.2016.
 */
public class CurrencyManipulatorFactory {
    private static ArrayList<CurrencyManipulator> manipulators = new ArrayList<>();

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for (CurrencyManipulator manipulator : manipulators) {
            if (manipulator.getCurrencyCode().equals(currencyCode)) {
                return manipulator;
            }
        }
        manipulators.add(new CurrencyManipulator(currencyCode));
        return manipulators.get(manipulators.size() - 1);
    }

    private CurrencyManipulatorFactory() {
    }
}
