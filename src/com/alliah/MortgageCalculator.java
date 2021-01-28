package com.alliah;

public class MortgageCalculator {
    public final static byte MONTHS_IN_YEAR = 12;
    public final static byte PERCENT = 100;

    private int principal;
    private float annualInterest;
    private byte years;

    public MortgageCalculator(int principal, float annualInterest, byte years){
        this.principal = principal;
        this.annualInterest = annualInterest;
        this.years = years;
    }

    public double calculateBalance(short numberOfPaymentsMade) {
        double balance = principal
                * (Math.pow(1 + getMonthlyInterest(annualInterest), getNumberOfPayments())
                - Math.pow(1 + getMonthlyInterest(annualInterest), numberOfPaymentsMade))
                / (Math.pow(1 + getMonthlyInterest(annualInterest), getNumberOfPayments()) - 1);

        return balance;
    }

    public double calculateMortgage() {
        double mortgage = principal
                * (getMonthlyInterest(annualInterest)
                * Math.pow(1 + getMonthlyInterest(annualInterest), getNumberOfPayments()))
                / (Math.pow(1 + getMonthlyInterest(annualInterest), getNumberOfPayments()) - 1);

        return mortgage;
    }
    public double[] getRemainingBalance() {
        double balances[] = new double[getNumberOfPayments()];
        for (short month = 1; month <= balances.length; month++)
            balances[month -1] = calculateBalance(month);

        return balances;
    }

    private int getNumberOfPayments() {
        return years * MONTHS_IN_YEAR;
    }

    private float getMonthlyInterest(float annualInterest) {
        return annualInterest / PERCENT / MONTHS_IN_YEAR;
    }
}
