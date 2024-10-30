package org.example;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
    private static AccountManager instance;
    private Map<String, Double> accounts;

    private AccountManager() {
        accounts = new HashMap<>();
    }

    public static AccountManager getInstance() {
        if (instance == null) {
            synchronized (AccountManager.class) {
                if (instance == null) {
                    instance = new AccountManager();
                }
            }
        }
        return instance;
    }

    public void createAccount(String accountName, double initialAmount) {
        if (!accounts.containsKey(accountName)) {
            accounts.put(accountName, initialAmount);
            System.out.println("Account created: " + accountName);
        } else {
            System.out.println("Account already exists: " + accountName);
        }
    }

    public void deposit(String account, double amount) {
        if (accounts.containsKey(account)) {
            accounts.put(account, accounts.get(account) + amount);
            System.out.println("Deposited " + amount + " to " + account);
        } else {
            System.out.println("Account does not exist: " + account);
        }
    }

    public void withdraw(String account, double amount) {
        if (accounts.containsKey(account)) {
            double currentAmount = accounts.get(account);
            if (currentAmount - amount < 0) {
                System.out.println("Insufficient funds: " + currentAmount);
            } else {
                accounts.put(account, accounts.get(account) - amount);
                System.out.println("Withdrawn " + amount + " to " + account);
            }
        } else {
            System.out.println("Account does not exist: " + account);
        }
    }

    public void getBalance(String account) {
        if (accounts.containsKey(account)) {
            System.out.println("Balance: " + accounts.get(account));
        } else {
            System.out.println("Account does not exist: " + account);
        }
    }

    public void getAccounts() {
        System.out.println("Active accounts: ");
        for (String accountID : accounts.keySet()) {
            System.out.println("Account ID: " + accountID);
        }
    }

}
