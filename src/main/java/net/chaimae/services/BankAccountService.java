package net.chaimae.services;

import net.chaimae.entities.BankAccount;
import net.chaimae.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialBalance, double interestRate, String Type, Long customerId);
    List<Customer> listCustomers();
        BankAccount getBankAccount(String accountId);
        void debit(String accountId, double amount, String description);
        void credit(String accountId, double amount, String description);
        void transfer(String accountIdSource, String accountIdDestination, double amount);
        List<BankAccount> bankAccountList();
        List<Customer> searchCustomers(String keyword);
}
