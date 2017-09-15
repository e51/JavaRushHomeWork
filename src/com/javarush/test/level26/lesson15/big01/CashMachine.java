package com.javarush.test.level26.lesson15.big01;

/**
 * Created by user on 18.12.2016.
 */
public class CashMachine {
    public static void main(String[] args) {
        String currencyCode = ConsoleHelper.askCurrencyCode();
        String[] denominations = ConsoleHelper.getValidTwoDigits(currencyCode);

        CurrencyManipulator currencyManipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
        currencyManipulator.addAmount(Integer.valueOf(denominations[0]), Integer.valueOf(denominations[1]));

    }
}
