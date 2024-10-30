package org.example;

public class Costumer {
    private String costumerID;
    private String costumerName;

    public Costumer(String costumerID, String costumerName) {
        this.costumerID = costumerID;
        this.costumerName = costumerName;
        AccountManager.getInstance().createAccount(costumerID, 0);
    }

    public void deposit(double amount) {
        AccountManager.getInstance().deposit(costumerID, amount);
    }

    public void withdraw(double amount) {
        AccountManager.getInstance().withdraw(costumerID, amount);
    }

    public void getBalance() {
        AccountManager.getInstance().getBalance(costumerID);
    }

}
