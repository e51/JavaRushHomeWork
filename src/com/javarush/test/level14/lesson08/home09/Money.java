package com.javarush.test.level14.lesson08.home09;

public abstract class Money
{
    private double amount = 0.0d;

    public Money(double amount)
    {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    };

    public abstract String getCurrencyName();
}
