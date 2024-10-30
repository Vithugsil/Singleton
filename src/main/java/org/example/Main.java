package org.example;

public class Main {
    public static void main(String[] args) {

        Costumer c1 = new Costumer("1102", "Robert");
        c1.deposit(600.00);
        c1.withdraw(150);
        c1.getBalance();
        AccountManager.getInstance().getAccounts();

    }
}