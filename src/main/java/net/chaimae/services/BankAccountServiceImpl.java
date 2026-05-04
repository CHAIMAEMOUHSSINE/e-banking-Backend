package net.chaimae.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.chaimae.entities.BankAccount;
import net.chaimae.entities.CurrentAccount;
import net.chaimae.entities.Customer;
import net.chaimae.enums.AccountStatus;
import net.chaimae.exceptions.CustomerNotFoundException;
import net.chaimae.repositories.AccountOperationRepository;
import net.chaimae.repositories.BankAccountRepository;
import net.chaimae.repositories.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j
public class BankAccountServiceImpl implements BankAccountService {
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;



        @Override
        public Customer saveCustomer(Customer customer) {
            log.info("Saving new customer {} ",customer.getName());
            Customer savedCustomor=customerRepository.save(customer);
            return savedCustomor;
        }

        @Override
        public BankAccount saveBankAccount(double initialBalance, double interestRate, String Type, Long customerId) {
            Customer customer=customerRepository.findById(customerId).orElse(null);
            BankAccount bankAccount;
            if(customer==null)
                throw new CustomerNotFoundException("Customer not found");
            CurrentAccount currentAccount=new CurrentAccount();
            currentAccount.setId(UUID.randomUUID().toString());
            currentAccount.setCreatedAt(new Date());
            currentAccount.setBalance(initialBalance);
            currentAccount.setOverDraft(overDraft);
            currentAccount.setCustomer(customer);
            CurrentAccount savedBankAccount = bankAccountRepository.save(currentAccount);

        }

        @Override
        public List<Customer> listCustomers() {
            return null;
        }

        @Override
        public BankAccount getBankAccount(String accountId) {
            return null;
        }

        @Override
        public void debit(String accountId, double amount, String description) {

        }

        @Override
        public void credit(String accountId, double amount, String description) {

        }

        @Override
        public void transfer(String accountIdSource, String accountIdDestination, double amount) {

        }

        @Override
        public List<BankAccount> bankAccountList() {
            return null;
        }

        @Override
        public List<Customer> searchCustomers(String keyword) {
            return null;
        }
}
