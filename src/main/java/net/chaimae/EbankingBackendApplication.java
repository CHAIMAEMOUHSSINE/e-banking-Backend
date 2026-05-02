package net.chaimae;

import net.chaimae.repositories.AccountOperationRepository;
import net.chaimae.repositories.BankAccountRepository;
import net.chaimae.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EbankingBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankingBackendApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository) {
        BankAccountRepository bankAccountRepository,
        AccountOperationRepository accountOperationRepository) {
        return args -> {
            System.out.println("Hello world");
        };
    }

}
